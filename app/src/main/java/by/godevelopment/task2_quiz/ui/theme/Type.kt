package by.godevelopment.task2_quiz.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import by.godevelopment.task2_quiz.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    )
)

val abrilFontFamily = FontFamily(
    Font(R.font.abril_fatface)
)

val TypographyAbril = Typography(
    body1 = TextStyle(
        fontFamily = abrilFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = abrilFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = abrilFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontFamily = abrilFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    )
)

val latoFontFamily = FontFamily(
    Font(R.font.lato_black),
    Font(R.font.lato_bold, weight = FontWeight.Bold),
    Font(R.font.lato_light, weight = FontWeight.Light),
    Font(R.font.lato_thin, weight = FontWeight.Thin),
    Font(R.font.lato_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
)

val TypographyLato = Typography(
    body1 = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Italic,
        fontSize = 20.sp
    )
)
