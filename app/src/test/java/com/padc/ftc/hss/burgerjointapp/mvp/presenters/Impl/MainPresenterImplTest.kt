package com.padc.ftc.hss.burgerjointapp.mvp.presenters.Impl

import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padc.ftc.hss.burgerjointapp.data.model.BurgerModel
import com.padc.ftc.hss.burgerjointapp.data.model.impls.BurgerModelImpl
import com.padc.ftc.hss.burgerjointapp.data.model.impls.MockBurgerModelImpl
import com.padc.ftc.hss.burgerjointapp.data.vos.BurgerVO
import com.padc.ftc.hss.burgerjointapp.dummy.getDummyBurgers
import com.padc.ftc.hss.burgerjointapp.mvp.presenters.impls.MainPresenterImpl
import com.padc.ftc.hss.burgerjointapp.mvp.views.views.MainView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {

    private lateinit var mPresenter: MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MainView
    private lateinit var mBurgerModel: BurgerModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        BurgerModelImpl.init(ApplicationProvider.getApplicationContext())
        mBurgerModel = MockBurgerModelImpl

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mBurgerModel = this.mBurgerModel
    }

    @Test
    fun onTapAddToCart_callAddBurgerToCart() {
        val tappedBurger = BurgerVO()
        tappedBurger.burgerId = 1
        tappedBurger.burgerName = "Big Mac"
        tappedBurger.burgerImageUrl = ""
        tappedBurger.burgerDescription = "Big Mac Burger"

        val imageView = ImageView(ApplicationProvider.getApplicationContext())

        mPresenter.onTapAddToCart(tappedBurger, imageView)

        verify {
            mView.addBurgerToCart(tappedBurger, imageView)
        }
    }

    @Test
    fun onTapCart_callNavigateToCartScreen() {
        mPresenter.onTapCart()
        verify {
            mView.navigatetoCartScreen()
        }
    }

    @Test
    fun onTapBurger_callNavigateToBurgerDetails() {
        val tappedBurger = BurgerVO()
        tappedBurger.burgerId = 1
        tappedBurger.burgerName = "Big Mac"
        tappedBurger.burgerImageUrl = ""
        tappedBurger.burgerDescription = "Big Mac Burger"
        val imageView = ImageView(ApplicationProvider.getApplicationContext())

        mPresenter.onTapBurger(tappedBurger, imageView)
        verify {
            mView.navigateToBurgerDetailsScreen(tappedBurger.burgerId, imageView)
        }
    }

    @Test
    fun onUIReady_callDisplayBurgerList_callDisplayCountInCart() {

        val lifeCycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifeCycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.onUIReady(lifeCycleOwner)

        verify {
            mView.displayBurgerList(getDummyBurgers())
        }
    }
}