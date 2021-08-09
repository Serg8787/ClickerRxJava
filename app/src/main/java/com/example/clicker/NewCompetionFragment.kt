package com.example.clicker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_new_competion.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [CompetionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompetionFragment : Fragment() {
    var countLevel = 0


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
            countLevel = 10
            btSprint1Distance10sec.isEnabled = true
            btLongDistanse30sec.visibility = View.GONE
            btMiddleDistance20sec.visibility = GONE

        }
        btMiddleDistance20sec.setOnClickListener {
            countLevel = 20
            btMiddleDistance20sec.isEnabled = true
            btSprint1Distance10sec.visibility = GONE
            btLongDistanse30sec.visibility = GONE
        }
        btLongDistanse30sec.setOnClickListener {
            countLevel = 30
            btSprint1Distance10sec.visibility = GONE
            btLongDistanse30sec.visibility = GONE
            btLongDistanse30sec.isEnabled = true
        }

        btStart.setOnClickListener {
            val args = Bundle().apply {
            }
           findNavController().navigate(R.id.action_competionFragment_to_playGameFragment,args)
        }



    }


}