package com.example.archfacts_app_web.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.ui.theme.ArchBlue
import com.example.archfacts_app_web.ui.theme.Poppins

data class SlideContent(
    val image: Int,
    val text: String,
)

@Composable
fun ProfileSlider(
    slides: List<SlideContent>,
    width: Dp,
    height: Dp,
    pagerState: PagerState
) {
    
    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .clip(RoundedCornerShape(16.dp))
            .shadow(
                12.dp,
                RoundedCornerShape(16.dp),
                clip = true,
                ambientColor = Color.Black.copy(alpha = 0.8f),
                spotColor = Color.Black.copy(alpha = 0.8f)
            )
    ) {
        HorizontalPager(
            state = pagerState,
            key = { slides[it].image },
            pageSize = PageSize.Fill
        ) { page ->
            Image(
                painter = painterResource(id = slides[page].image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(ArchBlue)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = slides[pagerState.currentPage].text,
                fontSize = 24.sp,
                fontFamily = Poppins,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        PageIndicator(
            pageCount = slides.size,
            currentPage = pagerState.currentPage,
            modifier = Modifier
        )
    }
}


@Preview
@Composable
fun ProfileSliderPreview() {
    val slides = listOf(
        SlideContent(
            image = R.drawable.beneficiario,
            text = "Sou um beneficiário"
        ),
        SlideContent(
            image = R.drawable.prestador,
            text = "Sou um prestador"
        ),
        SlideContent(
            image = R.drawable.funcionario,
            text = "Sou um funcionário"
        )
    )
    ProfileSlider(
        slides, 800.dp, 500.dp,
        pagerState = TODO()
    )
}