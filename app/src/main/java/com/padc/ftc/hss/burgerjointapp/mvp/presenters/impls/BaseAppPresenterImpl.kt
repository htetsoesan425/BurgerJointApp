package com.padc.ftc.hss.burgerjointapp.mvp.presenters.impls

import com.padc.ftc.hss.burgerjointapp.mvp.presenters.BasePresenter
import com.padc.ftc.hss.burgerjointapp.mvp.presenters.AbstractBasePresenter
import com.padc.ftc.hss.burgerjointapp.mvp.views.views.BaseView

abstract class BaseAppPresenterImpl<V : BaseView> : AbstractBasePresenter<V>(), BasePresenter<V>
