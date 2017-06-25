package io.github.labopla.odsmq.modules

import android.app.Application

class AppModule(app: Application) {

    private val mApplication = app

    fun provideApplication(): Application{
        return this.mApplication
    }

}