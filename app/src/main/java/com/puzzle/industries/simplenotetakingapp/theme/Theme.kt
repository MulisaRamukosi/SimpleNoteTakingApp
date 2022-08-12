package com.puzzle.industries.simplenotetakingapp.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.puzzle.industries.simplenotetakingapp.theme.colorPalette.ColorPaletteType
import com.puzzle.industries.simplenotetakingapp.theme.factory.FontFactory
import com.puzzle.industries.simplenotetakingapp.theme.factory.ColorsFactory
import com.puzzle.industries.simplenotetakingapp.theme.font.FontType


@Composable
fun SimpleNoteTakingAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorPaletteType: ColorPaletteType =
        if (darkTheme) {
            ColorPaletteType.Dark
        }
        else {
            ColorPaletteType.Light
        }

    val colors = ColorsFactory.getTheme(colorPaletteType)
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = colors.primaryVariant
    )

    MaterialTheme(
        colors = colors,
        typography = FontFactory.getFont(FontType.JosefinSan),
        shapes = Shapes,
        content = content
    )
}