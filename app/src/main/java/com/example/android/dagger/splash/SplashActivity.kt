package com.example.android.dagger.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.dagger.MyApplication
import com.example.android.dagger.login.LoginActivity
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        when (viewModel.getUserState()) {
            UserState.NONE -> {
                startActivity(Intent(this, RegistrationActivity::class.java))
            }
            UserState.REGISTERED -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            UserState.LOGGED_IN -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
        finish()
    }
}