package com.example.clicker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val countLevel:Int = requireArguments().get("countLevel").toString().toInt()
        var countResult:Int = 0


        val ThreeToStart =ThreeToStart().getStr().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                tvThreeToStart.text = it
                if(tvThreeToStart.text.equals("")){
                    tvThreeToStart.visibility = View.GONE
                    val timer = ThreeToStart().getSeconds(countLevel).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()).subscribe({
                            if(it<10){
                                tvTimer.text = "00 : 0$it"
                            } else{
                                tvTimer.text = "00 : $it"
                            }
                            Log.d("MyLog",it.toString())
                            clRoot.setOnClickListener {
                                countResult++
                                Log.d("MyLOGG",countResult.toString())
                            }
                            if (tvTimer.text.equals("00 : 00")){
                                tvResult.visibility = View.VISIBLE
                                tvResult.text ="Your result\n${countResult}"
                            }
                        })
                }
            })
    }
}