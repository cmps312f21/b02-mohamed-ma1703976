package cmps312.lab3.covidtrackerapp.repository

import android.content.Context
import cmps312.lab3.covidtrackerapp.models.CovidStat
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@ExperimentalSerializationApi
object CovidDataRepo {
    var covid_data = listOf<CovidStat>()

    private fun readCovidData(context: Context) =
        context.assets.open("covid-data.json").bufferedReader().use { it.readText() }

    fun initCovidData(context: Context) {
        covid_data = Json.decodeFromString<List<CovidStat>>(readCovidData(context))
    }
}