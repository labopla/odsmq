package io.github.labopla.odsmq.components

import dagger.Component
import io.github.labopla.odsmq.activities.MainActivity
import io.github.labopla.odsmq.modules.ApiModule
import io.github.labopla.odsmq.modules.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class))
interface AppComponent {
    //利用するActivityに変更する
    fun inject(activity: MainActivity)
}