package com.example.notes_kotlin.data.provider

import androidx.lifecycle.LiveData
import com.example.notes_kotlin.data.entity.Note
import com.example.notes_kotlin.data.model.NoteResult

interface DataProvider {
    fun subscribeToAllNotes(): LiveData<NoteResult>
    fun saveNote(note: Note): LiveData<NoteResult>
    fun getNoteById(id: String): LiveData<NoteResult>
}