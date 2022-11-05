package com.padc.ftc.hss.burgerjointapp.mvp.presenters.impls

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padc.ftc.hss.burgerjointapp.data.model.BurgerModel
import com.padc.ftc.hss.burgerjointapp.data.model.impls.BurgerModelImpl
import com.padc.ftc.hss.burgerjointapp.data.vos.BurgerVO
import com.padc.ftc.hss.burgerjointapp.mvp.presenters.MainPresenter
import com.padc.ftc.hss.burgerjointapp.mvp.views.views.MainView

class MainPresenterImpl : MainPresenter, BaseAppPresenterImpl<MainView>() {

    var mBurgerModel : BurgerModel = BurgerModelImpl

    override fun onTapAddToCart(burger: BurgerVO, burgerImageView : ImageView) {
        mBurgerModel.addItemToCart(burger)
        mView.addBurgerToCart(burger, burgerImageView)
    }

    override fun onTapCart() {
        mView.navigatetoCartScreen()
    }

    override fun onUIReady(owner: LifecycleOwner) {
        mBurgerModel.getAllBurgers()
            .observe(owner, Observer {
                mView.displayBurgerList(it)
            })

        mBurgerModel.getBurgersInCart()
            .observe(owner, Observer {
                mView.displayCountInCart(it.count())
            })
    }

    override fun onTapBurger(burger: BurgerVO, burgerImageView: ImageView) {
        mView.navigateToBurgerDetailsScreen(burgerId = burger.burgerId, burgerImageView = burgerImageView)
    }
}