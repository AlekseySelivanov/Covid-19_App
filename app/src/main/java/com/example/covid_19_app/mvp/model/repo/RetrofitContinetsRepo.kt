package com.example.covid_19_app.mvp.model.repo

import com.example.covid_19_app.mvp.model.Continent
import com.example.covid_19_app.mvp.model.Country
import com.example.covid_19_app.mvp.model.api.IDataSource
import io.reactivex.rxjava3.core.Single

class RetrofitContinetsRepo(val api: IDataSource) : ContinentsRepo {
    override fun getContinents() = api.getContinents()
    override fun getContinentByName(name: String): Single<Continent> = api.getContinentByName(name)
    override fun getCountries(countries: List<String>): Single<List<Country>> =
        api.getCountries(countries.joinToString(","))
}