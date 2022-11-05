package com.padc.ftc.hss.burgerjointapp.mvp.views.views

interface LoginView : BaseView {
    fun navigateToMainScreen()
    fun showErrorMessage(message : String)
}