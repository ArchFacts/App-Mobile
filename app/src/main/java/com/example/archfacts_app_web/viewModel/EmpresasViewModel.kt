package com.example.archfacts_app_web.viewModel

// EmpresasViewModel.kt
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.archfacts_app_web.data.models.EmpresaParceira
import com.example.archfacts_app_web.data.repositories.EmpresaRepository
import kotlinx.coroutines.launch

class EmpresasViewModel(
    private val repository: EmpresaRepository
) : ViewModel() {

    var empresas by mutableStateOf<List<EmpresaParceira>>(emptyList())
        private set

    var loading by mutableStateOf(false)
        private set

    var erro by mutableStateOf<String?>(null)
        private set

    fun carregarEmpresas() {
        loading = true
        erro = null
        viewModelScope.launch {
            try {
                empresas = repository.buscarEmpresasParceiras()
            } catch (e: Exception) {
                erro = "Erro ao buscar empresas"
            } finally {
                loading = false
            }
        }
    }
}

// ServiceScreenViewModel.kt (ou ProposalConfirmation1ViewModel.kt)
class EmpresaDetalheViewModel(
    private val repository: EmpresaRepository
) : ViewModel() {

    var empresa by mutableStateOf<EmpresaParceira?>(null)
        private set

    var loading by mutableStateOf(false)
        private set

    var erro by mutableStateOf<String?>(null)
        private set

    fun carregarEmpresa(idNegocio: String) {
        loading = true
        erro = null
        viewModelScope.launch {
            try {
                empresa = repository.buscarEmpresaPorId(idNegocio)
            } catch (e: Exception) {
                erro = "Erro ao buscar detalhes"
            } finally {
                loading = false
            }
        }
    }
}