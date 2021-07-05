package com.example.covid_19_app.navigation

import com.example.covid_19_app.ui.fragment.CountriesFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class CountriesScreen(private val name: String) : SupportAppScreen() {
    override fun getFragment() = CountriesFragment.newInstance(name)
}