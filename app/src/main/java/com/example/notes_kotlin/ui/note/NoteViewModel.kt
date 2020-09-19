package com.example.notes_kotlin.ui.note

import androidx.lifecycle.ViewModel
import com.example.notes_kotlin.data.NotesRepository
import com.example.notes_kotlin.data.entity.Note

class NoteViewModel : ViewModel() {

    private var pendingNote: Note? = null

    fun save(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let {
            NotesRepository.saveNote(it)
        }
    }

}