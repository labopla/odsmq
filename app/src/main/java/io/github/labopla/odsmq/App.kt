package io.github.labopla.odsmq

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy
import io.github.labopla.odsmq.network.debugModule
import io.github.labopla.odsmq.network.releaseModule


class App() : Application(), KodeinAware {

    override val kodein by Kodein.lazy{
        when(BuildConfig.FLAVOR){
            "debug" -> import(debugModule)
            "release" -> import(releaseModule)
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}
