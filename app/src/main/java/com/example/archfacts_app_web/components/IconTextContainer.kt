package com.example.archfacts_app_web.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.ui.theme.ArchBlackTransparent
import com.example.archfacts_app_web.ui.theme.Poppins

data class IconTextElement(
    val icon: Painter, val title: String, val desc: String
)

@Composable
fun IconTextLayout(icon: Painter, title: String, desc: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = icon, contentDescription = title, modifier = Modifier.size(48.dp)
        )
        Text(
            text = title,
            fontSize = 24.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            maxLines = 1,
            modifier = Modifier.padding(top = 8.dp)

        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.seta_esquerda),
                contentDescription = "Seta direita",
                modifier = Modifier.size(32.dp)
            )

            Text(
                text = desc,
                fontSize = 16.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Light,
                color = Color.White,
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .weight(1f),
                textAlign = TextAlign.Center

            )

            Image(
                painter = painterResource(id = R.drawable.seta_direita),
                contentDescription = "Seta esquerda",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
fun IconTextContainer() {
    val items = listOf(
        IconTextElement(
            icon = painterResource(id = R.drawable.gestao),
            title = "Desorganização",
            desc = "Um estudo conduzido pela Sebrae aponta que cerca de 79% das empresas brasileiras enfrentam sérios problemas de gestão, o que impactam no seu crescimento e sustentabilidade, portanto afetando o negócio a longo prazo."
        ),
//        IconTextElement(
//            icon = painterResource(id = R.drawable.user_icon),
//            title = "Comunicação com os clientes",
//            desc = "Falhas na comunicação com o cliente se tornam um empecilho no seu negócio, gerando desgaste na relação, atraso na entrega do produto e no pior dos casos, erros pela má comunicação. No fim gerando uma perda para o negócio."
//        ),
//        IconTextElement(
//            icon = painterResource(id = R.drawable.number_one_icon),
//            title = "Priorização de atividades",
//            desc = "Uma pesquisa realizada pela consultoria Falconi revelou a fragilidade na gestão das médias empresas no Brasil. Somente 10% das médias empresas tem planejamentos de longo prazo, a falta de planejamento gera queda na atividade econômica."
//        ),
//        IconTextElement(
//            icon = painterResource(id = R.drawable.fluxo_caixa),
//            title = "Controle do fluxo de caixa",
//            desc = "Sem o controle do fluxo de caixa a sua empresa fica suscetível e imprevistos financeiros podem ser fatais. Um estudo realizado pelo IBGE em 2022 revela que 48% das empresas brasileiras fecham em até 3 anos por conta da má gestão financeira."
//        )
    )

    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Principal ArchFacts",
                modifier = Modifier.size(150.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logo_af),
                contentDescription = "Logo com letras 'AF' ArchFacts",
                modifier = Modifier.size(170.dp),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(ArchBlackTransparent)
                .padding(15.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEach { (icon, title, text) ->
                IconTextLayout(icon, title, text)
            }
        }
    }
}

@Preview
@Composable
fun IconTextContainerPreview() {
    IconTextContainer()
}