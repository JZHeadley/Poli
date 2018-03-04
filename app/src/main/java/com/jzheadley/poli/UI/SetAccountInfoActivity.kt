package com.jzheadley.poli.UI

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jzheadley.poli.R
import com.jzheadley.poli.base.BaseApplication
import com.jzheadley.poli.models.User
import com.jzheadley.poli.network.PoliApi
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_set_account_info.*
import timber.log.Timber
import java.sql.Date
import javax.inject.Inject

class SetAccountInfoActivity : AppCompatActivity() {

    @Inject
    lateinit var api: PoliApi

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_account_info)
        (application as BaseApplication).netComponent.inject(this)
        submit_demographic_info_btn.setOnClickListener({ submitDemographicInfo() })
    }

    private fun submitDemographicInfo() {
        var user: User = User("",
                editName.text.toString(),
                Date(-1),
                editRace.selectedItem.toString(),
                editGender.selectedItem.toString(),
                maritalSpinner.selectedItem.toString().toUpperCase().replace("\\s".toRegex(), ""),
                editReligion.selectedItem.toString(),
                editIncome.selectedItem.toString(),
                politicalSpinner.selectedItem.toString().toUpperCase(),
                editChildren.selectedItem.toString().toInt(),
                sexualitySpinner.selectedItem.toString().toUpperCase()
        )
        api.submitUserDemographics(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<User> {
                    override fun onNext(user: User) {
                        Timber.v("Submitting user %s", user)
                    }

                    override fun onComplete() {
                        finish()
                    }

                    override fun onError(e: Throwable) {
                        Timber.wtf(e, "Something went worng in submitting the user demographics")
                    }

                    override fun onSubscribe(d: Disposable) {
                        Timber.v("Subscribed to the response of getting the meals of the restaurant")
                    }

                })
    }
}