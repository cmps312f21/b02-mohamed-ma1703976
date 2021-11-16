package cmps312.lab3.authormanagement.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import cmps312.lab3.authormanagement.viewModle.AuthorViewModel

@Composable

fun AuthorList (navHostController: NavHostController){

    val patientStore =
        viewModel<AuthorViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val author =
    LazyColumn() {
        }
    }
}