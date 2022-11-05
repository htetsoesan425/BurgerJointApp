package com.padc.ftc.hss.burgerjointapp.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padc.ftc.hss.burgerjointapp.mvp.views.views.BaseView

abstract class AbstractBasePresenter<T: BaseView> : BasePresenter<T>, ViewModel() {

    protected lateinit var mView : T

    override fun initPresenter(view: T){
        mView = view
    }
}