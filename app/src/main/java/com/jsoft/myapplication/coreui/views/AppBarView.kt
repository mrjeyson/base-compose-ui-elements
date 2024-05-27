package com.jsoft.myapplication.coreui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jsoft.myapplication.R
import com.jsoft.myapplication.coreui.composable.base.texts.Text16spBold
import com.jsoft.myapplication.coreui.theme.TheAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarView(title: String) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text16spBold(text = title)
                Spacer(modifier = Modifier.weight(1f))

            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = TheAppTheme.colors.primary

        )
    )
}

const val BOTTOM_BAR_HEIGHT = 56


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarViewWithIcons(title: String = "", startIconClick: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = TheAppTheme.colors.primary
        ),
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
//                        .align(Alignment.Center)
                ) {
                    Text16spBold(text = title)
                }
            }

        },
        navigationIcon = {
            Box(Modifier.fillMaxSize()) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                    tint = TheAppTheme.colors.primaryText,
                    modifier = Modifier
                        .width(BOTTOM_BAR_HEIGHT.dp)
                        .fillMaxHeight()
                        .clickable {
                            startIconClick.invoke()
                        }
                        .padding(15.dp)
                )
            }
        }
    )
}






