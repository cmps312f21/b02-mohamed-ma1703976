package cmps312.lab3.covidtrackerapp.Views

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import cmps312.lab3.covidtrackerapp.Sorting.appSorting
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
@Composable
fun MainScreen() {
    val covidStore =
        viewModel<appSorting>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    Scaffold(
        topBar = {
            TopAppBar() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column {
                        Text(
                            text = "Covid Tracker",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "World Statistics", fontSize = 13.sp)
                    }
                    Box() {
                        DropDown()
                    }
                }
            }
        },
        content = { CovidList() }
    )
}