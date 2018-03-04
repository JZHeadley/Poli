package com.jzheadley.poli.UI

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.jzheadley.poli.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gotoSetAccountInfoButton.setOnClickListener {
            Log.d("MainActivity", "track pushups button pressed")
            val intent = Intent(this, SetAccountInfoActivity::class.java)
            startActivity(intent)
        }

        gotoPolicyButton.setOnClickListener({
            val intent = Intent(this, PolicyActivity::class.java)
            startActivity(intent)
        })

//        gotoPolicyListButton.setOnClickListener( {
//            val intent = Intent(this,PolicyListActivity::class.java)
//            startActivity(intent)
//        })
        gotoViewPagerButton.setOnClickListener({
            val intent = Intent(this, fragment_race_yes::class.java)
            startActivity(intent)
        })
    }
}
