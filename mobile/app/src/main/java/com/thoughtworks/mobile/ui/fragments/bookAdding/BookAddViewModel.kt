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
    val addBook: () -> Unit,
    val changeName: (String) -> Unit,
    val changeAuthor: (String) -> Unit,
    val changePublicationYear: (String) -> Unit,
    val changeIsbn: (String) -> Unit,
)

class BookAddViewModel(private val addBookUseCase: AddBookUseCase) : ViewModel() {
    private val _uiState: MutableStateFlow<BookAddUiState> =
        MutableStateFlow(
            BookAddUiState(
                bookInfo = Book(
                    id = null,
                    name = "",
                    author = "",
                    publicationYear = "",
                    isbn = ""
                ),
                addBook = {
                    addBook()
                },
                changeName = { value ->
                    changeName(value)
                },
                changeAuthor = { value ->
                    changeAuthor(value)
                },
                changePublicationYear = { value ->
                    changePublicationYear(value)
                },
                changeIsbn = { value ->
                    changeIsbn(value)
                }
            )
        )

    val uiState: StateFlow<BookAddUiState> = _uiState.asStateFlow()

    private fun addBook() {
        viewModelScope.launch {
            addBookUseCase.invoke(_uiState.value.bookInfo)
        }
    }

    private fun changeName(value: String) {
        _uiState.value = _uiState.value.copy(bookInfo = _uiState.value.bookInfo.copy(name = value))
    }

    private fun changeAuthor(value: String) {
        _uiState.value =
            _uiState.value.copy(bookInfo = _uiState.value.bookInfo.copy(author = value))
    }

    private fun changePublicationYear(value: String) {
        _uiState.value =
            _uiState.value.copy(bookInfo = _uiState.value.bookInfo.copy(publicationYear = value))
    }

    private fun changeIsbn(value: String) {
        _uiState.value = _uiState.value.copy(bookInfo = _uiState.value.bookInfo.copy(isbn = value))
    }
}