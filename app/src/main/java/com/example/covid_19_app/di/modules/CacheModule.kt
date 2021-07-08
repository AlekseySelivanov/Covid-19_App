package com.example.covid_19_app.di.modules

import android.content.Context
import com.example.covid_19_app.mvp.model.entity.room.db.Database
import androidx.room.Room
import com.example.covid_19_app.mvp.model.cache.ContinentCache
import com.example.covid_19_app.mvp.model.cache.RoomContinentsCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {
    @Singleton
    @Provides
    fun database(context: Context): Database =
        Room.databaseBuilder(context, Database::class.java, Database.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun continentsCache(database: Database): ContinentCache = RoomContinentsCache(database)
}