package com.thoughtworks.mobile.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thoughtworks.mobile.data.modal.Book
import com.thoughtworks.mobile.usecase.FetchBooksUseCase
import com.thoughtworks.mobile.utils.WhileUiSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class HomeUiState(
    val books: List<Book> = emptyList(),
)

class HomeViewModel(
    fetchBooksUseCase: FetchBooksUseCase
) : ViewModel() {
    private var _booksAsync = fetchBooksUseCase.invoke()

    val uiState: StateFlow<HomeUiState> = _booksAsync.map {
        HomeUiState(books = it)
    }.stateIn(
        scope = viewModelScope ,
        started = WhileUiSubscribed,
        initialValue = HomeUiState(books = emptyList())
    )
}

