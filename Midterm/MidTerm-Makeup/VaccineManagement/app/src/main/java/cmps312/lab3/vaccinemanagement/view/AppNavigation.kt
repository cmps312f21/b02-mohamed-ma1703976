package cmps312.lab3.vaccinemanagement.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.PatientsList.route) {
        composable(route = Screen.PatientsList.route) {
            PatientList(navHostController)
        }
        composable(route = Screen.AddPatient.route) {
            AddPatient(navHostController)
        }
    }
}