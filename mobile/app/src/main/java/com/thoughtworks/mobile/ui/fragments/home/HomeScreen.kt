package com.thoughtworks.mobile.ui.fragments.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.thoughtworks.mobile.ui.fragments.HomeUiState
import com.thoughtworks.mobile.ui.fragments.HomeViewModel
import com.thoughtworks.mobile.ui.theme.MobileTheme

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel, onClick: () -> Unit) {
    val uiState: HomeUiState by viewModel.uiState.collectAsStateWithLifecycle()

    MobileTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            FloatingButton(onClick = onClick)
        }
    }
}

@Composable
fun FloatingButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = { onClick() },
        ) {
            Icon(Icons.Filled.Add, "Add book button")
        }
    }
}