package com.padc.ftc.hss.burgerjointapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.ftc.hss.burgerjointapp.mvp.views.views.BurgerDetailsView

interface BurgerDetailsPresenter : BasePresenter<BurgerDetailsView> {
    fun onBurgerDetailsUiReady(lifecycleOwner: LifecycleOwner, burgerDetailsId: Int)
}