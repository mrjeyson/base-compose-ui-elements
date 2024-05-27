package com.jsoft.myapplication.coreui.composable.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jsoft.myapplication.coreui.theme.TheAppTheme

@Composable
fun DividerMin() {
    Spacer10dp()
    Divider(
        Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(TheAppTheme.colors.primaryDividerBackground),
        color = TheAppTheme.colors.primaryDividerBackground
    )
    Spacer10dp()
}