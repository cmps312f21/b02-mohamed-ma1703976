package cmps312.lab3.covidtrackerapp.Views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBar(state: String, onSearchTextChange: (String) -> Unit) {
    TextField(
        value = state,
        onValueChange = { onSearchTextChange(it) },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        textStyle = TextStyle(fontSize = 13.sp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        trailingIcon = {
            if (state.isNotEmpty())
                IconButton(
                    onClick = { onSearchTextChange("") }
                ) { Icon(Icons.Default.Cancel, contentDescription = "Clear Text") }
        }
    )
}