package io.github.labopla.odsmq.activities

import android.os.Bundle
import android.widget.TextView
import com.github.salomonbrys.kodein.android.KodeinAppCompatActivity
import com.github.salomonbrys.kodein.instance
import io.github.labopla.odsmq.R
import io.github.labopla.odsmq.network.IOdsmqApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : KodeinAppCompatActivity() {

    val odsmqApi: IOdsmqApi by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val availableQuests = odsmqApi.getAllQuests()
                .map { quests ->
                    quests.map { quest ->
                        //quest.category
                        //quest.client
                        //quest.detail
                        //quest.id
                        //quest.limit
                        //quest.rewards
                        quest.status
                    }
                }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ strings ->
                    (findViewById(R.id.text) as TextView).text = strings.get(0).name
                }


    }

}
