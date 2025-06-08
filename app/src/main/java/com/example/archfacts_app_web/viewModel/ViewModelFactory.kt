package com.example.archfacts_app_web.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.archfacts_app_web.data.network.RetrofitInstance
import com.example.archfacts_app_web.data.repositories.EmpresaRepository
import com.example.archfacts_app_web.data.repositories.UserRepository

// Pode ser Singleton ou Dagger/Hilt, mas para Compose:
class EmpresasViewModelFactory(
    private val repository: EmpresaRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmpresasViewModel(repository) as T
    }
}

class EmpresaDetalheViewModelFactory(
    private val repository: EmpresaRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmpresaDetalheViewModel(repository) as T
    }
}

class UserViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(
            repository = UserRepository(RetrofitInstance.api)
        ) as T
    }
}