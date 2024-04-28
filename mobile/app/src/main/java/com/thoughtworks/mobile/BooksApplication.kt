package com.thoughtworks.mobile

import android.app.Application
import com.thoughtworks.mobile.modules.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BooksApplication: Application()  {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BooksApplication)
            modules(appModules)
        }
    }
}