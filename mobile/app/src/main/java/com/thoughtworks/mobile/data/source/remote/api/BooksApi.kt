package com.thoughtworks.mobile.data.source.remote.api

import com.thoughtworks.mobile.data.modal.Book
import retrofit2.http.GET

interface BooksApi {
    @GET("books")
    suspend fun fetchAllBooks(): List<Book>
}