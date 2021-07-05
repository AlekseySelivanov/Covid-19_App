package com.example.covid_19_app.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface CountriesView : MvpView {
    fun setName(text: String)
    fun setCases(text: String)
    fun setTodayCases(text: String)
    fun setDeaths(text: String)
    fun setTodayDeaths(text: String)
    fun setRecovered(text: String)
    fun setTodayRecovered(text: String)
    fun init()
    fun updateList()
}