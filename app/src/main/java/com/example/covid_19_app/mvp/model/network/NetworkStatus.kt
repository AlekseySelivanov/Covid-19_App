package com.example.covid_19_app.mvp.model.network

import io.reactivex.rxjava3.core.Single

interface NetworkStatus {
    fun isOnlineSingle(): Single<Boolean>
}