package com.example.archfacts_app_web.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.example.archfacts_app_web.data.network.ApiService
import com.example.archfacts_app_web.data.network.RetrofitInstance
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.data.models.Servico
import com.example.archfacts_app_web.data.repositories.ServicoRepository
import com.example.archfacts_app_web.navigation.NavActions
import kotlinx.coroutines.launch
import retrofit2.http.GET
import retrofit2.http.Path





// --- VIEWMODEL ---
class ServicosViewModel(
    private val repository: ServicoRepository
) : ViewModel() {

    var servicos by mutableStateOf<List<Servico>>(emptyList())
        private set
    var loading by mutableStateOf(false)
        private set
    var erro by mutableStateOf<String?>(null)
        private set

    fun carregarServicos(idNegocio: String) {
        loading = true
        erro = null
        viewModelScope.launch {
            try {
                servicos = repository.buscarServicosEmpresa(idNegocio)
            } catch (e: Exception) {
                erro = "Erro ao buscar serviços: ${e.message}"
            } finally {
                loading = false
            }
        }
    }
}

// --- VIEWMODEL FACTORY ---
class ServicosViewModelFactory(
    private val repository: ServicoRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ServicosViewModel(repository) as T
    }
}

// --- SERVICE SCREEN ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceScreen(
    idNegocio: String,
    navActions: NavActions,
    viewModel: ServicosViewModel = viewModel(
        factory = ServicosViewModelFactory(
            ServicoRepository(RetrofitInstance.api)
        )
    )
) {
    LaunchedEffect(idNegocio) { viewModel.carregarServicos(idNegocio) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Serviços da empresa") })
        },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                when {
                    viewModel.loading -> {
                        Box(
                            Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) { CircularProgressIndicator() }
                    }
                    viewModel.erro != null -> {
                        Box(
                            Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) { Text("Erro: ${viewModel.erro}") }
                    }
                    else -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            items(viewModel.servicos) { servico ->
                                ServiceCard(
                                    title = servico.nome,
                                    description = servico.descricao,
                                    imageRes = R.drawable.service1 // Troque para o correto se tiver imagem
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                        }
                    }
                }
            }
        }
    )
}

// --- SERVICE CARD (reaproveite o seu, mas aqui vai um exemplo simples) ---
@Composable
fun ServiceCard(
    title: String,
    description: String,
    imageRes: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Ícone serviço",
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, fontSize = 18.sp, color = MaterialTheme.colorScheme.onSurface)
                Text(text = description, fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface)
            }
        }
    }
}

// --- PREVIEW SERVICE SCREEN (com MOCK) ---
@Preview(showBackground = true)
@Composable
fun PreviewServiceScreen() {
    val mockServicos = listOf(
        Servico("1", "Carros Econômicos", "Possui os carros mais econômicos do mercado."),
        Servico("2", "Carros Clássicos", "Possui os carros mais memoráveis do mercado.")
    )
    MaterialTheme {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(mockServicos) { servico ->
                ServiceCard(
                    title = servico.nome,
                    description = servico.descricao,
                    imageRes = R.drawable.service1 // Troque para o correto se tiver imagem
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}