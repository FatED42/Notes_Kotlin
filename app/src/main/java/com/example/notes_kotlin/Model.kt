package com.example.notes_kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Model {
    private val _counterLiveData = MutableLiveData<Int>()
    val counterLiveData: LiveData<Int> = _counterLiveData
    private var counter = 0

    fun CounterClick() = _counterLiveData.postValue(++counter)
}