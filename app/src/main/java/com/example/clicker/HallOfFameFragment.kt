package com.example.clicker

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_hall_of_fame.*


/**
 * A simple [Fragment] subclass.
 * Use the [HallOfFameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HallOfFameFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hall_of_fame, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prefsSprint = context?.getSharedPreferences("sharedSprint", Context.MODE_PRIVATE)
        val resultSprint: Int? = prefsSprint?.getInt("resultSprint", 0)
        if (resultSprint != null && resultSprint > tvRecordSprint1.text.toString().toInt()) {
            tvRecordSprint1.text = "${resultSprint}"
            val newRecordSprint = tvRecordSprint1.text.toString().toInt()
            val sharedPreferences =
                context?.getSharedPreferences("sharedSprintNew", Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()
            editor.apply {
                this!!.putInt("resultSprintNew", newRecordSprint)
            }?.apply()
            }
            val prefsMiddle =
                context?.getSharedPreferences("sharedMiddle", Context.MODE_PRIVATE)
            val resultMiddle: Int? = prefsMiddle?.getInt("resultMiddle", 0)
            if (resultMiddle != null && resultMiddle > tvRecordMiddle1.text.toString().toInt()) {
                tvRecordMiddle1.text = "${resultMiddle}"
                val newRecordMiddle = tvRecordMiddle1.text.toString().toInt()
                val sharedPreferences =
                    context?.getSharedPreferences("sharedMiddleNew", Context.MODE_PRIVATE)
                val editor = sharedPreferences?.edit()
                editor.apply {
                    this!!.putInt("resultMiddleNew", newRecordMiddle)
                }?.apply()
            }

            val prefsLong =
                context?.getSharedPreferences("sharedLong", Context.MODE_PRIVATE)
            val resultLong: Int? = prefsLong?.getInt("resultLong", 0)
            if (resultLong != null && resultLong > tvRecordLong1.text.toString().toInt()) {
                tvRecordLong1.text = "${resultLong}"
                val newRecordLong = tvRecordLong1.text.toString().toInt()
                val sharedPreferences =
                    context?.getSharedPreferences("sharedLongNew", Context.MODE_PRIVATE)
                val editor = sharedPreferences?.edit()
                editor.apply {
                    this!!.putInt("resultLongNew", newRecordLong)
                }?.apply()
            }
        }
    }
