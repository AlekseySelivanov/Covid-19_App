package com.example.covid_19_app.mvp.model.cache

import com.example.covid_19_app.mvp.model.entity.room.db.Database
import com.example.covid_19_app.mvp.model.entity.Continent
import com.example.covid_19_app.mvp.model.entity.room.RoomContinent
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class RoomContinentsCache(val db: Database) : ContinentCache {
    override fun putContinents(continents: List<Continent>): Completable {
        val roomContinents = continents.map { continentItem ->
            RoomContinent(
                continentItem.name,
                continentItem.cases,
                continentItem.todayCases,
                continentItem.deaths,
                continentItem.todayDeaths,
                continentItem.recovered,
                continentItem.todayRecovered,
                continentItem.countries.toString()
            )
        }
        return db.continentDao.insert(roomContinents)
    }

    override fun getContinents() = Single.fromCallable {
        db.continentDao.getAll().map { continentItem ->
            Continent(
                continentItem.name,
                continentItem.cases,
                continentItem.todayCases,
                continentItem.deaths,
                continentItem.todayDeaths,
                continentItem.recovered,
                continentItem.todayRecovered,
                continentItem.countries.split(",").map { it.trim() }
            )
        }
    }
}