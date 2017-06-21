package io.github.labopla.odsmq.modules

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import io.github.labopla.odsmq.models.Quest
import io.github.labopla.odsmq.network.IOdsmqApi
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class OdsmqModule : IOdsmqApi {
    override fun getAllQuests(): Observable<MutableList<Quest>> = Observable.just(mutableListOf())
    override fun createQuest(quest: Quest): Observable<Quest> = Observable.just(quest)
    override fun acceptQuest(quest: Quest): Observable<Quest> = Observable.just(quest)
    override fun deleteQuest(quest: Quest): Observable<Quest> = Observable.just(quest)
}

val debugModule = Kodein.Module {
    bind<OdsmqModule>() with instance(OdsmqModule())
}

val releaseModule = Kodein.Module {
    bind<IOdsmqApi>() with instance(
            Retrofit.Builder()
                    .baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build()
                    .create(IOdsmqApi::class.java)
    )
}