package com.example.covid_19_app.navigation

import com.example.covid_19_app.ui.fragment.ContinentsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class ContinentsScreen : SupportAppScreen() {
    override fun getFragment() = ContinentsFragment.newInstance()
}