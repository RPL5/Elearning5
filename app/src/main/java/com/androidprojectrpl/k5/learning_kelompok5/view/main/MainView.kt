package com.androidprojectrpl.k5.learning_kelompok5.view.main

import com.androidprojectrpl.k5.learning_kelompok5.model.User

/*
*
* Interface
* Sebagai implementasi format fungsi yang digunakan dalam Activity yang diinginkan
* Pelajari Pattern MVP
*
* */


interface MainView {
    fun setUserData(data : User)

    fun setPresenter(presenter : MainPresenter)

    fun onError(message : String)
}