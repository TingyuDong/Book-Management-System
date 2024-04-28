package com.thoughtworks.mobile.data.source.remote.api

import com.thoughtworks.mobile.data.modal.Book
import retrofit2.http.GET
import retrofit2.http.POST

interface BooksApi {
    @GET("books")
    suspend fun fetchAllBooks(): List<Book>

    @POST("books")
    suspend fun addBook(book: Book)
}