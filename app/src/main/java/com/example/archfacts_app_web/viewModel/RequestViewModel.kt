package com.example.archfacts_app_web.viewModel

import androidx.lifecycle.ViewModel
import com.example.archfacts_app_web.components.CardType
import com.example.archfacts_app_web.data.repositories.RequestsRepositoryMock
import com.example.archfacts_app_web.screens.RequestData

class RequestsViewModel : ViewModel() {
    private val repository = RequestsRepositoryMock()

    fun getRequests(type: CardType): List<RequestData> {
        return repository.getRequests(type)
    }
}