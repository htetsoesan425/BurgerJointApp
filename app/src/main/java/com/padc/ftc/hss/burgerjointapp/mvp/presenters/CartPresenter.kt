package com.padc.ftc.hss.burgerjointapp.mvp.presenters

import com.padc.ftc.hss.burgerjointapp.delegates.CartViewHolderActionDelegate
import com.padc.ftc.hss.burgerjointapp.mvp.views.views.CartView

interface CartPresenter : BasePresenter<CartView>, CartViewHolderActionDelegate {
    fun onTapCheckout()
    fun onTapCancelThankYouMessage()
}