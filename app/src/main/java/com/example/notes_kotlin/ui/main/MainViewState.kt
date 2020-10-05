package com.example.notes_kotlin.ui.main

import com.example.notes_kotlin.data.entity.Note
import com.example.notes_kotlin.ui.base.BaseViewState

class MainViewState(val notes: List<Note>? = null, error: Throwable? = null): BaseViewState<List<Note>?>(notes, error)