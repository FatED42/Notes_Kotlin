package com.example.notes_kotlin.data

import com.example.notes_kotlin.data.entity.Note
import com.example.notes_kotlin.data.provider.DataProvider
import com.example.notes_kotlin.data.provider.FirestoreProvider

object NotesRepository {

    private val dataProvider: DataProvider = FirestoreProvider()

    fun getNotes() = dataProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = dataProvider.saveNote(note)
    fun getNoteById(id: String) = dataProvider.getNoteById(id)
}
