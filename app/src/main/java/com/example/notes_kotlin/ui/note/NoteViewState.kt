package com.example.notes_kotlin.ui.note

import com.example.notes_kotlin.data.entity.Note
import com.example.notes_kotlin.ui.base.BaseViewState

class NoteViewState(data: Data = Data(), error: Throwable? = null) : BaseViewState<NoteViewState.Data>(data, error) {
    data class Data(val isDeleted: Boolean = false, val note: Note? = null)
}