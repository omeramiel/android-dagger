package com.example.android.dagger.splash

import com.example.android.dagger.user.UserManager
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val userManager: UserManager) {

    fun getUserState(): UserState {
        return if (!userManager.isUserLoggedIn()) {
            if (!userManager.isUserRegistered()) {
                UserState.NONE
            } else {
                UserState.REGISTERED
            }
        } else {
            UserState.LOGGED_IN
        }
    }
}

enum class UserState {
    NONE, REGISTERED, LOGGED_IN
}
