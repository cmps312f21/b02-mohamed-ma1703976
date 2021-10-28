package cmps312.lab3.vaccinemanagement.view

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import cmps312.lab3.vaccinemanagement.viewModel.PatientViewModel

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun PatientList(navHostController: NavHostController) {
    val patientStore =
        viewModel<PatientViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val patients = patientStore.patients
    LazyColumn() {
        items(patients) {
            PatientCard(
                it,
                navHostController,
                removePatient = { patientId -> patientStore.deletePatient(patientId) })
        }
    }

}