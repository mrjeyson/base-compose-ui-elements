package com.jsoft.myapplication.coreui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.jsoft.myapplication.BuildConfig
import com.jsoft.myapplication.R
import com.jsoft.myapplication.coreui.theme.TheAppTheme

@Composable
fun RoundedImageView(size: Int, url: String?, onclick: () -> Unit) {

    Image(
        painter = rememberImagePainter(
            data = if (url != null) "${BuildConfig.IMAGE_BASE_URL}/w500$url" else com.jsoft.myapplication.R.drawable.movie_place_holder,
            builder = {
                placeholder(com.jsoft.myapplication.R.drawable.movie_place_holder)
            }
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(size.dp)
            .clip(RoundedCornerShape(size / 2))
            .clickable { onclick() }
    )
}


@Composable
fun CorneredImageViewFillWidth(height: Dp = 130.dp, url: String?, onclick: () -> Unit) {
    Image(
        painter = rememberImagePainter(
            data = "${BuildConfig.IMAGE_BASE_URL}/w500$url",
            builder = {
                placeholder(com.jsoft.myapplication.R.drawable.movie_place_holder)
            },
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = height)
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                onclick()
            },
    )
}


@Composable
fun CorneredSquareImageView(size: Dp = 70.dp, url: String?, onclick: () -> Unit) {

    Image(
        painter = rememberImagePainter(
            data = "${BuildConfig.IMAGE_BASE_URL}/w500$url",
            builder = {
                placeholder(com.jsoft.myapplication.R.drawable.movie_place_holder)
            },
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(size)
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                onclick()
            },
    )
}


@Composable
fun CorneredImageView(height: Dp = 130.dp, url: String?, onclick: () -> Unit) {

    Image(
        painter = rememberImagePainter(
            data = "${BuildConfig.IMAGE_BASE_URL}/w500$url",
            builder = {
                placeholder(R.drawable.movie_place_holder)
            },
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(90.dp)
            .height(height = height)
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                onclick()
            },
    )
}


@Composable
fun BackDropImageWithAlpha(height: Dp = 240.dp, url: String?, onclick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
    ) {
        Image(
            painter = rememberImagePainter(
                data = "${BuildConfig.IMAGE_BASE_URL}/w500$url",
                builder = {
                    Column(modifier = Modifier.background(TheAppTheme.colors.primary)) {
                    }
                },
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onclick()
                },
        )

        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Red.copy(alpha = 0.7f), CircleShape)
        )

    }
}

