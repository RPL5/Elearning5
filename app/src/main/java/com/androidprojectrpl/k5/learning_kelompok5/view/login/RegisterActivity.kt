package com.androidprojectrpl.k5.learning_kelompok5.view.login

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.androidprojectrpl.k5.learning_kelompok5.R
import com.androidprojectrpl.k5.learning_kelompok5.utils.Constant
import kotlinx.android.synthetic.main.app_bar_nav_drawer.*

class RegisterActivity : AppCompatActivity() {
    val prefs = getSharedPreferences(Constant().PREFERENCES, Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setContent()
    }

    fun setContent(){
        setSupportActionBar(toolbar)
    }
}
