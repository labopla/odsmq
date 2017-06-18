package io.github.labopla.odsmq

import android.app.Application
import dagger.Provides
import io.github.labopla.odsmq.components.AppComponent
import io.github.labopla.odsmq.modules.ApiModule
import io.github.labopla.odsmq.modules.AppModule
import javax.inject.Singleton



class App() : Application() {

    private var mAppComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    private fun initializeInjector(){
        /*
        mAppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
                */
    }

    fun getAppComponent(): AppComponent?{
        return mAppComponent
    }

}
