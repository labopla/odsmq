package io.github.labopla.odsmq

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy
import io.github.labopla.odsmq.network.debugModule
import io.github.labopla.odsmq.network.releaseModule


class App() : Application(), KodeinAware {

    override val kodein by Kodein.lazy{
        import(debugModule)
    }

    override fun onCreate() {
        super.onCreate()
    }
}
