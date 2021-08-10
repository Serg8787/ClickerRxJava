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
        val prefs = context?.getSharedPreferences("shared", Context.MODE_PRIVATE)
        val result: Int? = prefs?.getInt("result",2)
        Log.d("MyLog",result.toString())
         if(result!=null && result > tvRecordSprint1.text.toString().toInt()){
             tvRecordSprint1.text = result.toString()
         }





    }


}