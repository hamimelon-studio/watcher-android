package com.mikeapp.watcher.di

import com.mikeapp.watcher.data.GithubOpenApiRepository
import com.mikeapp.watcher.data.epsn.CurlEspnService
import com.mikeapp.watcher.data.epsn.nba.EspnNbaParser
import com.mikeapp.watcher.data.epsn.TimeStampUtil
import com.mikeapp.watcher.data.epsn.nfl.EspnNflParser
import com.mikeapp.watcher.ui.HomeScreenViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val appModule = module {
    single { TimeStampUtil() }

    single { CurlEspnService(get()) }
    single { EspnNbaParser() }
    single { EspnNflParser() }

    single { GithubOpenApiRepository() }

    viewModel { HomeScreenViewModel() }
}