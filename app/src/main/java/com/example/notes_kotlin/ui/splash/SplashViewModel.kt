package com.example.notes_kotlin.ui.splash

import com.example.notes_kotlin.data.NotesRepository
import com.example.notes_kotlin.data.errors.NoAuthException
import com.example.notes_kotlin.ui.base.BaseViewModel

class SplashViewModel() : BaseViewModel<Boolean?, SplashViewState>() {

    fun requestUser() {
        NotesRepository.getCurrentUser().observeForever {
            viewStateLiveData.value = if (it != null) {
                SplashViewState(authenticated = true)
            } else {
                SplashViewState(error = NoAuthException())
            }
        }
    }

}