package com.example.notes_kotlin.ui.main

import androidx.annotation.VisibleForTesting
import com.example.notes_kotlin.data.NotesRepository
import com.example.notes_kotlin.data.entity.Note
import com.example.notes_kotlin.data.model.NoteResult
import com.example.notes_kotlin.ui.base.BaseViewModel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch

class MainViewModel(notesRepository: NotesRepository) : BaseViewModel<List<Note>?>(){

    private val notesChannel = notesRepository.getNotes()
    init {
        launch {
            notesChannel.consumeEach {
                when(it){
                    is NoteResult.Success<*> -> setData(it.data as? List<Note>)
                    is NoteResult.Error -> setError(it.error)
                }
            }
        }
    }

    @VisibleForTesting
    public override fun onCleared() {
        super.onCleared()
        notesChannel.cancel()
    }
}