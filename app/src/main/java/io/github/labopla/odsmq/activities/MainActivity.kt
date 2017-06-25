package io.github.labopla.odsmq.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.github.salomonbrys.kodein.android.KodeinAppCompatActivity
import com.github.salomonbrys.kodein.instance
import io.github.labopla.odsmq.R
import io.github.labopla.odsmq.enums.Status
import io.github.labopla.odsmq.network.IOdsmqApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : KodeinAppCompatActivity() {

    val odsmqApi: IOdsmqApi by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //募集中のクエストのみを抽出
        odsmqApi.getAllQuests()
                .map { item ->
                    item.filter { quest ->
                        quest.status == Status.WANTED
                    }.map{quest ->
                        quest.detail
                    }
                }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { details ->
                    (findViewById(R.id.listView) as ListView).adapter =
                            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, details)
                }
    }
}
