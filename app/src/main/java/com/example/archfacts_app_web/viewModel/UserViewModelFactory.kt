package com.example.archfacts_app_web.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.archfacts_app_web.data.network.RetrofitInstance
import com.example.archfacts_app_web.data.repositories.UserRepository

class UserViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(
            repository = UserRepository(RetrofitInstance.api)
        ) as T
    }
}