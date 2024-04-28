package com.thoughtworks.mobile.ui.fragments.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.thoughtworks.mobile.data.modal.Book
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
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                content = {
                    items(uiState.books.chunked(3)) { rowBooks ->
                        BookItems(
                            books = rowBooks,
                        )
                    }
                }
            )
            FloatingButton(onClick = onClick)
        }
    }
}

@Composable
fun BookItems(books: List<Book>) {
    Row(Modifier.padding(8.dp)) {
        books.forEach { book ->
            BookItem(book)
        }
    }
}

@Composable
fun BookItem(book: Book) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .size(width = 120.dp, height = 150.dp),
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = book.name)
            Text(text = "By ${book.author}")
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