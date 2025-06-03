import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.archfacts_app_web.R
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

@Composable
fun SimpleEditableEnterpriseScreen() {
    // Local state for all editable fields
    var name by remember { mutableStateOf("Volkswagen") }
    var email by remember { mutableStateOf("volks@gmail.com") }
    var phone by remember { mutableStateOf("9999999999") }
    var description by remember { mutableStateOf("Fundada em 1937, é uma das maiores montadoras do mundo...") }
    var servicesEnterprise by remember {
        mutableStateOf(
            listOf(
                ServiceEnterprise("Carros econômicos", "Possui os carros mais econômicos do mercado.", R.drawable.service3),
                ServiceEnterprise("Carros clássicos", "Possui os carros mais memoráveis do mercado.", R.drawable.service2),
                ServiceEnterprise("Carros estéticos", "Possui carros referência em estética do mercado.", R.drawable.service1)
            )
        )
    }
    var showEditDialog by remember { mutableStateOf(false) }
    var currentServiceIndex by remember { mutableStateOf(-1) } // -1 means adding new

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = name,
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
                // Contact Section
                ContactSec(
                    email = email,
                    phone = phone,
                    onEditClick = { showEditDialog = true }
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Description Section
                DescriptionSec(
                    description = description,
                    onEditClick = { showEditDialog = true }
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Services Section
                ServicesSec(
                    servicesEnterprise = servicesEnterprise,
                    onAddClick = {
                        currentServiceIndex = -1
                        showEditDialog = true
                    },
                    onEditClick = { index ->
                        currentServiceIndex = index
                        showEditDialog = true
                    }
                )
            }
        }
    )

    // Edit Dialog
    if (showEditDialog) {
        if (currentServiceIndex >= 0) {
            // Editing a service
            val service = servicesEnterprise[currentServiceIndex]
            EditServiceDialog(
                serviceEnterprise = service,
                onDismiss = { showEditDialog = false },
                onSave = { updatedService ->
                    servicesEnterprise = servicesEnterprise.toMutableList().apply {
                        set(currentServiceIndex, updatedService)
                    }
                    showEditDialog = false
                }
            )
        } else {
            // Editing enterprise info
            EditEnterpriseDialog(
                name = name,
                email = email,
                phone = phone,
                description = description,
                onDismiss = { showEditDialog = false },
                onSave = { newName, newEmail, newPhone, newDesc ->
                    name = newName
                    email = newEmail
                    phone = newPhone
                    description = newDesc
                    showEditDialog = false
                }
            )
        }
    }
}

@Composable
fun ContactSec(
    email: String,
    phone: String,
    onEditClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF0E0C19))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Coluna com e-mail e telefone
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "E-mail: $email",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Telefone: $phone",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White
                )
            )
        }

        // Ícone de edição alinhado ao centro vertical
        IconButton(
            onClick = onEditClick,
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit",
                tint = Color.White
            )
        }
    }
}

@Composable
fun DescriptionSec(
    description: String,
    onEditClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Descrição da empresa",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )

            IconButton(onClick = onEditClick) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = Color.Black
                )
            }
        }

        Text(
            text = description,
            style = TextStyle(fontSize = 16.sp, color = Color.Black)
        )
    }
}

@Composable
fun ServicesSec(
    servicesEnterprise: List<ServiceEnterprise>,
    onAddClick: () -> Unit,
    onEditClick: (Int) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Serviços",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )

            IconButton(onClick = onAddClick) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Service",
                    tint = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        servicesEnterprise.forEachIndexed { index, service ->
            ServiceCard(
                serviceEnterprise = service,
                onEditClick = { onEditClick(index) }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ServiceCard(
    serviceEnterprise: ServiceEnterprise,
    onEditClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = serviceEnterprise.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = serviceEnterprise.title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = serviceEnterprise.description,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                )
            }

            IconButton(onClick = onEditClick) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = Color.Black
                )
            }
        }
    }
}

@Composable
fun EditEnterpriseDialog(
    name: String,
    email: String,
    phone: String,
    description: String,
    onDismiss: () -> Unit,
    onSave: (String, String, String, String) -> Unit
) {
    var currentName by remember { mutableStateOf(name) }
    var currentEmail by remember { mutableStateOf(email) }
    var currentPhone by remember { mutableStateOf(phone) }
    var currentDesc by remember { mutableStateOf(description) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Editar Empresa") },
        text = {
            Column {
                OutlinedTextField(
                    value = currentName,
                    onValueChange = { currentName = it },
                    label = { Text("Nome") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = currentEmail,
                    onValueChange = { currentEmail = it },
                    label = { Text("E-mail") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = currentPhone,
                    onValueChange = { currentPhone = it },
                    label = { Text("Telefone") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = currentDesc,
                    onValueChange = { currentDesc = it },
                    label = { Text("Descrição") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 3
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                onSave(currentName, currentEmail, currentPhone, currentDesc)
            }) {
                Text("Salvar")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}

@Composable
fun EditServiceDialog(
    serviceEnterprise: ServiceEnterprise,
    onDismiss: () -> Unit,
    onSave: (ServiceEnterprise) -> Unit
) {
    var title by remember { mutableStateOf(serviceEnterprise.title) }
    var description by remember { mutableStateOf(serviceEnterprise.description) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Editar Serviço") },
        text = {
            Column {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Descrição") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 3
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                onSave(serviceEnterprise.copy(title = title, description = description))
            }) {
                Text("Salvar")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}

data class ServiceEnterprise(
    val title: String,
    val description: String,
    val imageRes: Int
)

@Preview
@Composable
fun PreviewSimpleEditableEnterpriseScreen() {
    MaterialTheme {
        SimpleEditableEnterpriseScreen()
    }
}