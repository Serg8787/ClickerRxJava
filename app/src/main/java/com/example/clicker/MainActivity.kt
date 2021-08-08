package com.example.clicker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()



        tvAboutDeveloper.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.flAboutDeveloper, AboutDeveloperFragment.newInstance("",""))
                .addToBackStack(null).commit()
        }
    }
}