package io.github.labopla.odsmq.modules

import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance

fun appModule(context: Context) = Kodein.Module {
    bind<Context>() with instance(context)
}
