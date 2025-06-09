import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.NavbarCorner

@Composable
fun EnterpriseScreen() {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
               
//                NavbarCorner()

                Row(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Volkswagen",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.volks),
                        contentDescription = "Logo Volks",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                ContactSection()
                Spacer(modifier = Modifier.height(24.dp))
                DescriptionSection()
                Spacer(modifier = Modifier.height(24.dp))
                ServicesSection()
            }
        }
    )
}

@Composable
fun ContactSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF0E0C19))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Área de atuação: Automóveis",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "E-mail: volks@gmail.com",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Telefone: (99) 9999-9999",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.White
            )
        )


        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* ação do botão */ },
            modifier = Modifier
                .width(170.dp)
                .height(32.dp)
                .clip(RoundedCornerShape(0.dp)),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF033E8C),
                contentColor = Color.White
            )
        ) {
            Text("Entrar Em Contato", fontWeight = FontWeight.Bold)
        }
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
fun ServicesSection(
    services: List<Service> = listOf(
        Service(
            title = "Carros econômicos",
            description = "Possui os carros mais econômicos do mercado.",
            imageRes = R.drawable.service3
        ),
        Service(
            title = "Carros clássicos",
            description = "Possui os carros mais memoráveis do mercado.",
            imageRes = R.drawable.service2
        ),
        Service(
            title = "Carros estéticos",
            description = "Possui carros referência em estética do mercado.",
            imageRes = R.drawable.service1
        )
    )
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp) // Padding lateral para não colar nas bordas
    ) {
        Text(
            text = "Serviços",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        services.forEach { service ->
            ServiceCard(
                title = service.title,
                description = service.description,
                imageRes = service.imageRes
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ServiceCard(
    title: String,
    description: String,
    imageRes: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagem à esquerda
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Textos à direita
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                )
            }
        }
    }
}

// Modelo de dados mantido igual
data class Service(
    val title: String,
    val description: String,
    val imageRes: Int
)

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    MaterialTheme {
        EnterpriseScreen()
    }
}