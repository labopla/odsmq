package io.github.labopla.odsmq.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(app: Application) {

    private val mApplication = app

    @Provides
    @Singleton
    fun provideApplication(): Application{
        return this.mApplication
    }

}