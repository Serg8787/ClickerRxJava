package com.example.clicker

import android.content.Context
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.fragment_play_game.*

class Help {

//    HeavyProcess().getStrTimer().subscribeOn(Schedulers.newThread())
//    .observeOn(AndroidSchedulers.mainThread()).subscribe ({
//        tvStartTimer.text = it
//        if (it.equals("00:10")) {
//            tvStartTimer.background = resources.getDrawable(R.drawable.back_record_long)
//            clRoot.setOnClickListener {
//                countResult++
//                Log.d("MyLog", countResult.toString())
//                if (countLevel == 10) {
//                    val sharedPreferences =
//                        context?.getSharedPreferences("sharedSprint", Context.MODE_PRIVATE)
//                    val editor = sharedPreferences?.edit()
//                    editor.apply {
//                        this!!.putInt("resultSprint", countResult)
//                    }?.apply()
//                } else if (countLevel == 20) {
//                    val sharedPreferences =
//                        context?.getSharedPreferences("sharedMiddle", Context.MODE_PRIVATE)
//                    val editor = sharedPreferences?.edit()
//                    editor.apply {
//                        this!!.putInt("resultMiddle", countResult)
//                    }?.apply()
//                } else {
//                    val sharedPreferences =
//                        context?.getSharedPreferences("sharedLong", Context.MODE_PRIVATE)
//                    val editor = sharedPreferences?.edit()
//                    editor.apply {
//                        this!!.putInt("resultLong", countResult)
//                    }?.apply()
//                }
//            }
//        }
//        if (it.equals("00:00")) {
//            clRoot.isEnabled = false
//            tvStartTimer.visibility = View.GONE
//            tvResult.visibility = View.VISIBLE
//            tvResult.text = "Your\nresult\n${countResult}"
//            if(countLevel==10){
//                val prefsSprint = context?.getSharedPreferences("sharedSprintNew", Context.MODE_PRIVATE)
//                val resultSprintNew: Int? = prefsSprint?.getInt("resultSprintNew", 0)
//                if(countResult> resultSprintNew!!){
//                    tvNewRecord.visibility = View.VISIBLE
//                }
//            }
//            if(countLevel==20) {
//                val prefsSprint =
//                    context?.getSharedPreferences("sharedMiddleNew", Context.MODE_PRIVATE)
//                val resultMiddleNew: Int? = prefsSprint?.getInt("resultMiddleNew", 0)
//                if (countResult > resultMiddleNew!!) {
//                    tvNewRecord.visibility = View.VISIBLE
//                }
//            }
//            if(countLevel==30){
//                val prefsSprint =
//                    context?.getSharedPreferences("sharedLongNew", Context.MODE_PRIVATE)
//                val resultLongNew: Int? = prefsSprint?.getInt("resultLongNew", 0)
//                if (countResult > resultLongNew!!) {
//                    tvNewRecord.visibility = View.VISIBLE
//                }
//            }
//        }
//    },{
//        Log.d("MyLog","Mistake")
//    })

}