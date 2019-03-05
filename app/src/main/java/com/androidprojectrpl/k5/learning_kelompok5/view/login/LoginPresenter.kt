package com.androidprojectrpl.k5.learning_kelompok5.view.login

import com.androidprojectrpl.k5.learning_kelompok5.network.ApiClient
import com.androidprojectrpl.k5.learning_kelompok5.utils.BasePresenter
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
        val service = ApiClient.getClient()
        val subscription = service.getMahasiswa(username,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({data ->
                    context.hideProgress()
                    context.setAction(data)
                },{error ->
                    context.hideProgress()
                    context.onFailRequest(error.localizedMessage)
                })
        compositeSubscription.add(subscription)
    }
}