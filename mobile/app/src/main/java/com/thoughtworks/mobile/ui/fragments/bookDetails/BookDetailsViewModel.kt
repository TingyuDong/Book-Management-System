package com.thoughtworks.mobile.ui.fragments.bookDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thoughtworks.mobile.data.modal.Book
import com.thoughtworks.mobile.ui.fragments.bookAdding.BookAddUiState
import com.thoughtworks.mobile.usecase.DeleteBookUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class BookDetailsUiState(
    val bookInfo: Book,
    val deleteBook: () -> Unit,
    val initBookInfo: (Book) -> Unit,
)

class BookDetailsViewModel(private val deleteBookUseCase: DeleteBookUseCase) : ViewModel(
) {
    private val _uiState: MutableStateFlow<BookDetailsUiState> =
        MutableStateFlow(
            BookDetailsUiState(
                bookInfo = Book(
                    id = null,
                    name = "",
                    author = "",
                    publicationYear = "",
                    isbn = ""
                ),
                deleteBook = {
                    deleteBook()
                },
                initBookInfo = { book ->
                    initBookInfo(book)
                }
            )
        )
    val uiState: StateFlow<BookDetailsUiState> = _uiState.asStateFlow()

    fun initBookInfo(book: Book) {
        _uiState.value = _uiState.value.copy(bookInfo = book)
    }

    private fun deleteBook() {
        viewModelScope.launch {
            uiState.value.bookInfo.id?.let { deleteBookUseCase.invoke(it) }
        }
    }
}