package com.example.covid_19_app.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomContinent(
    @PrimaryKey var name: String,
    var cases: String,
    var todayCases: String,
    var deaths: String,
    var todayDeaths: String,
    var recovered: String,
    var todayRecovered: String,
    var countries: String
)

