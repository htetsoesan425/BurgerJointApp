package com.padc.ftc.hss.burgerjointapp.mvp.views.views

import com.padc.ftc.hss.burgerjointapp.data.vos.BurgerVO
import com.padc.ftc.hss.burgerjointapp.mvp.views.views.BaseView

interface CartView : BaseView {
    fun displayItemsInCart(burgers : List<BurgerVO>)
    fun displayThankYouMessage()
    fun hideThankYouMessage()
    fun animateRemoveItemFromCart(adapterPosition : Int)
}