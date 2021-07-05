package com.example.covid_19_app.mvp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    @SerializedName("country") val name: String,
    @SerializedName("cases") val cases: String,
    @SerializedName("todayCases") val todayCases: String,
    @SerializedName("deaths") val deaths: String,
    @SerializedName("todayDeaths") val todayDeaths: String,
    @SerializedName("recovered") val recovered: String,
    @SerializedName("todayRecovered") val todayRecovered: String,
    @SerializedName("population") val population: String,
    @SerializedName("countryInfo") val countryInfo: CountryInfo
) : Parcelable
