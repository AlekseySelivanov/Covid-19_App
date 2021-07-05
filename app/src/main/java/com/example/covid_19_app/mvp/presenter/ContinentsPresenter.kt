package com.example.covid_19_app.mvp.presenter

import com.example.covid_19_app.mvp.model.Continent
import com.example.covid_19_app.mvp.model.repo.ContinentsRepo
import com.example.covid_19_app.mvp.view.ContinentItemView
import com.example.covid_19_app.mvp.view.ContinentsView
import com.example.covid_19_app.navigation.CountriesScreen
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class ContinentsPresenter(
    private val continentsRepo: ContinentsRepo,
    private val scheduler: Scheduler,
    private val router: Router
) : MvpPresenter<ContinentsView>() {
    class ContinentsListPresenter : ContinentListPresenter {
        val continents = mutableListOf<Continent>()
        override var itemClickListener: ((ContinentItemView) -> Unit)? = null
        override fun getCount() = continents.size
        override fun bindView(view: ContinentItemView) {
            Single.just(continents[view.pos]).subscribe({
                onBindViewSuccess(view, it)
            }, ::onBindViewError)
        }

        private fun onBindViewSuccess(view: ContinentItemView, continent: Continent) {
            view.setName(continent.name)
            view.setCases(continent.cases)
            view.setTodayCases(continent.todayCases)
            view.setDeaths(continent.deaths)
            view.setTodayDeaths(continent.todayDeaths)
            view.setRecovered(continent.recovered)
            view.setTodayRecovered(continent.todayRecovered)
        }

        private fun onBindViewError(error: Throwable) {

        }
    }

    val continentListPresenter = ContinentsListPresenter()
    private var disposable = CompositeDisposable()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        continentListPresenter.itemClickListener = { itemView ->
            router.navigateTo(
                CountriesScreen(continentListPresenter.continents[itemView.pos].name)
            )
        }

    }

    fun loadData() {
        disposable += continentsRepo.getContinents()
            .observeOn(scheduler)
            .subscribe(
                ::onLoadDataSuccess,
                ::onLoadDataError
            )
    }

    private fun onLoadDataError(error: Throwable) {
        println("Error: ${error.message}")
    }

    private fun onLoadDataSuccess(coninents: List<Continent>) {
        continentListPresenter.continents.clear()
        continentListPresenter.continents.addAll(coninents)
        viewState.updateList()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}