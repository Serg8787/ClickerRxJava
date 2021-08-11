package com.example.clicker

import android.os.SystemClock
import android.util.Log
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableCreate

class HeavyProcess {

    fun getThreeToStart(): Observable<String> {
        return ObservableCreate { subcrumber ->
            val s = arrayListOf("3", "2", "1", "Start","")
            for ((i, value) in s.withIndex()) {
                subcrumber.onNext(value)
                SystemClock.sleep(1000)
            }
        }
    }

    fun getSeconds(seconds: Int): Observable<Int> {
        return ObservableCreate { subcrumber ->
            SystemClock.sleep(4000)
            for (i in seconds downTo 0) {
                subcrumber.onNext(i)
                SystemClock.sleep(1000)
            }
        }
    }

    fun stop() {
        HeavyProcess().stop()
    }

}