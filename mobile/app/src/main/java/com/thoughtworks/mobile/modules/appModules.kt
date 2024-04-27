package com.thoughtworks.mobile.modules

import com.google.gson.GsonBuilder
import com.thoughtworks.mobile.data.repository.BooksRepository
import com.thoughtworks.mobile.data.repository.BooksRepositoryImpl
import com.thoughtworks.mobile.data.source.remote.BooksRemoteDataSource
import com.thoughtworks.mobile.data.source.remote.BooksRemoteDataSourceImpl
import com.thoughtworks.mobile.data.source.remote.api.BooksApi
import com.thoughtworks.mobile.ui.fragments.HomeViewModel
import com.thoughtworks.mobile.usecase.FetchBooksUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://localhost:8080"

val appModules = module {
    includes(
        useCaseModules,
    )

    viewModel {
        HomeViewModel(get())
    }
}

val useCaseModules = module {
    includes(
        repositoryModules,
    )

    factory {
        FetchBooksUseCase(get())
    }
}

val repositoryModules = module {
    includes(
        dataSourceModules,
    )

    single<BooksRepository> {
        BooksRepositoryImpl(get())
    }
}

val dataSourceModules = module {
    includes(
        apiHelperModules,
    )

    single<BooksRemoteDataSource> {
        BooksRemoteDataSourceImpl(get(), get())
    }
}

val apiHelperModules = module {
    includes(
        retrofitModules,
    )

    single {
        get<Retrofit>().create(BooksApi::class.java)
    }
}

val retrofitModules = module {
    single {
        GsonBuilder()
            .serializeNulls()
            .create()
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(get()))
            .baseUrl(BASE_URL)
            .build()
    }
}
