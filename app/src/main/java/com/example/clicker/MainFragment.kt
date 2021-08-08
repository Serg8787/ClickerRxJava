package com.example.clicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        tvAboutDeveloper.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_aboutDeveloperFragment)}

        tvCompetition.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_competionFragment)
        }
        tvRecord.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_hallOfFameFragment)
        }

    }

}