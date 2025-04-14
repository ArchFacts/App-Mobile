package com.example.archfacts_app_web.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.components.CardType
import com.example.archfacts_app_web.components.Counter
import com.example.archfacts_app_web.components.NavbarCorner
import com.example.archfacts_app_web.enums.RequestEnum
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.Poppins

data class RequestDetailsData(
    val requestData: RequestData,
    val prestadorName: String,
    val desc: String,
    val dateStart: String,
    val price: Int
)

@Composable
fun DateLine(date: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(R.drawable.calendar),
            contentDescription = "Icone de prancheta",
            tint = ArchBlack,
            modifier = Modifier.size(36.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = date,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            color = ArchBlack,
            fontFamily = Poppins
        )
    }
}

val dados = RequestDetailsData(
    RequestData(
        title = "Validar cores",
        dateEnd = "28 Mar, 10:29",
        status = RequestEnum.FINALIZADO,
        type = CardType.Chamados,
        project = "Projeto de abelhas"
    ),
    prestadorName = "ECORP",
    desc = "Solicito a verificação das cores desejadas para os veículos.",
    dateStart = "07/03/2004",
    price = 2033
)

@Composable
fun RequestDetailsBox(requestDetails: RequestDetailsData = dados, modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                3.dp,
                clip = true,
                ambientColor = Color.Black.copy(alpha = 0.8f),
                spotColor = Color.Black.copy(alpha = 0.8f),
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp))
            .padding(16.dp),
        color = Color.White,
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .height(350.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            ) {
                Text(
                    text = dados.requestData.title,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = ArchBlue,
                    fontFamily = Poppins
                )
                Icon(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "Icone de chamado",
                    tint = dados.requestData.type.backgroundColor,
                    modifier = Modifier.size(42.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            ) {
                Text(
                    text = dados.requestData.project,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = ArchBlue,
                    fontFamily = Poppins
                )

                Spacer(Modifier.width(10.dp))

                Icon(
                    painter = painterResource(
                        id = when (dados.requestData.type) {
                            CardType.Chamados -> R.drawable.pasta
                            CardType.Tarefas -> R.drawable.clipboard
                        }
                    ),
                    contentDescription = "Icone de chamado",
                    tint = dados.requestData.type.backgroundColor,
                    modifier = Modifier
                        .size(24.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .background(dados.requestData.status.color)
                )

                Spacer(Modifier.width(5.dp))

                Text(
                    text = dados.requestData.status.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = ArchBlack,
                    fontFamily = Poppins
                )

            }

            Column(modifier = Modifier.fillMaxWidth()) {
                DateLine(dados.dateStart)
                DateLine(dados.requestData.dateEnd)
            }

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Descrição:",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = ArchBlack,
                    fontFamily = Poppins
                )
                Text(
                    text = dados.desc,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    color = ArchBlue,
                    fontFamily = Poppins
                )
            }
        }
    }
}


@Composable
fun PriceBox() {

}

@Composable
fun RequestDetails(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                NavbarCorner()

                Row(modifier = Modifier.padding(8.dp)) {
                    Text(
                        "Chamados ${dados.prestadorName}",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = ArchBlue,
                        fontFamily = Poppins,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                RequestDetailsBox(modifier = Modifier.padding(5.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp)
                ) {
                    Text(
                        text = "Detalhes do chamado",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Medium,
                        color = ArchBlack,
                        fontFamily = Poppins
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "Icone de chamado",
                        tint = dados.requestData.type.backgroundColor,
                        modifier = Modifier.size(42.dp)
                    )

                }
            }
        },
        bottomBar = {

        }
    )
}

@Preview
@Composable
fun RequestDetailsPreview() {
    RequestDetails()
}