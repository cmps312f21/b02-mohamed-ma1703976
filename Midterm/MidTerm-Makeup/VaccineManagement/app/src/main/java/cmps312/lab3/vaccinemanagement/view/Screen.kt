package cmps312.lab3.vaccinemanagement.view

sealed class Screen(val route: String, val Title: String) {
    object AddPatient : Screen("AddPatient", "AddPatient")
    object PatientsList : Screen("PatientsList", "PatientsList")
}