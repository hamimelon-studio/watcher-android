package com.mikeapp.watcher.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(modifier: Modifier) {
    val viewModel: HomeScreenViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsState()

    WoolworthsWebScreen {
        Log.d("bbbb", it)
    }
}