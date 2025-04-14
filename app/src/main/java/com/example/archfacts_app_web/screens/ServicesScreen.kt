import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.components.HamburguerMenu // Adjust to your actual package path

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterpriseScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Volkswagen",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                },
                navigationIcon = {
                    HamburguerMenu()
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.Black
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                CompanyInfoSection()
                Spacer(modifier = Modifier.height(24.dp))
                ContactButton()
                Spacer(modifier = Modifier.height(24.dp))
                DescriptionSection()
                Spacer(modifier = Modifier.height(24.dp))
                ServicesSection()
            }
        }
    )
}

@Composable
fun CompanyInfoSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Área de atuação: Automóveis",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "E-mail: volks@gmail.com",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Telefone: (99) 9999-9999",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            )
        )
    }
}

@Composable
fun ContactButton() {
    Button(
        onClick = { /* Handle contact */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )
    ) {
        Text("ENTRAR EM CONTATO", fontWeight = FontWeight.Bold)
    }
}

@Composable
fun DescriptionSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Descrição da empresa",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Fundada em 1937, é uma das maiores montadoras do mundo...",
            style = TextStyle(fontSize = 16.sp, color = Color.Black)
        )
    }
}

@Composable
fun ServicesSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Serviços",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(12.dp))

        ServiceItem("Carros econômicos", "Possui os carros mais econômicos do mercado.")
        ServiceItem("Carros clássicos", "Possui os carros mais memoráveis do mercado.")
        ServiceItem("Carros estéticos", "Possui carros referência em estática do mercado.")
    }
}

@Composable
fun ServiceItem(title: String, description: String) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = "• $title",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = description,
            style = TextStyle(fontSize = 14.sp, color = Color.Black),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VolkswagenScreenPreview() {
    MaterialTheme {
        EnterpriseScreen()
    }
}