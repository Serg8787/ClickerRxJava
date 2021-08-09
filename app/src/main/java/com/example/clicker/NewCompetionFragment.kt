package com.example.clicker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_new_competion.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [CompetionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompetionFragment : Fragment() {
    var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_competion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btSprint1Distance10sec.setOnClickListener {
            count = 1
            btSprint1Distance10sec.isEnabled = true
            btLongDistanse30sec.isEnabled = false
            btMiddleDistance20sec.isEnabled = false
        }
        btLongDistanse30sec.setOnClickListener {
            count = 30
            btSprint1Distance10sec.isEnabled = false
            btLongDistanse30sec.isEnabled = true
            btMiddleDistance20sec.isEnabled = false
        }
        btMiddleDistance20sec.setOnClickListener {
            count = 30
            btSprint1Distance10sec.isEnabled = false
            btLongDistanse30sec.isEnabled = false
            btMiddleDistance20sec.isEnabled = true
        }
        btStart.setOnClickListener {
            clWithBtLevel.visibility = View.GONE
            clResult.visibility = View.VISIBLE

            val dispose =ThreeToStart().getStr().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    tvThreeToStart.text = it
                })


        }



    }


}