package com.mikeapp.watcher.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    val uiState: MutableStateFlow<String> = MutableStateFlow("")

    fun query() {
        uiState.value = "start querying..."
        viewModelScope.launch(IO) {
        }
        uiState.value = "querying completed!"
    }
}