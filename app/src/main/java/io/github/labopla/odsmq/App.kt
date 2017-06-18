package io.github.labopla.odsmq

import android.app.Application
import dagger.Provides
import javax.inject.Singleton



class App(mApplication: Application) : Application() {

    private var mApplication: Application? = mApplication

    @Provides
    @Singleton
    fun provideApplication(): Application? {
        return mApplication
    }
}
