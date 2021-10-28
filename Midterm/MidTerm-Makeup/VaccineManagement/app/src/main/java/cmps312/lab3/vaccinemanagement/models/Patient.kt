package cmps312.lab3.vaccinemanagement.models
import kotlinx.serialization.Serializable

@Serializable
data class Patient(
    val name: String,
    val vaccineStatus: String,
    val QID: String,
    val healthStatus: String,
    val image: String,
)