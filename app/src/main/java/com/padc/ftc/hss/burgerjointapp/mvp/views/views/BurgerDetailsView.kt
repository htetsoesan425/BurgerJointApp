package com.padc.ftc.hss.burgerjointapp.mvp.views.views

import com.padc.ftc.hss.burgerjointapp.data.vos.BurgerVO

interface BurgerDetailsView : BaseView {
    fun displayBurgerDetails(burger : BurgerVO)
}