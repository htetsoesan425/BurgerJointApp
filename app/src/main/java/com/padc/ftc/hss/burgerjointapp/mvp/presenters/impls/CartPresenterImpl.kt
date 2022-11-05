package com.padc.ftc.hss.burgerjointapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padc.ftc.hss.burgerjointapp.data.vos.BurgerVO
import com.padc.ftc.hss.burgerjointapp.data.model.impls.BurgerModelImpl
import com.padc.ftc.hss.burgerjointapp.mvp.presenters.CartPresenter
import com.padc.ftc.hss.burgerjointapp.mvp.views.views.CartView

class CartPresenterImpl : CartPresenter, BaseAppPresenterImpl<CartView>() {


    private val mBurgerModel = BurgerModelImpl

    override fun onUIReady(owner: LifecycleOwner) {
        mBurgerModel
            .getBurgersInCart()
            .observe(owner, Observer {
                mView.displayItemsInCart(it)
            })
    }

    override fun onTapRemoveFromCart(burger: BurgerVO, adapterPosition : Int) {
        mBurgerModel
            .removeItemFromCart(burger)
    }



    override fun onTapCheckout() {
        mView.displayThankYouMessage()
    }

    override fun onTapCancelThankYouMessage() {
        mView.hideThankYouMessage()
    }
}