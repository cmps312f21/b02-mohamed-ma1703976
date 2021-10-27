package cmps312.lab3.covidtrackerapp.Views

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuOpen
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import cmps312.lab3.covidtrackerapp.Sorting.SortBy
import cmps312.lab3.covidtrackerapp.Sorting.appSorting
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
@Composable
fun DropDown() {
    val covidStore =
        viewModel<appSorting>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val sortingOptions = mapOf<String, SortBy>(
        "Sort By Country" to SortBy.COUNTRY,
        "Sort By Active Cases" to SortBy.ACTIVE,
        "Sort By Total Deaths" to SortBy.DEATH,
        "Sort By Population" to SortBy.POPULATION,
    )
    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(
        onClick = { expanded = !expanded },
    ) {
        Row {
            Icon(
                imageVector = Icons.Filled.MenuOpen,
                contentDescription = null,
            )
        }
    }
    DropdownMenu(expanded, onDismissRequest = { expanded = false }) {
        sortingOptions.forEach { option ->
            DropdownMenuItem(onClick = {
                expanded = false
                covidStore.storeCountries(option.value)
            }) {
                Text(text = option.key)
            }
        }
    }
}