package com.atomic.featuredsport.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SportCard(sportCardUiState: SportCardUiState, modifier: Modifier = Modifier) {
    when (sportCardUiState) {
        SportCardUiState.Loading -> Unit
        is SportCardUiState.Success -> {
            Column(modifier.padding(8.dp)) {
                Text(
                    text = sportCardUiState.name,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = modifier
                        .padding(top = 4.dp, bottom = 24.dp)
                        .testTag("SportCardName")
                )
                Text(
                    text = sportCardUiState.description,
                    modifier = modifier.testTag("SportCardDescription")
                )
            }
        }
    }
}

sealed interface SportCardUiState {
    object Loading : SportCardUiState
    data class Success(val name: String, val description: String) : SportCardUiState
}

@Preview
@Composable
fun SportCardLoadingPreview() {
    SportCard(SportCardUiState.Loading)
}

@Preview
@Composable
fun SportCardContentPreview() {
    SportCard(SportCardUiState.Success("Cycling", "Cycling, also called bicycling or biking..."))
}