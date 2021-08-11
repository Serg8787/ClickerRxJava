package com.example.clicker

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_play_game.*

class PlayGameFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_game, container, false)
    }

    @SuppressLint("CommitPrefEdits", "CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val countLevel: Int = requireArguments().get("countLevel").toString().toInt()
        var countResult: Int = 0

        val prefsSprint = context?.getSharedPreferences("sharedSprintNew", Context.MODE_PRIVATE)
        val resultSprintNew: Int? = prefsSprint?.getInt("resultSprintNew", 0)

        val prefsMiddle = context?.getSharedPreferences("sharedMiddleNew", Context.MODE_PRIVATE)
        val resultMiddleNew: Int? = prefsMiddle?.getInt("resultMiddleNew", 0)

        val prefsLong = context?.getSharedPreferences("sharedLongNew", Context.MODE_PRIVATE)
        val resultLongNew: Int? = prefsLong?.getInt("resultLongNew", 0)

        HeavyProcess().getThreeToStart().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                tvThreeToStart.text = it
                if (tvThreeToStart.text.equals("")) {
                    tvThreeToStart.visibility = View.GONE }
            },{Log.d("MyLog", "Mistake") })

        HeavyProcess().getSeconds(countLevel).subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                tvTimer.visibility = View.VISIBLE
                if (it < 10) {
                    tvTimer.text = "00 : 0$it"
                } else {
                    tvTimer.text = "00 : $it"
                }
                if (tvTimer.text.equals(getString(R.string.null_time))) {
                    tvTimer.visibility = View.GONE
                    clRoot.isEnabled = false
                    tvResult.visibility = View.VISIBLE
                    tvResult.text = "Your\nResult\n${countResult}"
                }
                clRoot.setOnClickListener {
                    countResult++
                    Log.d("MyLog", countResult.toString())
                    if (countLevel == 10) {
                        if (countResult > resultSprintNew!!) {
                            tvNewRecord.visibility = View.VISIBLE
                            tvNewRecord.text ="New Record ${countResult}"
                            val sharedPreferences =
                                context?.getSharedPreferences("sharedSprint", Context.MODE_PRIVATE)
                            val editor = sharedPreferences?.edit()
                            editor.apply {
                                this!!.putInt("resultSprint", countResult)
                            }?.apply()
                        }
                    } else if(countLevel==20){
                        if (countResult > resultMiddleNew!!) {
                            tvNewRecord.visibility = View.VISIBLE
                            tvNewRecord.text ="New Record ${countResult}"
                            val sharedPreferences =
                                context?.getSharedPreferences("sharedMiddle", Context.MODE_PRIVATE)
                            val editor = sharedPreferences?.edit()
                            editor.apply {
                                this!!.putInt("resultMiddle", countResult)
                            }?.apply()
                        }
                    } else {
                        if (countResult > resultLongNew!!) {
                            tvNewRecord.visibility = View.VISIBLE
                            tvNewRecord.text ="New Record ${countResult}"
                            val sharedPreferences =
                                context?.getSharedPreferences("sharedLong", Context.MODE_PRIVATE)
                            val editor = sharedPreferences?.edit()
                            editor.apply {
                                this!!.putInt("resultLong", countResult)
                            }?.apply()
                        }
                    }
                }

            }, { Log.d("MyLog", "Mistake")})
    }

}
