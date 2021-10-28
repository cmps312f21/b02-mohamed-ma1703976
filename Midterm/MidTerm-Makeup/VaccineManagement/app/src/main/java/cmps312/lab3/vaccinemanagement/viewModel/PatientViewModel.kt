package cmps312.lab3.vaccinemanagement.viewModel

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import cmps312.lab3.vaccinemanagement.models.Patient
import cmps312.lab3.vaccinemanagement.repos.PatientRepository


class PatientViewModel(appContext: Application) : AndroidViewModel(appContext) {
    val patients = mutableStateListOf(*PatientRepository.getPatients(appContext).toTypedArray())
    private val healthStatus = listOf(
        "Healthy",
        "Quarantine",
        "Infected"
    )
    private val vaccinationStatus = listOf(
        "Vaccinated",
        "Partially",
        "Vac Pending"
    )

    fun addPatient(newPatient: Patient) {
        patients.add(newPatient)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun deletePatient(patientId: String) {
        patients.removeIf { it.QID == patientId }
    }

    @JvmName("getHealthStatus1")
    fun getHealthStatus(): List<String> {
        return healthStatus
    }

    @JvmName("getVaccinationStatus1")
    fun getVaccinationStatus(): List<String> {
        return vaccinationStatus
    }
}