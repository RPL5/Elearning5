package com.androidprojectrpl.k5.learning_kelompok5.view.main

import com.androidprojectrpl.k5.learning_kelompok5.model.User

interface MainView {
    fun setUserData(data : User)

    fun setPresenter(presenter : MainPresenter)

    fun onError(message : String)
}