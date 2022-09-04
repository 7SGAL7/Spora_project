package com.example.corrutina.main.data

import com.example.corrutina.main.presentation.observables.MainObservable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


object ItemsProvider {
    val observable = MainObservable<List<String>>(emptyList())
    private var values = emptyList<String>()
    private val random = Random(System.currentTimeMillis())

    fun startEmitting(){
        GlobalScope.launch{
            for(num in 0 .. 10){
                delay(2000)
                values = values + random.nextInt().toString()
                observable.updateValue(values)
            }
        }
    }

}