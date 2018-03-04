package com.jzheadley.poli.UI

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.EditText
import android.widget.RadioGroup
import com.jzheadley.poli.R
import kotlinx.android.synthetic.main.policy_list_activity.*

class PolicyListActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.policy_list_activity)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

    }
}