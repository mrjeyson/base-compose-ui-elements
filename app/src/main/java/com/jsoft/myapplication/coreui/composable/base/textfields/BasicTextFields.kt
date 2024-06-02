package com.jsoft.myapplication.coreui.composable.base.textfields

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jsoft.myapplication.R
import com.jsoft.myapplication.coreui.composable.base.Spacer10dp
import com.jsoft.myapplication.coreui.composable.base.texts.Text16spSecondary
import com.jsoft.myapplication.coreui.theme.TheAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    textState: MutableState<String>,
    hintText: String = stringResource(R.string._search),
    @DrawableRes iconId: Int = R.drawable.ic_search,
    defMarginTop: Boolean = false,
    defMarginBottom: Boolean = false,
    textChanged: (String) -> Unit
) {
    Column {
        if (defMarginTop) Spacer10dp()
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textState.value,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                cursorColor = Color.Black,
                disabledLabelColor = Color.Transparent,
                focusedIndicatorColor = TheAppTheme.colors.inactiveIconTint,
                unfocusedIndicatorColor = TheAppTheme.colors.inactiveIconTint
            ),
            textStyle = TextStyle(color = TheAppTheme.colors.primaryText, fontSize = 16.sp),
            onValueChange = {
                textState.value = it
                if (it.length > 1) {
                    textChanged(it)
                }
            },
            singleLine = true,
            placeholder = {
                Text16spSecondary(
                    hintText,
                    color = TheAppTheme.colors.secondaryText
                )
            },
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(painter = painterResource(id = iconId), contentDescription = null)
                }
            }
        )
        if (defMarginBottom) Spacer10dp()
    }
}

@Composable
fun SearchTextFieldRounded(
    valueChange: (String) -> Unit
) {
    val textState = remember {
        mutableStateOf("")
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                shape = RoundedCornerShape(12.dp)
                clip = true
            }
    ) {
        Row(
            Modifier
                .background(TheAppTheme.colors.secondaryButtonBackground)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
            Spacer10dp()
            BasicTextField(
                value = textState.value,
                onValueChange = { textState.value = it; valueChange(it) },
                textStyle = TextStyle(color = TheAppTheme.colors.primaryText, fontSize = 14.sp),
                singleLine = true,
            )
        }
    }
}