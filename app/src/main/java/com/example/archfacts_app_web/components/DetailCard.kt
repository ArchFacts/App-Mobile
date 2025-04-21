package com.example.archfacts_app_web.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.ui.theme.ArchBlack
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.ArchOrange
import com.example.archfacts_app_web.ui.theme.Poppins
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DetailCardType(
    val icon: ImageVector,
    val iconColor: Color,
    val showButton: Boolean
) {
    data object Default : DetailCardType(
        icon = Icons.Filled.Folder,
        iconColor = ArchBlue,
        showButton = true
    )

    data object SemBotao : DetailCardType(
        icon = Icons.Filled.Folder,
        iconColor = ArchOrange,
        showButton = false
    )

    data class Custom(
        val customIcon: ImageVector,
        val customColor: Color,
        val customShowButton: Boolean
    ) : DetailCardType(customIcon, customColor, customShowButton)
}


@Composable
fun DetailCard(
    title: String,
    status: String,
    startDate: String,
    endDate: String,
    buttonText: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    cardType: DetailCardType = DetailCardType.Default
) {
    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = ArchBlue
            )

            Icon(
                imageVector = cardType.icon,
                contentDescription = "Projeto",
                tint = cardType.iconColor,
                modifier = Modifier.size(40.dp)
            )
            }
        if (!cardType.showButton) {
            Text(
                text = "Júlia Campioto",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = ArchBlue,
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 8.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(ArchBlue)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = " $status",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = ArchBlack
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = "Calendário",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "$startDate (Início)", fontSize = 20.sp, color = ArchBlack)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = "Calendário",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "$endDate (Fim)", fontSize = 20.sp, color = ArchBlack)
        }

        if (cardType.showButton) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomButton(
                    text = buttonText,
                    onClick = onButtonClick,
                    width = 150.dp,
                    height = 50.dp,
                    backgroundColor = ArchOrange,
                    fontSize = 16.sp,
                    textColor = Color.White,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}