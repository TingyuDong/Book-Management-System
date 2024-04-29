package com.thoughtworks.mobile.ui.fragments.bookDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.thoughtworks.mobile.data.modal.Book
import com.thoughtworks.mobile.ui.theme.MobileTheme

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun BookDetailsScreen(viewModel: BookDetailsViewModel, book: Book) {
    val uiState: BookDetailsUiState by viewModel.uiState.collectAsStateWithLifecycle()

    MobileTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 16.dp),
                    text = "Book Name",
                    style = MaterialTheme.typography.labelMedium,
                )
                Text(
                    modifier = Modifier.padding(vertical = 16.dp),
                    text = book.name,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    modifier = Modifier.padding(vertical = 16.dp),
                    text = "Author",
                    style = MaterialTheme.typography.labelMedium,
                )
                Text(
                    modifier = Modifier.padding(vertical = 16.dp),
                    text = book.author,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    modifier = Modifier.padding(vertical = 16.dp),
                    text = "Publication Year",
                    style = MaterialTheme.typography.labelMedium,
                )
                Text(
                    modifier = Modifier.padding(vertical = 16.dp),
                    text = book.publicationYear,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    modifier = Modifier.padding(vertical = 16.dp),
                    text = "isbn",
                    style = MaterialTheme.typography.labelMedium,
                )
                Text(
                    modifier = Modifier.padding(vertical = 16.dp),
                    text = book.isbn,
                    style = MaterialTheme.typography.titleLarge,
                )
                Button(
                    onClick = uiState.deleteBook,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                ) {
                    Text("Delete")
                }
            }
        }
    }
}