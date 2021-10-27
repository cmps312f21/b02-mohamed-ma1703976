package cmps312.lab3.covidtrackerapp.Views

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import cmps312.lab3.covidtrackerapp.Sorting.appSorting
import cmps312.lab3.covidtrackerapp.repository.CovidDataRepo
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
@Composable
fun CovidList() {
    var searchTerm by remember {
        mutableStateOf("")
    }
    val covidStore =
        viewModel<appSorting>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    Column() {
        SearchBar(state = searchTerm, onSearchTextChange = {
            searchTerm = it
            covidStore.filterCountries(it)
        })
        LazyColumn {
            items(covidStore.getEditedData()) { country ->
                CovidCard(countryData = country)
            }
        }
    }
}