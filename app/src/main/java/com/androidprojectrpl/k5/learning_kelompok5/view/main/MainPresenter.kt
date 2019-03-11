package com.androidprojectrpl.k5.learning_kelompok5.view.main

import com.androidprojectrpl.k5.learning_kelompok5.network.ApiClient
import com.androidprojectrpl.k5.learning_kelompok5.utils.BasePresenter
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/*
* Class Presenter
* Menghubungkan aplikasi ke API service
* Mendapatkan data dari service dan mengembalikan hasil data yang didapatkan ke Activity
* yang mengimplementasikan View
* */


class MainPresenter (private val context : MainView) : BasePresenter{

    private val compositeSubscription = CompositeSubscription()

    fun getUser(id : String){
        val service = ApiClient.getClient()
        val subscription = service.getUser(Integer.valueOf(id))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({data ->
                    context.setUserData(data)
                },{error->
                    context.onError(error.localizedMessage)
                })
        compositeSubscription.add(subscription)
    }

    override fun subscribe() {
        context.setPresenter(this)
    }

    override fun unsubscribe() {
        compositeSubscription.clear()
    }

}