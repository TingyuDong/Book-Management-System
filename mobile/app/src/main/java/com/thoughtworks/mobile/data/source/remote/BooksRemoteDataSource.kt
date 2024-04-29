package com.thoughtworks.mobile.data.source.remote

import com.thoughtworks.mobile.data.modal.Book
import com.thoughtworks.mobile.data.source.remote.api.BooksApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface BooksRemoteDataSource {
    suspend fun addBook(book: Book)
    suspend fun deleteBook(bookId: Long)
    var latestAllBooks: Flow<List<Book>>
}

class BooksRemoteDataSourceImpl(
    private val booksApi: BooksApi,
    private val refreshIntervalMs: Long = 5000
) : BooksRemoteDataSource {
    override suspend fun addBook(book: Book) {
        booksApi.addBook(book)
    }

    override suspend fun deleteBook(bookId: Long) {
        booksApi.deleteBook(bookId)
    }

    override var latestAllBooks: Flow<List<Book>> = flow {
        while (true) {
            val latestAllBooks = booksApi.fetchAllBooks()
            emit(latestAllBooks)
            delay(refreshIntervalMs)
        }
    }

}