package com.example.covid_19_app.di.modules

import android.content.Context
import com.example.covid_19_app.mvp.model.api.IDataSource
import com.example.covid_19_app.mvp.model.network.NetworkStatus
import com.example.covid_19_app.ui.network.AndroidNetworkStatus
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {
    @Named("baseUrl")
    @Provides
    fun baseUrl() = "https://corona.lmao.ninja"

    @Singleton
    @Provides
    fun gson() = GsonBuilder()
        .create()

    @Singleton
    @Provides
    fun api(@Named("baseUrl") baseUrl: String, gson: Gson): IDataSource = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IDataSource::class.java)

    @Singleton
    @Provides
    fun networkStatus(context: Context): NetworkStatus = AndroidNetworkStatus(context)
}