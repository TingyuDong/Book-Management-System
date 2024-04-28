package com.thoughtworks.mobile.usecase

import com.thoughtworks.mobile.data.modal.Book
import com.thoughtworks.mobile.data.repository.BooksRepository
import kotlinx.coroutines.flow.Flow

class FetchBooksUseCase(
    private val booksRepository: BooksRepository,
) {
    fun invoke(): Flow<List<Book>> {
        return booksRepository.getAllBooksStream()
    }
}