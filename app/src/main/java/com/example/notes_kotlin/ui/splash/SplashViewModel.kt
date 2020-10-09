package com.example.notes_kotlin.ui.splash

import com.example.notes_kotlin.data.NotesRepository
import com.example.notes_kotlin.data.errors.NoAuthException
import com.example.notes_kotlin.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class SplashViewModel(private val notesRepository: NotesRepository) : BaseViewModel<Boolean?>() {

    fun requestUser() = launch{
        notesRepository.getCurrentUser()?.let {
            setData(true)
        } ?: setError(NoAuthException())
    }

}