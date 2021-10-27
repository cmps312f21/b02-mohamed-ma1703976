package cmps312.lab3.covidtrackerapp.Sorting

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import cmps312.lab3.covidtrackerapp.models.CovidStat
import cmps312.lab3.covidtrackerapp.repository.CovidDataRepo
import kotlinx.serialization.ExperimentalSerializationApi

enum class SortBy { COUNTRY, ACTIVE, DEATH, POPULATION }

@ExperimentalSerializationApi
class appSorting(appContext: Application) : AndroidViewModel(appContext) {
    val d = CovidDataRepo.initCovidData(appContext)
    private val data = CovidDataRepo.covid_data
    private val editedData = mutableStateOf(data)

    fun filterCountries(searchText: String) {
        editedData.value = data.filter { it.country.contains(searchText, ignoreCase = true) }
    }

    fun storeCountries(sortOption: SortBy) {
        when (sortOption) {
            SortBy.COUNTRY -> editedData.value = editedData.value.sortedByDescending { it.country }
            SortBy.ACTIVE -> editedData.value =
                editedData.value.sortedByDescending { it.activeCases }
            SortBy.DEATH -> editedData.value =
                editedData.value.sortedByDescending { it.totalDeaths }
            SortBy.POPULATION -> editedData.value =
                editedData.value.sortedByDescending { it.population }
        }
    }

    fun getEditedData() = editedData.value
}