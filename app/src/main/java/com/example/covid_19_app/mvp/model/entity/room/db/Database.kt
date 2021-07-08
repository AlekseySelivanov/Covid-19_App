package com.example.covid_19_app.mvp.model.entity.room.db

import androidx.room.RoomDatabase
import com.example.covid_19_app.mvp.model.entity.room.RoomContinent
import com.example.covid_19_app.mvp.model.entity.room.dao.ContinentDao

@androidx.room.Database(entities = [RoomContinent::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract val continentDao: ContinentDao

    companion object {
        const val DB_NAME = "database.db"
        private var instance: Database? = null
    }
}