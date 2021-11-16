package cmps312.lab3.authormanagement.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.AuthorList.route) {
        composable(route = Screen.AuthorList.route) {
            AuthorList()(navHostController)
        }
        composable(route = Screen.AddList.route) {
            AddAuthor(navHostController)
        }
    }
}