package com.kotlin.datearound.widget

import android.view.View


enum class MeasureSpecMode(val modeValue: Int) {
    AT_MOST(View.MeasureSpec.AT_MOST),
    EXACTLY(View.MeasureSpec.EXACTLY),
    UNSPECIFIED(View.MeasureSpec.UNSPECIFIED)
}