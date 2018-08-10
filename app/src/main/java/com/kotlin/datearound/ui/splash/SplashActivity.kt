package com.kotlin.datearound.ui.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import butterknife.ButterKnife
import com.kotlin.datearound.R

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_premium_features)
        ButterKnife.bind(this)
    }
}
