package com.example.covid_19_app.mvp.model.entity.room.dao

import androidx.room.*
import com.example.covid_19_app.mvp.model.entity.room.RoomContinent
import io.reactivex.rxjava3.core.Completable

@Dao
interface ContinentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(continents: List<RoomContinent>):Completable

    @Update
    fun update(continent: RoomContinent)

    @Delete
    fun delete(continent: RoomContinent)

    @Query("SELECT * FROM RoomContinent")
    fun getAll(): List<RoomContinent>
}