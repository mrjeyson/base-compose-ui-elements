package com.jsoft.myapplication.coreui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PrimaryTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: TheAppColors = ThemeColor.getColors(darkTheme),
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalShapes provides TheAppShapes(),
        LocalComposable provides TheAppComposable(),
        LocalOverscrollConfiguration provides null
    ) {
        CompositionLocalProvider(
            LocalColors provides colors,
            LocalShapes provides TheAppShapes(),
            LocalComposable provides TheAppComposable(),
            LocalOverscrollConfiguration provides null
        ) {

            MaterialTheme(
                colorScheme = MaterialTheme.colorScheme.copy(
                    primary = colors.primary,
//                    primaryVariant = colors.primaryVariant,
                    surface = colors.surface,
                    onPrimary = colors.primaryButtonText,
                    onSurface = colors.secondaryText,
                    onBackground = colors.primaryButtonBackground,
                ),
                typography = Typography,
                shapes = Shapes,
                content = content
            )

            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = TheAppTheme.colors.statusBar
            )

        }
    }
}


@Immutable
data class TheAppColors(
    val statusBar: Color,
    val primary: Color,
    val primaryVariant: Color,
    val surface: Color,
    val primaryButtonText: Color,
    val secondaryText: Color,
    val primaryButtonBackground: Color,
    val secondaryButtonText: Color,
    val additionalText: Color,
    val primaryText: Color,
    val secondaryButtonBackground: Color,
    val activeIconTint: Color,
    val inactiveIconTint: Color,
    val indicatorTint: Color,
    val primaryDividerBackground: Color,
)

val LocalColors = staticCompositionLocalOf<TheAppColors> {
    error("No LocalColors specified")
}

val LocalShapes = staticCompositionLocalOf<TheAppShapes> {
    error("No LocalShapes specified")
}

val LocalComposable = staticCompositionLocalOf<TheAppComposable> {
    error("No LocalComposable specified")
}

@Immutable
data class TheAppComposable(
    val welcomeBackground: @Composable (
    BoxScope.(
        startAnimation: Boolean,
        statusText: String?,
        onVendorFallbackInitiated: () -> Unit,
        onAnimationFinished: () -> Unit
    ) -> Unit
    )? = null
)

@Immutable
data class TheAppShapes(
    val menuButton: CornerBasedShape = RoundedCornerShape(8.dp),
    val keypadButton: CornerBasedShape = RoundedCornerShape(8.dp),
    val primaryButton: CornerBasedShape = RoundedCornerShape(8.dp),
    val secondaryButton: CornerBasedShape = RoundedCornerShape(8.dp),
    val alertDialog: CornerBasedShape = RoundedCornerShape(8.dp),
    val keypadComponent: CornerBasedShape = RoundedCornerShape(8.dp),
    val bottomSheetShape: CornerBasedShape = RoundedCornerShape(
        topStart = 18.dp,
        topEnd = 18.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp,
    ),
)

object TheAppTheme {

    val colors: TheAppColors
        @Composable
        get() = LocalColors.current

    val typography: Typography
        @Composable
        get() = MaterialTheme.typography

    val shapes: TheAppShapes
        @Composable
        get() = LocalShapes.current

    val composable: TheAppComposable
        @Composable
        get() = LocalComposable.current
}


/*private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    *//* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    *//*
)*/

/*
@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}*/





