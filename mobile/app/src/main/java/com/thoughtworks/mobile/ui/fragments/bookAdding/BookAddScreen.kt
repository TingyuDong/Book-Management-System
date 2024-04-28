package com.thoughtworks.mobile.ui.fragments.bookAdding

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
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
fun BookAddScreen(viewModel: BookAddViewModel) {
    val uiState: BookAddUiState by viewModel.uiState.collectAsStateWithLifecycle()

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
                    text = "Add a book",
                    style = MaterialTheme.typography.titleLarge,
                )
                BookForm(
                    value = uiState.bookInfo,
                    onChangeName = uiState.changeName,
                    onChangeAuthor = uiState.changeAuthor,
                    onChangePublicationYear = uiState.changePublicationYear,
                    onChangeIsbn = uiState.changeIsbn,
                )
                Button(
                    onClick = { /* Handle form submission */ },
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                ) {
                    Text("Submit")
                }
            }
        }
    }
}

@Composable
fun BookForm(
    value: Book,
    onChangeName: (String) -> Unit,
    onChangeAuthor: (String) -> Unit,
    onChangePublicationYear: (String) -> Unit,
    onChangeIsbn: (String) -> Unit
) {
    OutlinedTextField(
        value = value.name,
        onValueChange = { onChangeName(it) },
        label = { Text("book name") },
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    )
    OutlinedTextField(
        value = value.author,
        onValueChange = { onChangeAuthor(it) },
        label = { Text("author") },
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    )
    OutlinedTextField(
        value = value.publicationYear,
        onValueChange = { onChangePublicationYear(it) },
        label = { Text("publication year") },
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    )
    OutlinedTextField(
        value = value.isbn,
        onValueChange = { onChangeIsbn(it) },
        label = { Text("isbn") },
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    )
}