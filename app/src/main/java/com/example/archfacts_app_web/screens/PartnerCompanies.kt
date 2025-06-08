package com.example.archfacts_app_web.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.data.models.EmpresaParceira
import com.example.archfacts_app_web.data.network.RetrofitInstance
import com.example.archfacts_app_web.navigation.AppRoutes
import com.example.archfacts_app_web.navigation.NavActions
import com.example.archfacts_app_web.viewModel.EmpresasViewModel
import com.example.archfacts_app_web.viewModel.EmpresasViewModelFactory
import kotlinx.coroutines.launch
import retrofit2.http.GET
import retrofit2.http.Path

//// --- MODELO DE DADOS ---
//data class EmpresaParceira(
//    val idNegocio: String,
//    val nome: String,
//    val avaliacao: Double,
//    val dataRegistro: String
//)
//
//
//// --- REPOSITORY ---
//class EmpresaRepository(private val api: ApiService) {
//    suspend fun buscarEmpresasParceiras(): List<EmpresaParceira> = api.getEmpresasParceiras()
//}
//
//// --- VIEWMODEL ---
//class EmpresasViewModel(
//    private val repository: EmpresaRepository
//) : ViewModel() {
//
//    var empresas by mutableStateOf<List<EmpresaParceira>>(emptyList())
//        private set
//    var loading by mutableStateOf(false)
//        private set
//    var erro by mutableStateOf<String?>(null)
//        private set
//
//    fun carregarEmpresas() {
//        loading = true
//        erro = null
//        viewModelScope.launch {
//            try {
//                empresas = repository.buscarEmpresasParceiras()
//            } catch (e: Exception) {
//                erro = "Erro ao buscar empresas: ${e.message}"
//            } finally {
//                loading = false
//            }
//        }
//    }
//}
//
//// --- VIEWMODEL FACTORY ---
//class EmpresasViewModelFactory(
//    private val repository: EmpresaRepository
//) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return EmpresasViewModel(repository) as T
//    }
//}

// --- PARTNER COMPANIES SCREEN ---
@Composable
fun PartnerCompaniesScreen(
    navActions: NavActions,
    viewModel: EmpresasViewModel = viewModel(
        factory = EmpresasViewModelFactory(
            com.example.archfacts_app_web.data.repositories.EmpresaRepository(
                RetrofitInstance.api
            )
        )
    )
) {
    LaunchedEffect(Unit) { viewModel.carregarEmpresas() }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Coloque seu NavbarCorner aqui se quiser
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Empresas Parceiras",
                    fontSize = 26.sp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
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
                            items(viewModel.empresas) { empresa ->
                                EnterpriseCard(
                                    companyName = empresa.nome,
                                    rating = empresa.avaliacao,
                                    dataRegistro = empresa.dataRegistro,
                                    companyImage = R.drawable.volks, // Troque pelo campo correto se tiver imagem real
                                    onClick = {
                                        navActions.navigate(AppRoutes.ServiceScreen.createRoute(empresa.idNegocio))
                                    }
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

// --- EXEMPLO DE ENTERPRISECARD ---
@Composable
fun EnterpriseCard(
    companyName: String,
    rating: Double,
    dataRegistro: String,
    companyImage: Int?,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (companyImage != null) {
                Image(
                    painter = androidx.compose.ui.res.painterResource(id = companyImage),
                    contentDescription = "Logo $companyName",
                    modifier = Modifier.size(64.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = companyName, fontSize = 20.sp, color = MaterialTheme.colorScheme.onSurface)
                Text(text = "Avaliação: $rating", fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface)
                Text(text = "Registrada em: $dataRegistro", fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewPartnerCompaniesScreen() {
    val mockEmpresas = listOf(
        EmpresaParceira("1", "Volkswagen", 4.7, "2023-05-01"),
        EmpresaParceira("2", "Google", 4.9, "2021-08-15")
    )
    MaterialTheme {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(mockEmpresas) { empresa ->
                EnterpriseCard(
                    companyName = empresa.nome,
                    rating = empresa.avaliacao,
                    dataRegistro = empresa.dataRegistro,
                    companyImage = R.drawable.volks,
                    onClick = {}
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}