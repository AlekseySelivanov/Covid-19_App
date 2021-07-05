package com.example.covid_19_app.mvp.view

interface CountryItemView : IItemView {
    fun setName(text: String)
    fun setCases(text: String)
    fun setTodayCases(text: String)
    fun setDeaths(text: String)
    fun setTodayDeaths(text: String)
    fun setRecovered(text: String)
    fun setTodayRecovered(text: String)
    fun loadImage(text: String)
}