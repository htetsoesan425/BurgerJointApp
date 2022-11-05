package com.padc.ftc.hss.burgerjointapp.mvp.presenters

import com.padc.ftc.hss.burgerjointapp.mvp.presenters.BasePresenter
import com.padc.ftc.hss.burgerjointapp.delegates.BurgerViewHolderActionDelegate
import com.padc.ftc.hss.burgerjointapp.mvp.views.views.MainView

interface MainPresenter :  BasePresenter<MainView>, BurgerViewHolderActionDelegate {
    fun onTapCart()
}