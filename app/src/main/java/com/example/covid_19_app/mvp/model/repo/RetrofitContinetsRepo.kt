package com.example.covid_19_app.mvp.model.repo

import com.example.covid_19_app.mvp.model.api.IDataSource
import com.example.covid_19_app.mvp.model.cache.ContinentCache
import com.example.covid_19_app.mvp.model.entity.Continent
import com.example.covid_19_app.mvp.model.entity.Country
import com.example.covid_19_app.mvp.model.network.NetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitContinetsRepo(
    val api: IDataSource,
    val networkStatus: NetworkStatus,
    val cache: ContinentCache
) : ContinentsRepo {
    override fun getContinents() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getContinents().flatMap { continents ->
                cache.putContinents(continents)
                    .andThen(
                        Single.just(continents)
                    )
            }

        } else {
            cache.getContinents()
        }
    }.subscribeOn(Schedulers.io())


    override fun getContinentByName(name: String): Single<Continent> = api.getContinentByName(name)
    override fun getCountries(countries: List<String>): Single<List<Country>> =
        api.getCountries(countries.joinToString(","))
}