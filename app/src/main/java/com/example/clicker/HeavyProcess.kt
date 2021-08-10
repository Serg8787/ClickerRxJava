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

class HeavyProcess {

    fun getStrTimer(): Observable<String> {
        return ObservableCreate { subcrumber ->
            val s = arrayListOf ("3","2","1","Start",
                "00:10",
                "00:09",
                "00:08",
                "00:07",
                "00:06",
                "00:05",
                "00:04",
                "00:03",
                "00:02",
                "00:01",
                "00:00",
            )
            for ((i,value ) in s.withIndex()) {
                subcrumber.onNext(value)
                SystemClock.sleep(1000)
            }
        }
    }

}