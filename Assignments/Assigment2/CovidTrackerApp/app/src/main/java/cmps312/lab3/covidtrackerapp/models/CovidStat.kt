package cmps312.lab3.covidtrackerapp.models

import kotlinx.serialization.Serializable

@Serializable
data class CovidStat(
    val id: Int,
    var country: String,
    val continent: String?,
    val region: String?,
    val totalCases: Int?,
    val newCases: Int?,
    val totalDeaths: Int?,
    val newDeaths: Int?,
    val totalRecovered: Int?,
    val newRecovered: Int?,
    val activeCases: Int?,
    val criticalCases: Int?,
    val casesPer1M: Int?,
    val deathsPer1M: Int?,
    val totalTests: Int?,
    val testsPer1M: Int?,
    val population: Int?,
)