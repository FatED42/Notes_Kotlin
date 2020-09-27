package com.example.notes_kotlin.ui.main

import androidx.lifecycle.Observer
import com.example.notes_kotlin.data.NotesRepository
import com.example.notes_kotlin.data.entity.Note
import com.example.notes_kotlin.data.model.NoteResult
import com.example.notes_kotlin.ui.base.BaseViewModel

class MainViewModel(val notesRepository: NotesRepository) : BaseViewModel<List<Note>?, MainViewState>(){

    private val notesObserver = Observer<NoteResult> {result ->
        result ?: return@Observer
        when(result){
            is NoteResult.Success<*> -> viewStateLiveData.value = MainViewState(notes = result.data as? List<Note>)
            is NoteResult.Error -> viewStateLiveData.value = MainViewState(error = result.error)
        }
    }

    private val notesRepo = notesRepository.getNotes()
    init {
        viewStateLiveData.value = MainViewState()
        notesRepo.observeForever(notesObserver)
    }

    override fun onCleared() {
        super.onCleared()
        notesRepo.removeObserver(notesObserver)
    }
}