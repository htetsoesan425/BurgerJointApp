package com.padc.ftc.hss.burgerjointapp.mvp.views.views

import android.widget.ImageView
import com.padc.ftc.hss.burgerjointapp.data.vos.BurgerVO
import com.padc.ftc.hss.burgerjointapp.mvp.views.views.BaseView

interface MainView : BaseView {
    fun displayBurgerList(burgerList : List<BurgerVO>)
    fun navigateToBurgerDetailsScreen(burgerId : Int, burgerImageView : ImageView)
    fun navigatetoCartScreen()
    fun addBurgerToCart(burger : BurgerVO, burgerImageView : ImageView)
    fun displayCountInCart(burgersInCartCount : Int)

}