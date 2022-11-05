package com.padc.ftc.hss.burgerjointapp.delegates

import android.widget.ImageView
import com.padc.ftc.hss.burgerjointapp.data.vos.BurgerVO

interface BurgerViewHolderActionDelegate {
    fun onTapBurger(burger : BurgerVO, burgerImageView: ImageView)
    fun onTapAddToCart(burger : BurgerVO, burgerImageView: ImageView)
}