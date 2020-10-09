package com.example.notes_kotlin.data.provider

import com.example.notes_kotlin.data.entity.Note
import com.example.notes_kotlin.data.entity.User
import com.example.notes_kotlin.data.model.NoteResult
import kotlinx.coroutines.channels.ReceiveChannel

interface DataProvider {
    fun subscribeToAllNotes(): ReceiveChannel<NoteResult>

    suspend fun getCurrentUser() : User?
    suspend fun saveNote(note: Note): Note
    suspend fun getNoteById(id: String): Note?
    suspend fun deleteNote(id: String)
}