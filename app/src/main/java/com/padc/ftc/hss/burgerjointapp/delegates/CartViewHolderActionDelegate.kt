package com.padc.ftc.hss.burgerjointapp.delegates

import com.padc.ftc.hss.burgerjointapp.data.vos.BurgerVO


interface CartViewHolderActionDelegate {
    fun onTapRemoveFromCart(burger : BurgerVO, adapterPosition : Int)
}