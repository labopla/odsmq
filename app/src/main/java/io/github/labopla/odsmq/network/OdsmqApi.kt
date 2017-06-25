package io.github.labopla.odsmq.network

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import io.github.labopla.odsmq.enums.Category
import io.github.labopla.odsmq.enums.Status
import io.github.labopla.odsmq.models.Quest
import io.github.labopla.odsmq.models.User
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class OdsmqApi : IOdsmqApi{
    override fun acceptQuest(questId: Long): Observable<Quest> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createQuest(quest: Quest): Observable<Quest> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteQuest(questId: Long): Observable<Quest> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllQuests(): Observable<MutableList<Quest>> = Observable.just (
        mutableListOf(
                Quest(0, Category.a, User(0, "pipikapu", "pipikapu@gmail.com"), 201708051245, "detail", "rewards", Status.WANTED),
                Quest(1, Category.b, User(1, "mimivon", "mimivon@gmail.com"), 201705021222, "detail", "rewards", Status.CLEARED),
                Quest(2, Category.a, User(0, "pipikapu", "pipikapu@gmail.com"), 201705091832, "detail", "rewards", Status.CLOSED)
        )
    )
}

val debugModule = Kodein.Module{
    bind<IOdsmqApi>() with instance(OdsmqApi())
}

val releaseModule = Kodein.Module{
    bind<IOdsmqApi>() with instance(Retrofit.Builder()
            .baseUrl("TODO")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
            .create(IOdsmqApi::class.java)
    )
}
