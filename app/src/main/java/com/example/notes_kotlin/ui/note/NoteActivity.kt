package com.example.notes_kotlin.ui.note

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.example.notes_kotlin.R
import com.example.notes_kotlin.data.entity.Note
import kotlinx.android.synthetic.main.activity_note.*
import java.text.SimpleDateFormat
import java.util.*

class NoteActivity: AppCompatActivity() {

    companion object{
        private const val NOTE_KEY = "note"
        private const val DATE_FORMAT = "dd.MM.yy HH:mm"

        fun start(context: Context, note: Note? = null) = Intent(context, NoteActivity::class.java).apply {
            putExtra(NOTE_KEY, note)
            context.startActivity(this)
        }
    }

    private var note: Note? = null
    lateinit var viewModel: NoteViewModel

    val textWatcher = object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            saveNote()
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        note = intent.getParcelableExtra(NOTE_KEY)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        supportActionBar?.title = note?.let {
            SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(it.lastChanged)
        } ?: getString(R.string.new_note)

        initView()
    }

    private fun initView() {
        note?.let {
            et_title.setText(it.title)
            et_body.setText(it.text)
            val color = when(it.color){
                Note.Color.WHITE -> R.color.white
                Note.Color.VIOLET -> R.color.violet
                Note.Color.YELLOW -> R.color.yellow
                Note.Color.RED -> R.color.red
                Note.Color.PINK -> R.color.pink
                Note.Color.GREEN -> R.color.green
            }
            toolbar.setBackgroundColor(ResourcesCompat.getColor(resources, color, null))
        }
        et_title.addTextChangedListener(textWatcher)
        et_body.addTextChangedListener(textWatcher)
    }

    private fun saveNote() {
        et_title.text?.let {
            if (it.length < 3) return
        } ?: return

        note = note?.copy(
            title = et_title.text.toString(),
            text = et_body.text.toString(),
            lastChanged = Date()
        ) ?: Note(UUID.randomUUID().toString())

        note?.let { viewModel.save(it) }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}