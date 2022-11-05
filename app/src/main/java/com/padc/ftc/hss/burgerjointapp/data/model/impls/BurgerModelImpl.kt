package com.padc.ftc.hss.burgerjointapp.data.model.impls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.padc.ftc.hss.burgerjointapp.data.vos.BurgerVO
import com.padc.ftc.hss.burgerjointapp.data.model.BaseAppModel
import com.padc.ftc.hss.burgerjointapp.data.model.BurgerModel

object BurgerModelImpl : BurgerModel, BaseAppModel() {

    var burgersInOrder : MutableList<BurgerVO> = arrayListOf()
    var burgersInOrderLiveData = MutableLiveData<List<BurgerVO>>()

    override fun findBurgerById(burgerId: Int): LiveData<BurgerVO> {
        return Transformations.distinctUntilChanged(
            mDatabase.getBurgerDao().findBurgerById(burgerId)
        )
    }

    override fun getAllBurgers(): LiveData<List<BurgerVO>> {
        return Transformations.distinctUntilChanged(
            mDatabase.getBurgerDao().getAllBurgers()
        )
    }

    override fun getBurgersInCart(): LiveData<List<BurgerVO>> {
        burgersInOrderLiveData.postValue(burgersInOrder)
        return burgersInOrderLiveData
    }

    override fun removeItemFromCart(burger: BurgerVO) {
        burgersInOrder.remove(burger)
        burgersInOrderLiveData.postValue(burgersInOrder)
    }

    override fun addItemToCart(burger: BurgerVO) {
        burgersInOrder.add(burger)
        burgersInOrderLiveData.postValue(burgersInOrder)
    }
}