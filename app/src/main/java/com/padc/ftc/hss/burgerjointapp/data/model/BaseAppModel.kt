package com.padc.ftc.hss.burgerjointapp.data.model

import android.content.Context
import com.padc.ftc.hss.burgerjointapp.persistence.BurgerJointDatabase


abstract class BaseAppModel : BaseModel() {

    protected lateinit var mDatabase: BurgerJointDatabase

    override fun init(context: Context) {
        initDatabase(context)
    }

    private fun initDatabase(context: Context) {
        mDatabase = BurgerJointDatabase.getInstance(context)
    }
}