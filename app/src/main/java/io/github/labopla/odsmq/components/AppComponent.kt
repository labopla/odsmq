package io.github.labopla.odsmq.components

import io.github.labopla.odsmq.activities.MainActivity
import io.github.labopla.odsmq.modules.ApiModule
import io.github.labopla.odsmq.modules.AppModule

interface AppComponent {
    //利用するActivityに変更する
    fun inject(activity: MainActivity)
}