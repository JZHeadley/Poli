package com.jzheadley.poli.UI

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import com.google.gson.Gson
import com.jzheadley.poli.R
import com.jzheadley.poli.base.BaseApplication
import com.jzheadley.poli.models.Bill
import com.jzheadley.poli.models.User
import com.jzheadley.poli.models.Vote
import com.jzheadley.poli.network.PoliApi
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.policy_activity.*
import timber.log.Timber
import java.sql.Date
import java.util.*
import javax.inject.Inject


class PolicyActivity() : AppCompatActivity() {
    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var api: PoliApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.policy_activity)
        policyTextView.setMovementMethod(ScrollingMovementMethod())
        (this.application as BaseApplication).netComponent.inject(this)

        Timber.v("Extras of the PolicyActivity:\t%s", intent.extras.keySet().toList().toString())
        val bill: Bill = gson.fromJson(intent.extras["bill"].toString(), Bill::class.java)
        policyTextView.text = bill.summary
        voteButton.setOnClickListener({ handleVote(bill) })
    }

    private fun handleVote(bill: Bill) {
        val selectedId = yesNoGroup.checkedRadioButtonId
        var support: Boolean = false
        Timber.v(
                "Selected Id:\t$selectedId")
        when (selectedId) {
            R.id.yesRadioButton -> support = true
            R.id.noRadioButton -> support = false
        }
        val vote: Vote = Vote(
                null,
                User("9d05d338-d18e-4751-a7af-6d64f3ac12a1", null, null, null, null, null, null, null, null, null, null),
                bill,
                Date(Date().time),
                support,
                ""
        )
        api.submitVote(vote)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Void> {
                    override fun onNext(aVoid: Void) {
                        Timber.v("Submitting the users vote")
                    }

                    override fun onComplete() {
                        finish()
                    }

                    override fun onError(e: Throwable) {
                        Timber.wtf(e, "Something went worng in submitting the user's vote")
                        finish()
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                })
    }

}