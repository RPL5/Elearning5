package com.androidprojectrpl.k5.learning_kelompok5.view.main.segment

import com.androidprojectrpl.k5.learning_kelompok5.network.ApiClient
import com.androidprojectrpl.k5.learning_kelompok5.utils.BasePresenter
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

class PASegmentPresenter(val errorContext : SegmentMainInterface, val context : PembimbinganAkademikSegment) : BasePresenter{
    private val service = ApiClient.getClient()
    private val compositeSubscription = CompositeSubscription()

    fun getAllClassById(id : String){
        val subscription = service.getClassById(Integer.valueOf(id))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({data ->
                    context.setData(data)
                }, { error ->
                    errorContext.onError(error.localizedMessage)
                })
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        compositeSubscription.clear()
    }
}