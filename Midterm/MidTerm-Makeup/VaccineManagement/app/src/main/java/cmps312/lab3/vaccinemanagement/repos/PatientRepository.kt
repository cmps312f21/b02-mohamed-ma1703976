package cmps312.lab3.vaccinemanagement.repos

import android.content.Context
import cmps312.lab3.vaccinemanagement.models.Patient
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object PatientRepository {
    var patientList = listOf<Patient>()
    fun getPatients(context: Context): List<Patient> {
        if (patientList.isEmpty()) {
            val patientsJson =
                context.assets.open("patient.json").bufferedReader().use { it.readText() }
            patientList = Json.decodeFromString(patientsJson)
        }
        return patientList
    }
}