package com.jsoft.myapplication.coreui.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.jsoft.myapplication.BuildConfig
import com.jsoft.myapplication.coreui.composable.base.Spacer2dp
import com.jsoft.myapplication.coreui.theme.TheAppTheme

@SuppressLint("RememberReturnType")
@Composable
fun CoverImage(
    height: Dp = 260.dp, url: String?, onclick: () -> Unit,
) {
    Box(
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
//        Box(
//            Modifier
//                .fillMaxWidth()
//                .height(height)
//                .background(Color.Black.copy(alpha = 0.8f))
//        )
        Box(
            Modifier
                .fillMaxWidth()
                .height(height / 6)
                .align(Alignment.BottomStart)
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Red.copy(),
                        ),
                        startY = height.value * 1f,
                        endY = height.value * 1f,
                    )
                )
        )
    }
}

@Composable
fun MovieHeaderWithImage(posterImgUrl: String, coverImgUrl: String, title: String) {
    Box(Modifier.fillMaxWidth()) {
        Column(horizontalAlignment = Alignment.End) {
            CoverImage(url = coverImgUrl) {
            }
            Text(
                text = title, modifier = Modifier
                    .background(TheAppTheme.colors.primary)
                    .padding(start = 130.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TheAppTheme.colors.primaryText
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(horizontal = 20.dp)
        ) {
            CorneredImageView(url = posterImgUrl) {
            }
            Spacer2dp()

        }
    }
}