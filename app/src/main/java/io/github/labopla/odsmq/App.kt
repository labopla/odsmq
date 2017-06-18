package io.github.labopla.odsmq

import android.app.Application
import dagger.Provides
import javax.inject.Singleton



class App() : Application() {

    private var mApplication: Application? = null

    fun App(mApplication: Application){
        this.mApplication = mApplication
    }

    @Provides
    @Singleton
    fun provideApplication(): Application? {
        return mApplication
    }
}
