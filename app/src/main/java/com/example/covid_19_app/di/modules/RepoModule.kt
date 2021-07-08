package com.example.covid_19_app.di.modules

import com.example.covid_19_app.mvp.model.api.IDataSource
import com.example.covid_19_app.mvp.model.cache.ContinentCache
import com.example.covid_19_app.mvp.model.network.NetworkStatus
import com.example.covid_19_app.mvp.model.repo.ContinentsRepo
import com.example.covid_19_app.mvp.model.repo.RetrofitContinetsRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {
    @Singleton
    @Provides
    fun continentsRepo(
        api: IDataSource, networkStatus: NetworkStatus, cache: ContinentCache
    ): ContinentsRepo = RetrofitContinetsRepo(api, networkStatus, cache)

}