package io.github.labopla.odsmq.network

import io.github.labopla.odsmq.models.Quest
import io.reactivex.Observable
import retrofit2.http.*


interface IOdsmqApi {

    @GET("quests/getAll")
    fun getAllQuests(): Observable<MutableList<Quest>>

    @PUT("quests/create")
    fun createQuest(@Query("quest") quest: Quest): Observable<Quest>

    @DELETE("quests/delete")
    fun deleteQuest(@Query("quest") quest: Quest): Observable<Quest>

    @POST("quests/accept")
    fun acceptQuest(@Query("quest") quest: Quest): Observable<Quest>

}