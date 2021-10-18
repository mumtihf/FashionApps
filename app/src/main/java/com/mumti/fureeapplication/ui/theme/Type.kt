package com.mumti.fureeapplication.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mumti.fureeapplication.R

private val Poppins = FontFamily(
    Font(R.font.poppins_light),
    Font(R.font.poppins_medium, FontWeight.W500),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h2 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W600,
        fontSize = 48.sp
    ),
    h3 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    h4 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W700,
        fontSize = 20.sp
    ),
    h6 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W500,
        fontSize = 15.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W600,
        fontSize = 15.sp
    ),
    body1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    body2 = TextStyle(
        fontFamily = Poppins,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    button = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp

    ),
)