package com.padc.ftc.hss.burgerjointapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.ftc.hss.burgerjointapp.R
import com.padc.ftc.hss.burgerjointapp.data.vos.BurgerVO
import com.padc.ftc.hss.burgerjointapp.delegates.BurgerViewHolderActionDelegate
import com.padc.ftc.hss.burgerjointapp.viewholders.BurgerViewHolder

class BurgerAdapter(private val mDelegate : BurgerViewHolderActionDelegate) : BaseRecyclerAdapter<BurgerViewHolder, BurgerVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BurgerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_burger,parent,false)
        return BurgerViewHolder(view, mDelegate)
    }
}