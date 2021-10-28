package cmps312.lab3.vaccinemanagement.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cmps312.lab3.vaccinemanagement.models.Patient
import cmps312.lab3.vaccinemanagement.R

@Composable
fun PatientCard(
    patient: Patient,
    navHostController: NavHostController,
    removePatient: (String) -> Unit
) {
    val statusColors = mapOf(
        "Infected" to R.drawable.infected,
        "Healthy" to R.drawable.healthy,
        "Quarantine" to R.drawable.quarantine,
    )
    Card(
        elevation = 12.dp,
        modifier = Modifier
            .padding(9.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = statusColors[patient.healthStatus]!!),
                contentDescription = "The Patients Health Status",
                modifier = Modifier.width(80.dp)
            )
            Column() {
                Text(text = "Name: ${patient.name}")
                Text(text = "Vaccine Status: ${patient.vaccineStatus}")
                Text(text = "QID: ${patient.QID}")
                Text(text = "Health Status: ${patient.healthStatus}")
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Row() {
                    Spacer(modifier = Modifier.width(6.dp))
                    IconButton(onClick = {
                        removePatient(patient.QID)
                    }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Icon")
                    }
                }
            }
        }
    }
}