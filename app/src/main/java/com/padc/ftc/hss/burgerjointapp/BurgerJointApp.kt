package com.padc.ftc.hss.burgerjointapp

import android.app.Application
import com.padc.ftc.hss.burgerjointapp.persistence.BurgerJointDatabase
import com.padc.ftc.hss.burgerjointapp.dummy.getDummyBurgers
import com.padc.ftc.hss.burgerjointapp.data.model.impls.BurgerModelImpl

class BurgerJointApp : Application() {
    override fun onCreate() {
        super.onCreate()
        BurgerModelImpl.init(applicationContext)
        deleteAllBurgers()
        prepopulateBurgers()
    }

    private fun deleteAllBurgers(){
        BurgerJointDatabase.getInstance(applicationContext)
            .getBurgerDao()
            .deleteAllBurgers()
    }

    private fun prepopulateBurgers(){
        BurgerJointDatabase.getInstance(applicationContext)
            .getBurgerDao()
            .insertBurgers(getDummyBurgers())
    }
}