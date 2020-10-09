package com.example.notes_kotlin.ui.splash

import com.example.notes_kotlin.ui.base.BaseActivity
import com.example.notes_kotlin.ui.main.MainActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity<Boolean?>() {

    override val viewModel: SplashViewModel by viewModel()

    override val layoutRes = null

    override fun onResume() {
        super.onResume()
        viewModel.requestUser()
    }

    override fun renderData(data: Boolean?) {
        data?.let {
            data.takeIf { it }?.let {
                startMainActivity()
            }
        }
    }

    private fun startMainActivity() {
        MainActivity.start(this)
        finish()
    }
}