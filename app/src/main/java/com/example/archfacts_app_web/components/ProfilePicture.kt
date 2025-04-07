package com.example.archfacts_app_web.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.R

@Composable
fun ProfilePicture(painter: Painter, size: Int, modifier: Modifier) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .clip(CircleShape)
    ) {
        Image(
            painter = painter,
            contentDescription = "Foto de perfil",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }

}

@Preview
@Composable
fun ProfilePicturePreview() {
    ProfilePicture(
        painter = painterResource(id = R.drawable.ecorp_logo),
        size = 128,
        modifier = Modifier
    )
}