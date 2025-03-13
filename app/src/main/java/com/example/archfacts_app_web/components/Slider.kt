package com.example.archfacts_app_web.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.archfacts_app_web.R
import com.example.archfacts_app_web.ui.theme.ArchBlackTransparent
import com.example.archfacts_app_web.ui.theme.ArchBlue


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Slider(images: List<Int>, width: Dp, height: Dp) {
    val pagerState = rememberPagerState(0, 0f) { images.size }
    Box(
        modifier = Modifier
            .width(width)
            .height(height)
    ) {
        HorizontalPager(
            state = pagerState,
            key = { images[it] },
            pageSize = PageSize.Fill
        ) { page ->
            Image(
                painter = painterResource(id = images[page]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .offset(y = -(16).dp)
                .fillMaxWidth(0.5f)
                .clip(RoundedCornerShape(100))
                .background(ArchBlue)
                .padding(8.dp)
                .align(Alignment.BottomCenter)
        ) {

            PageIndicator(
                pageCount = images.size,
                currentPage = pagerState.currentPage,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        repeat(pageCount) {
            IndicatorDots(isSelected = it == currentPage, modifier = modifier)
        }
    }
}

@Composable
fun IndicatorDots(isSelected: Boolean, modifier: Modifier) {
    val size = animateDpAsState(targetValue = if (isSelected) 12.dp else 10.dp, label = "")
    Box(
        modifier = modifier
            .padding(2.dp)
            .size(size.value)
            .clip(CircleShape)
            .background(if (isSelected) (Color.White) else ArchBlackTransparent)
    )
}

@Preview(showBackground = true)
@Composable
fun SliderPreview() {
    val images = listOf(
        R.drawable.big_carousel1,
        R.drawable.aperto_mao,
        R.drawable.big_carousel2
    )
    Slider(images, 2500.dp, 700.dp)
}