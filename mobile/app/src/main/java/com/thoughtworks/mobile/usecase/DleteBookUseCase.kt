package com.thoughtworks.mobile.usecase

import com.thoughtworks.mobile.data.modal.Book
import com.thoughtworks.mobile.data.repository.BooksRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DeleteBookUseCase(
    private val booksRepository: BooksRepository,
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun invoke(bookId: Long) = withContext(ioDispatcher) {
        booksRepository.deleteBook(bookId)
    }
}