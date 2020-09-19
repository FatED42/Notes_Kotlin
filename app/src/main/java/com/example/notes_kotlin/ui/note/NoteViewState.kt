package com.example.notes_kotlin.ui.note

import com.example.notes_kotlin.data.entity.Note
import com.example.notes_kotlin.ui.base.BaseViewState

class NoteViewState(note: Note? = null, error: Throwable? = null) : BaseViewState<Note?>(note, error) {
}