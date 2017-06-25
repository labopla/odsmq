package io.github.labopla.odsmq

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.factory
import com.github.salomonbrys.kodein.singleton
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.github.labopla.odsmq.models.Quest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by pipikapu on 2017/06/25.
 */
class KodeinTest {
}

val kdoeinSingleton = Kodein{
    bind<Gson>() with singleton { GsonBuilder().create() }
    bind<OkHttpClient>() with singleton {
        OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
    }
}