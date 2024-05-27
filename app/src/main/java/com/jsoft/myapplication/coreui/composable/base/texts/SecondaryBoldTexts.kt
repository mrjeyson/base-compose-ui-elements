package com.jsoft.myapplication.coreui.composable.base.texts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jsoft.myapplication.coreui.theme.TheAppTheme

@Composable
fun Text12spBoldSecondary(text: String, color: Color = TheAppTheme.colors.secondaryText) {
    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = color
    )
}

@Composable
fun Text14spBoldSecondary(text: String, color: Color = TheAppTheme.colors.secondaryText) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = color
    )
}

@Composable
fun Text16spBoldSecondary(text: String, color: Color = TheAppTheme.colors.secondaryText) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = color
    )
}


@Composable
fun Text24spBoldSecondary(text: String, color: Color = TheAppTheme.colors.secondaryText) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = color
    )
}
