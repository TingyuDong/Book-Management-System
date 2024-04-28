package com.thoughtworks.mobile.ui.fragments.bookAdding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thoughtworks.mobile.data.modal.Book
import com.thoughtworks.mobile.usecase.AddBookUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class BookAddUiState(
    val bookInfo: Book,
    val changeName: (String) -> Unit,
    val changeAuthor: (String) -> Unit,
    val changePublicationYear: (String) -> Unit,
    val changeIsbn: (String) -> Unit,
)

class BookAddViewModel(private val addBookUseCase: AddBookUseCase) : ViewModel() {
    private var _uiState: MutableStateFlow<BookAddUiState> =
        MutableStateFlow(
            BookAddUiState(
                bookInfo = Book(
                    id = null,
                    name = "",
                    author = "",
                    publicationYear = "",
                    isbn = ""
                ),
                changeName = { value: String ->
                    changeName(value)
                },
                changeAuthor = { value: String ->
                    changeAuthor(value)
                },
                changePublicationYear = { value: String ->
                    changePublicationYear(value)
                },
                changeIsbn = { value: String ->
                    changeIsbn(value)
                }
            )
        )

    val uiState: StateFlow<BookAddUiState> = _uiState.asStateFlow()

    fun addBook(book: Book) {
        viewModelScope.launch {
            addBookUseCase.invoke(book)
        }
    }

    private fun changeName(value: String) {
        _uiState.value = _uiState.value.copy(bookInfo = _uiState.value.bookInfo.copy(name = value))
    }

    fun changeAuthor(value: String) {
        _uiState.value =
            _uiState.value.copy(bookInfo = _uiState.value.bookInfo.copy(author = value))
    }

    fun changePublicationYear(value: String) {
        _uiState.value =
            _uiState.value.copy(bookInfo = _uiState.value.bookInfo.copy(publicationYear = value))
    }

    fun changeIsbn(value: String) {
        _uiState.value = _uiState.value.copy(bookInfo = _uiState.value.bookInfo.copy(isbn = value))
    }
}