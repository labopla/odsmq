package io.github.labopla.odsmq

import android.app.Application
import com.github.salomonbrys.kodein.*
import io.github.labopla.odsmq.modules.*
import io.github.labopla.odsmq.modules.debugModule
import io.github.labopla.odsmq.modules.releaseModule

class App() : Application() , KodeinAware{

    override val kodein: Kodein by  Kodein.lazy {
        import(appModule(this@App))
        when(BuildConfig.FLAVOR){
            "debug" -> import(debugModule)
            "release" -> import(releaseModule)
        }
    }

    override fun onCreate() {
        super.onCreate()
    }

}
