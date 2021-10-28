package cmps312.lab3.vaccinemanagement.view
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import cmps312.lab3.vaccinemanagement.models.Patient
import cmps312.lab3.vaccinemanagement.viewModel.PatientViewModel
import java.util.*

@Composable
fun AddPatient(navHostController: NavHostController) {
    val patientStore =
        viewModel<PatientViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    var patientName by remember {
        mutableStateOf("")
    }
    var patientQID by remember {
        mutableStateOf("")
    }
    var patientHealthStatus by remember {
        mutableStateOf("")
    }
    var patientVacStatus by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .background(color = Color.Transparent)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = patientName ?: "",
                onValueChange = { patientName = it },
                placeholder = {
                    Text(
                        text = "Enter Patient Name"
                    )
                })
            Spacer(modifier = Modifier.height(40.dp))
            OutlinedTextField(
                value = patientQID ?: "",
                onValueChange = { patientQID = it },
                placeholder = {
                    Text(
                        text = "QID"
                    )
                })
            Spacer(modifier = Modifier.height(7.dp))
            Dropdown(
                label = "Select Health Status",
                options = patientStore.getHealthStatus(),
                selectedOption = patientHealthStatus,
                onSelectionChange = { patientHealthStatus = it }
            )
            Dropdown(
                label = "Select Vaccination Status",
                options = patientStore.getVaccinationStatus(),
                selectedOption = patientVacStatus,
                onSelectionChange = { patientVacStatus = it }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                if (patientName.isNotEmpty() && patientVacStatus.isNotEmpty() &&
                    patientQID.isNotEmpty() &&
                    patientHealthStatus.isNotEmpty()
                ) {
                    patientStore.addPatient(
                        Patient(
                            patientName,
                            patientVacStatus,
                            patientQID,
                            patientHealthStatus,
                            patientHealthStatus.lowercase(Locale.getDefault())
                        )
                    )
                    navHostController.navigate(Screen.PatientsList.route)
                }
            }) {
                Text(text = "Submit")
            }
        }
    }
}