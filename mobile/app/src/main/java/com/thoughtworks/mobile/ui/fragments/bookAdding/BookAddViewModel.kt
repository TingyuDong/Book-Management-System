package com.thoughtworks.mobile.ui.fragments.bookAdding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thoughtworks.mobile.data.modal.Book
import com.thoughtworks.mobile.usecase.AddBookUseCase
import kotlinx.coroutines.launch

class BookAddViewModel(private val addBookUseCase: AddBookUseCase) : ViewModel() {
    fun addBook(book: Book) {
        viewModelScope.launch {
            addBookUseCase.invoke(book)
        }
    }
}