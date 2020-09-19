package com.example.notes_kotlin.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes_kotlin.data.NotesRepository

class MainViewModel() : ViewModel(){
    private val viewStateLiveData = MutableLiveData<MainViewState>()

    init {
        NotesRepository.getNotes().observeForever {
            viewStateLiveData.value = viewStateLiveData.value?.copy(notes = it) ?: MainViewState(it)
        }
    }

    fun getViewState(): LiveData<MainViewState> = viewStateLiveData
}