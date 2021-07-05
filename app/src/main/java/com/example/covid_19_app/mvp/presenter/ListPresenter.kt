package com.example.covid_19_app.mvp.presenter

import com.example.covid_19_app.mvp.view.IItemView

interface ListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}