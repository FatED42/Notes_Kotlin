package com.example.notes_kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    private val viewStateLiveData = MutableLiveData<String>()
    private val model = Model()

    init {
        viewStateLiveData.value = "Hello!"
        model.counterLiveData.observeForever {
            viewStateLiveData.postValue(it.toString())
        }
    }

    fun getViewState(): LiveData<String> = viewStateLiveData

    fun CounterClick() = model.CounterClick()
}