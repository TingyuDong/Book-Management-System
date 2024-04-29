package com.thoughtworks.mobile.data.repository

import com.thoughtworks.mobile.data.modal.Book
import com.thoughtworks.mobile.data.source.remote.BooksRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface BooksRepository {
    fun getAllBooksStream(): Flow<List<Book>>
    suspend fun addBook(book: Book)
}

class BooksRepositoryImpl(
    private val booksRemoteDataSource: BooksRemoteDataSource,
) : BooksRepository {
    override fun getAllBooksStream(): Flow<List<Book>> {
        return booksRemoteDataSource.latestAllBooks.map { bookList ->
            bookList.map { book ->
                book.apply {
                    name = book.name ?: ""
                    author = book.author ?: ""
                    publicationYear = book.publicationYear ?: ""
                    isbn = book.isbn ?: ""
                }
            }
        }
    }

    override suspend fun addBook(book: Book) {
        return booksRemoteDataSource.addBook(book)
    }
}