package com.thoughtworks.mobile.ui.fragments.bookDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thoughtworks.mobile.data.modal.Book
import com.thoughtworks.mobile.ui.theme.MobileTheme

@Composable
fun BookDetailsScreen(book: Book) {

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
                    text = book.name,
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        }
    }
}