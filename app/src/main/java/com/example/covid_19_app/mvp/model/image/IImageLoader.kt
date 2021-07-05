package com.example.covid_19_app.mvp.model.image

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}