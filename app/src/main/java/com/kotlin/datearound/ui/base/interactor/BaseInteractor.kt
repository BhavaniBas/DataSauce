package com.kotlin.datearound.ui.base.interactor

import com.kotlin.datearound.data.network.ApiHelper
import com.kotlin.datearound.data.preferences.PreferenceHelper


open class BaseInteractor() : MVPInteractor {

    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper

    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }



}