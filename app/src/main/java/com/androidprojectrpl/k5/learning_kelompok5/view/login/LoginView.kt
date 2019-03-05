package com.androidprojectrpl.k5.learning_kelompok5.view.login

import com.androidprojectrpl.k5.learning_kelompok5.model.Mahasiswa

interface LoginView {
    fun showProgress()

    fun hideProgress()

    fun setAction(data : Mahasiswa)

    fun onFailRequest(errMessage : String)
}