package com.padc.ftc.hss.burgerjointapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.ftc.hss.burgerjointapp.mvp.presenters.LoginPresenter
import com.padc.ftc.hss.burgerjointapp.mvp.views.views.LoginView
import com.padc.ftc.hss.burgerjointapp.utils.EM_LOGIN_FAIL_ERROR_MESSAGE

class LoginPresenterImpl : LoginPresenter, BaseAppPresenterImpl<LoginView>() {
    override fun onUIReady(owner: LifecycleOwner) {}

    override fun onTapLogin(userName: String, password: String) {
        if(userName.isNotEmpty() || password.isNotEmpty()){
            mView.navigateToMainScreen()
        } else {
            mView.showErrorMessage(EM_LOGIN_FAIL_ERROR_MESSAGE)
        }
    }
}