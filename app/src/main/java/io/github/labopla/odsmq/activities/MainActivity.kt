package io.github.labopla.odsmq.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.github.labopla.odsmq.R
import io.github.labopla.odsmq.models.Quest
import io.github.labopla.odsmq.network.OdsmqApi
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Retrofit.Builder().build().create(OdsmqApi::class.java)
                .getAllQuests()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object: Observer<List<Quest>> {
                    override fun onComplete() {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                    override fun onError(e: Throwable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onNext(t: List<Quest>?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onSubscribe(d: Disposable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })

    }

}
