package com.mikeapp.watcher

import android.app.Application
import com.mikeapp.watcher.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class WatcherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WatcherApp)
            modules(appModule)
        }
    }
}