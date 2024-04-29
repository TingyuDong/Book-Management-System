package com.thoughtworks.mobile.data.source.remote.api

import com.thoughtworks.mobile.data.modal.Book
import retrofit2.http.*

interface BooksApi {
    @GET("books")
    suspend fun fetchAllBooks(): List<Book>

    @POST("books")
    suspend fun addBook(@Body book: Book): Book

    @DELETE("books/{id}")
    suspend fun deleteBook(@Path("id") bookId: Long): Book
}