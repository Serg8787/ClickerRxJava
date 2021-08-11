package com.example.clicker

import android.annotation.SuppressLint
import android.os.Bundle
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

        HeavyProcess().getThreeToStart().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                tvThreeToStart.text = it
                if (tvThreeToStart.text.equals("Start")) {
                    tvThreeToStart.visibility = View.GONE
                }
            })

        HeavyProcess().getSeconds(countLevel).subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                tvTimer.visibility = View.VISIBLE
                    if (it < 10) {
                        tvTimer.text = "00 : 0$it"
                    } else {
                        tvTimer.text = "00 : $it"
                    }

            })
    }
}