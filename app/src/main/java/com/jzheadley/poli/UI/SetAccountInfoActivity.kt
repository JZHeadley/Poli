package com.jzheadley.poli.UI

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jzheadley.poli.R
import com.jzheadley.poli.models.MaritalStatus
import com.jzheadley.poli.models.PoliticalStanding
import com.jzheadley.poli.models.Sexuality
import com.jzheadley.poli.models.User
import kotlinx.android.synthetic.main.activity_set_account_info.*
import kotlinx.android.synthetic.main.activity_set_account_info.view.*
import timber.log.Timber
import java.sql.Date

class SetAccountInfoActivity : AppCompatActivity() {

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_account_info)
        submit_demographic_info_btn.setOnClickListener({ submitDemographicInfo() })


    }

    private fun submitDemographicInfo() {
        var user: User = User("",
                editName.text.toString(),
                Date(-1),


                editGender.text.toString()
                MaritalStatus.valueOf(maritalSpinner.selectedItem.toString().toUpperCase()),
                editReligion.text.toString(),
                editIncome.text.toString().toDouble(),
                PoliticalStanding.valueOf(politicalSpinner.selectedItem.toString().toUpperCase()),
                editChildren.text.toString().toInt(),
                Sexuality.valueOf(sexualitySpinner.selectedItem.toString().toUpperCase()),
                editRace.selectedItem.toString()
        )
        Timber.v(user.toString())
    }
}