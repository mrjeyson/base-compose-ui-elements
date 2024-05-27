package com.jsoft.myapplication.coreui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jsoft.myapplication.coreui.theme.TheAppTheme

@Composable
fun AppLoaderCenter() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            color = TheAppTheme.colors.primaryButtonBackground,
            modifier = Modifier
                .size(36.dp)
        )
    }
}


@Composable
fun AppLoader() {
    Box(
        Modifier
            .padding(20.dp)
            .fillMaxWidth(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            color = TheAppTheme.colors.primaryButtonBackground,
            modifier = Modifier
                .size(36.dp)
        )
    }
}