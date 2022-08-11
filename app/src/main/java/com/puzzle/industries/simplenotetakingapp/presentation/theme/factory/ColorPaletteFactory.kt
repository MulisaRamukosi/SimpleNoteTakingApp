package com.puzzle.industries.simplenotetakingapp.presentation.theme.factory

import com.puzzle.industries.simplenotetakingapp.presentation.theme.colorPalette.BaseColorPalette
import com.puzzle.industries.simplenotetakingapp.presentation.theme.colorPalette.ColorPaletteType
import com.puzzle.industries.simplenotetakingapp.presentation.theme.colorPalette.DarkColorPalette
import com.puzzle.industries.simplenotetakingapp.presentation.theme.colorPalette.LightColorPalette


object ColorPaletteFactory {

    fun getColorPalette(colorPaletteType: ColorPaletteType): BaseColorPalette {
        return when(colorPaletteType){
            ColorPaletteType.Dark -> DarkColorPalette()
            ColorPaletteType.Light -> LightColorPalette()
        }
    }
}