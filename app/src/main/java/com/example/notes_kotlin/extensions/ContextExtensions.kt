package com.example.notes_kotlin.extensions

import android.content.Context

fun Context.dip(value: Int) = resources.displayMetrics.density * value