package com.thoughtworks.mobile.data.repository

import com.thoughtworks.mobile.data.modal.Book
import com.thoughtworks.mobile.data.source.remote.BooksRemoteDataSource
import kotlinx.coroutines.flow.Flow

interface BooksRepository {
    fun getAllBooksStream(): Flow<List<Book>>
}

class BooksRepositoryImpl(
    private val booksRemoteDataSource: BooksRemoteDataSource,
): BooksRepository {
    override fun getAllBooksStream(): Flow<List<Book>> {
        return booksRemoteDataSource.latestAllBooks
    }
}