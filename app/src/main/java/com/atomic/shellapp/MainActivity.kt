@file:OptIn(ExperimentalMaterial3Api::class)

package com.atomic.shellapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.atomic.featuredsport.ui.SportCard
import com.atomic.featuredsport.ui.SportCardUiState
import com.atomic.shellapp.ui.component.LoadingIndicator
import com.atomic.shellapp.ui.theme.ShellAppTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShellAppTheme {
                val viewModel: MainActivityViewModel = viewModel()
                val data by viewModel.data.observeAsState()

                LaunchedEffect(key1 = Unit) {
                    viewModel.fetchData()
                }

                Scaffold(
                    topBar = { TopBar { viewModel.fetchData() } },
                    content = {
                        Box {
                            LazyColumn(contentPadding = it) {
                                item {
                                    data?.let { it1 -> SportCard(it1) }
                                }
                            }
                            if (data == SportCardUiState.Loading) {
                                LoadingIndicator()
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun TopBar(onRefreshClick: (() -> Unit)) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name)
            )
        },
        actions = {
            IconButton(onClick = onRefreshClick) {
                Icon(Icons.Filled.Refresh, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    )
}