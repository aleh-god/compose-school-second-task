package by.godevelopment.task2_quiz.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val PurpleColorPalette = lightColors(
    primary = primaryColorPurple,
    primaryVariant = primaryDarkColorPurple,
    secondary = secondaryColorPurple

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val OrangeColorPalette = lightColors(
    primary = primaryColorOrange,
    primaryVariant = primaryDarkColorOrange,
    secondary = secondaryColorOrange,
    onPrimary = Color.Black
)

private val YellowColorPalette = lightColors(
    primary = primaryColorYellow,
    primaryVariant = primaryDarkColorYellow,
    secondary = secondaryColorYellow,
    onPrimary = Color.Black
)

private val GreenColorPalette = lightColors(
    primary = primaryColorGreen,
    primaryVariant = primaryDarkColorGreen,
    secondary = secondaryColorGreen
)

private val BlueColorPalette = lightColors(
    primary = primaryColorBlue,
    primaryVariant = primaryDarkColorBlue,
    secondary = secondaryColorBlue
)

@Composable
fun Task2QuizTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
    themeNumber: Int = 0
) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight

    val colors = if (darkTheme) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )
        DarkColorPalette
    } else {
        when(themeNumber) {
            0 -> PurpleColorPalette
            1 -> OrangeColorPalette
            2 -> YellowColorPalette
            3 -> GreenColorPalette
            4 -> BlueColorPalette
            else -> DarkColorPalette
        }.also {
            systemUiController.setSystemBarsColor(
                color = it.primaryVariant,
                darkIcons = useDarkIcons
            )
        }
    }

    val shapes = when(themeNumber) {
        0,2,4 -> Shapes
        1,3 -> ShapesCut
        else -> ShapesCut
    }

    val typography = when(themeNumber) {
        0,2,4 -> Typography
        1,3 -> TypographyAbril
        else -> Typography
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}