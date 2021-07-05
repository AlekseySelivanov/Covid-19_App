package com.example.covid_19_app.mvp.presenter

import com.example.covid_19_app.mvp.view.MainView
import com.example.covid_19_app.navigation.ContinentsScreen
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(ContinentsScreen())
    }

    fun backClick() {
        router.exit()
    }
}