package com.kotlin.datearound.ui.base.presenter

import com.kotlin.datearound.ui.base.interactor.MVPInteractor
import com.kotlin.datearound.ui.base.view.MVPView


interface MVPPresenter<V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}