package com.example.covid_19_app.di.modules

import com.example.covid_19_app.ui.fragment.ContinentsFragment
import com.example.covid_19_app.ui.fragment.CountriesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {
    @ContributesAndroidInjector
    abstract fun bindContinentsFragment(): ContinentsFragment

    @ContributesAndroidInjector
    abstract fun bindCountriesFragment(): CountriesFragment
}