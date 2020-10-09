package com.example.notes_kotlin.di

import com.example.notes_kotlin.data.NotesRepository
import com.example.notes_kotlin.data.provider.DataProvider
import com.example.notes_kotlin.data.provider.FirestoreProvider
import com.example.notes_kotlin.ui.main.MainViewModel
import com.example.notes_kotlin.ui.note.NoteViewModel
import com.example.notes_kotlin.ui.splash.SplashViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single<DataProvider> { FirestoreProvider(get(), get()) }
    single { NotesRepository(get()) }
}

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}

val mainModule = module {
    viewModel { MainViewModel(get()) }
}

val noteModule = module {
    viewModel { NoteViewModel(get()) }
}