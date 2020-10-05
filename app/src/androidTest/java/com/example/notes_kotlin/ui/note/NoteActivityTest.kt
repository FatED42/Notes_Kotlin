package com.example.notes_kotlin.ui.note

import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.notes_kotlin.R
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext
import org.koin.standalone.StandAloneContext.loadKoinModules

class NoteActivityTest {

    @get:Rule
    val activityTestRule = IntentsTestRule(NoteActivity::class.java, true, false)

    private val model: NoteViewModel = mockk(relaxed = true)
    private val viewStateLiveData = MutableLiveData<NoteViewState>()

    @Before
    fun setup() {
        loadKoinModules ( listOf ( module { viewModel{ model } } ) )

        every {  model.getViewState() } returns viewStateLiveData
        activityTestRule.launchActivity(null)
    }

    @After
    fun teardown(){
        StandAloneContext.stopKoin()
    }

    @Test
    fun check_color_picker_showed() {
        onView(withId(R.id.palette)).perform(click())
        onView(withId(R.id.colorPicker)).check(matches(isDisplayed()))
    }


    @Test
    fun check_deleteNote_do_deleting() {
        onView(withId(R.id.delete)).perform(click())
        onView(withText(R.string.delete_note_dialog_ok)).perform(click())
        verify (exactly = 1) {  model.deleteNote() }
    }

}