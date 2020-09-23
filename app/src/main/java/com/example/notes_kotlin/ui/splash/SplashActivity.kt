package com.example.notes_kotlin.ui.splash

import androidx.lifecycle.ViewModelProvider
import com.example.notes_kotlin.ui.base.BaseActivity
import com.example.notes_kotlin.ui.main.MainActivity

class SplashActivity : BaseActivity<Boolean?, SplashViewState>() {

    override val viewModel by lazy {
        ViewModelProvider(this).get(SplashViewModel::class.java)
    }

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

    fun startMainActivity() {
        MainActivity.start(this)
        finish()
    }
}