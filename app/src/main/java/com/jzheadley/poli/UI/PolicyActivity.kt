package com.jzheadley.poli.UI

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.*
import com.jzheadley.poli.R
import kotlinx.android.synthetic.main.policy_activity.*
import android.text.method.ScrollingMovementMethod




class PolicyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.policy_activity)
        policyTextView.setMovementMethod(ScrollingMovementMethod())
    }

}