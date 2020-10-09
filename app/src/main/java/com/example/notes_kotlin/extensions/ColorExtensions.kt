package com.example.notes_kotlin.extensions

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.notes_kotlin.R
import com.example.notes_kotlin.data.entity.Note

fun Note.Color.getColorRes() = when(this){
    Note.Color.WHITE -> R.color.white
    Note.Color.VIOLET -> R.color.violet
    Note.Color.YELLOW -> R.color.yellow
    Note.Color.RED -> R.color.red
    Note.Color.PINK -> R.color.pink
    Note.Color.GREEN -> R.color.green
}

fun Note.Color.getColorInt(context: Context) = ContextCompat.getColor(context, getColorRes())