package com.padc.ftc.hss.burgerjointapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.ftc.hss.burgerjointapp.mvp.views.views.BaseView

interface BasePresenter<V: BaseView> {
    fun onUIReady(owner: LifecycleOwner)
    fun initPresenter(view: V)
}