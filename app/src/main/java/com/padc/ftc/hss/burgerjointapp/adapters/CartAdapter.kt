package com.padc.ftc.hss.burgerjointapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.ftc.hss.burgerjointapp.R
import com.padc.ftc.hss.burgerjointapp.data.vos.BurgerVO
import com.padc.ftc.hss.burgerjointapp.delegates.CartViewHolderActionDelegate
import com.padc.ftc.hss.burgerjointapp.viewholders.CartViewHolder

class CartAdapter(private val mDelegate: CartViewHolderActionDelegate) :
    BaseRecyclerAdapter<CartViewHolder, BurgerVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_item_cart, parent, false)
        return CartViewHolder(view, mDelegate)
    }
}

