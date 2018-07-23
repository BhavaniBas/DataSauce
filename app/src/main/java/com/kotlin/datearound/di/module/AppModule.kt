package com.kotlin.datearound.di.module

import android.app.Application
import android.content.Context
import com.kotlin.datearound.data.network.ApiHelper
import com.kotlin.datearound.data.network.AppApiHelper
import com.kotlin.datearound.data.preferences.AppPreferenceHelper
import com.kotlin.datearound.data.preferences.PreferenceHelper
import com.kotlin.datearound.di.ApiKeyInfo
import com.kotlin.datearound.di.PreferenceInfo
import com.kotlin.datearound.util.AppConstants
import com.kotlin.datearound.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()


}