package com.androidprojectrpl.k5.learning_kelompok5.view.login

import android.util.Log
import com.androidprojectrpl.k5.learning_kelompok5.network.ApiClient
import com.androidprojectrpl.k5.learning_kelompok5.utils.BasePresenter
import com.google.gson.JsonObject
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

class LoginPresenter(private val context : LoginView)
    : BasePresenter {

    private val compositeSubscription : CompositeSubscription

    init {
        compositeSubscription = CompositeSubscription()
    }

    override fun subscribe() {}

    override fun unsubscribe() {
        compositeSubscription.clear()
    }

    fun loginRequest(username : String, password : String){
        context.showProgress()
        val validation = JsonObject()
        validation.addProperty("username",username)
        validation.addProperty("password",password)

        val service = ApiClient.getClient()
        val subscription = service.getMahasiswa(validation)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({data ->
                    context.hideProgress()
                    context.setAction(data)
                },{error ->
                    context.hideProgress()
                    context.onFailRequest("Terjadi masalah dengan koneksi anda!")
                    Log.e("Error Login",error.localizedMessage)
                })
        compositeSubscription.add(subscription)
    }
}