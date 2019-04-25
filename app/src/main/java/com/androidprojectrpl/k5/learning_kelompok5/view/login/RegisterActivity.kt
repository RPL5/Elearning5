package com.androidprojectrpl.k5.learning_kelompok5.view.login

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.androidprojectrpl.k5.learning_kelompok5.R
import com.androidprojectrpl.k5.learning_kelompok5.utils.Constant
import com.androidprojectrpl.k5.learning_kelompok5.utils.gone
import com.androidprojectrpl.k5.learning_kelompok5.utils.visible
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    val prefs = getSharedPreferences(Constant.PREFERENCES, Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setContent()
    }

    fun setContent(){
        retypePasswordRegister.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (retypePasswordRegister.text.toString() == passwordRegister.text.toString()) {
                    checkConfirmPass.gone()
                    submitRegister.isClickable = true
                }
                else {
                    checkConfirmPass.visible()
                    submitRegister.isClickable = false
                }
            }

        })
    }
}
