package com.example.clicker

import android.os.SystemClock
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.internal.operators.observable.ObservableCreate
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_new_competion.*

class ThreeToStart {
    fun getStr(): Observable<String> {
        return ObservableCreate { subcrumber ->
            val s = arrayListOf ("Three","Two","One","Start","")
            for ((i,value ) in s.withIndex()) {
                subcrumber.onNext(value)
                SystemClock.sleep(1000)
            }
        }
    }


}