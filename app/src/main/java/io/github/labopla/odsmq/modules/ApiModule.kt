package io.github.labopla.odsmq.modules

import javax.inject.Singleton
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.github.labopla.odsmq.network.OdsmqApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        val loggingInterceptor : HttpLoggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(loggingInterceptor)
                .addInterceptor(RequestHeaderInterceptor())
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                // ベースのURLの設定
                .baseUrl("http://baseurl.com")
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideOdsmqApi(retrofit: Retrofit): OdsmqApi {
        return retrofit.create(OdsmqApi::class.java)
    }

    class RequestHeaderInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain?): Response {
            val builder = chain?.request()?.newBuilder()
            builder?.addHeader("HEADER", "VALUE")
            return chain?.proceed(builder?.build())!!
        }
    }
}

