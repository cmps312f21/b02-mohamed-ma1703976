package cmps312.lab3.authormanagement.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cmps312.lab3.authormanagement.entity.Author
import cmps312.lab3.authormanagement.viewModle.AuthorViewModel

@Composable
fun AddAuthor (onAddProject: () -> Unit) {
    val authorViewModel =
        viewModel<AuthorViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val context = LocalContext.current

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }

    Card(modifier = Modifier
    .padding(16.dp)
    .fillMaxWidth()
    .fillMaxSize(), elevation = 16.dp) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            Text(text = "Add Author",
                Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(16.dp), fontWeight = FontWeight.Bold)

            OutlinedTextField(value = firstName,
                onValueChange = { firstName = it },
                label = { Text(text = "first Name ") },
                modifier = Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(16.dp)
                    .fillMaxWidth()
            )
            OutlinedTextField(value = lastName,
                onValueChange = { lastName = it },
                label = { Text(text = "last Name ") },
                modifier = Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(16.dp)
                    .fillMaxWidth()
            )
            Dropdown(
                label = "Select Author Rating",
                options = authorViewModel.getautorRating(),
                selectedOption = rating,
                onSelectionChange = { rating = it }
            )

            Button(onClick = {
                if (firstName.isNotEmpty() && lastName.isNotEmpty() &&
                    rating.isNotEmpty()
                ) {
                    authorViewModel.addAuthor(
                        Author(
                            firstName = firstName,
                            lastName = lastName,
                            rating = rating,
                        )
                    )

                }
            }) {
                Text(text = "Add Author")
            }
        }
    }


}