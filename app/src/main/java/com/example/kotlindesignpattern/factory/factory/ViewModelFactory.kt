package com.example.kotlindesignpattern.factory.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import okhttp3.Dispatcher
import javax.inject.Provider


fun <VM : ViewModel> Provider<out VM>.asViewModelFactory(): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return get() as T
        }
    }
}