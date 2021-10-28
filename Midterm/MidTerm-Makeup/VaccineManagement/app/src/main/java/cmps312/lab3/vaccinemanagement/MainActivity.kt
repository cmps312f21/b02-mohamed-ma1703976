package cmps312.lab3.vaccinemanagement

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.rememberNavController
import cmps312.lab3.vaccinemanagement.common.getCurrentRoute
import cmps312.lab3.vaccinemanagement.ui.theme.VaccineManagementTheme
import cmps312.lab3.vaccinemanagement.view.AppNavigation
import cmps312.lab3.vaccinemanagement.view.Screen

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VaccineManagementTheme {
// A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MainScreen() {
    val navHostController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
            ) {
                if (getCurrentRoute(navController = navHostController) == "AddPatient") {
                    IconButton(onClick = { navHostController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back Arrow"
                        )
                    }
                }
                Text(
                    text = if (getCurrentRoute(navController = navHostController) == "AddPatient") "Add Patient" else " Patient List",
                    fontWeight = FontWeight.Bold
                )
            }
        },
        floatingActionButton = {
            if (getCurrentRoute(navController = navHostController) != "AddPatient") {
                IconButton(
                    onClick = {
                        navHostController.navigate(Screen.AddPatient.route)
                    },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(
                            Color.Blue
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Floating Button",
                        tint = Color.White
                    )
                }
            }
        }
    ) {
        AppNavigation(navHostController)
    }
}