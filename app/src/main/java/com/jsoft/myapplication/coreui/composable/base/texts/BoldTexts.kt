package com.jsoft.myapplication.coreui.composable.base.texts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.jsoft.myapplication.coreui.theme.TheAppTheme

@Composable
fun Text12spBold(text: String, color: Color = TheAppTheme.colors.primaryText) {
    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = color
    )
}

@Composable
fun Text14spBold(text: String, color: Color = TheAppTheme.colors.primaryText) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = color
    )
}

@Composable
fun Text16spBold(
    text: String,
    color: Color = TheAppTheme.colors.primaryText,
    ellipsize: Boolean = false
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = color,
    )
}


@Composable
fun Text16spBoldActive(
    text: String,
    color: Color = TheAppTheme.colors.primaryButtonBackground,
    ellipsize: Boolean = false
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = color,
    )
}

@Composable
fun Text16spBoldSingleLine(
    text: String,
    color: Color = TheAppTheme.colors.primaryText,
    ellipsis: Boolean = true
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = color,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun Text18spBold(text: String, color: Color = TheAppTheme.colors.primaryText) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = color
    )
}

@Composable
fun Text24spBold(text: String, color: Color = TheAppTheme.colors.primaryText) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = color
    )
}
