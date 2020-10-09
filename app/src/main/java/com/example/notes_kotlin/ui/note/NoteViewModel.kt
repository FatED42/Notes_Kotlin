package com.example.notes_kotlin.ui.note

import com.example.notes_kotlin.data.NotesRepository
import com.example.notes_kotlin.data.entity.Note
import com.example.notes_kotlin.data.model.NoteResult
import com.example.notes_kotlin.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class NoteViewModel(val notesRepository: NotesRepository) : BaseViewModel<NoteData>() {

    private var pendingNote: Note? = null

    fun save(note: Note) {
        pendingNote = note
    }

    fun loadNote(noteId: String) = launch{
        try {
            notesRepository.getNoteById(noteId)?.let {
                setData(NoteData(note = it))
            }
        } catch (e: Throwable){
            setError(e)
        }
    }

    fun deleteNote() = launch {
        try {
            pendingNote?.let { notesRepository.deleteNote(it.id) }
            setData(NoteData(isDeleted = true))
        } catch (e: Throwable){
            setError(e)
        }
    }

    override fun onCleared() {
        launch {
            pendingNote?.let {
                notesRepository.saveNote(it)
            }
        }
    }
}