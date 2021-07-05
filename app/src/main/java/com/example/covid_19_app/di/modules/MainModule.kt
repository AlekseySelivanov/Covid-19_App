package com.example.covid_19_app.di.modules

import com.example.covid_19_app.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}