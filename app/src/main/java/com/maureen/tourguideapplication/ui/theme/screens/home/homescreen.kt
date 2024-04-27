package com.maureen.tourguideapplication.ui.theme.screens.home
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TourGuideHomeScreen(
    allCities: List<String>,
    onCitySelected: (String) -> Unit,
) {
    var query by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        SearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = {
                keyboardController?.hide()
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CitySuggestions(
            allCities = allCities,
            query = query,
            onCitySelected = onCitySelected
        )
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Search city...") },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search,
            keyboardType = KeyboardType.Text
        ),
        keyboardActions = KeyboardActions(
            onSearch = { onSearch() }
        ),
        singleLine = true,
//        colors = TextFieldDefaults.textFieldColors(
//            background= android.graphics.Color()
//            focusedIndicatorColor = Color.Blue,
//            unfocusedIndicatorColor = Color.Gray
        )
//    )
}

@Composable
fun CitySuggestions(
    allCities: List<String>,
    query: String,
    onCitySelected: (String) -> Unit
) {
    val filteredCities = if (query.isBlank()) {
        allCities
    } else {
        allCities.filter { it.contains(query, ignoreCase = true) }
    }

    LazyColumn {
        items(filteredCities) { city ->
            Text(
                text = city,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onCitySelected(city) },
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TourGuideHomeScreenPreview() {
    val cities = listOf(
        "New York",
        "Los Angeles",
        "Chicago",
        "Houston",
        "Phoenix",
        "Philadelphia",
        "San Antonio",
        "San Diego",
        "Dallas",
        "San Jose"
    )

    TourGuideHomeScreen(allCities = cities, onCitySelected = { city -> println("City Selected: $city") })
}
