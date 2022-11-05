package com.padc.ftc.hss.burgerjointapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padc.ftc.hss.burgerjointapp.data.model.impls.BurgerModelImpl
import com.padc.ftc.hss.burgerjointapp.mvp.presenters.BurgerDetailsPresenter
import com.padc.ftc.hss.burgerjointapp.mvp.views.views.BurgerDetailsView

class BurgerDetailsPresenterImpl : BurgerDetailsPresenter,
    BaseAppPresenterImpl<BurgerDetailsView>() {

    private val mBurgerModel = BurgerModelImpl

    override fun onBurgerDetailsUiReady(lifecycleOwner: LifecycleOwner, burgerDetailsId: Int) {
        mBurgerModel.findBurgerById(burgerDetailsId)
            .observe(lifecycleOwner, Observer {
                mView.displayBurgerDetails(it)
            })
    }

    override fun onUIReady(owner: LifecycleOwner) {

    }
}