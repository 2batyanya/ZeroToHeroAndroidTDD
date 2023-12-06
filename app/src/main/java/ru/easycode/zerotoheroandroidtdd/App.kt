package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App: Application() {

    lateinit var viewModel: MainViewModel // если нужен applicationContext, то инициализируем в onCreate

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(ListLiveDataWrapper.Base())
    }

}