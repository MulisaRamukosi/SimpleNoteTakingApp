package com.puzzle.industries.simplenotetakingapp.theme.factory

import com.puzzle.industries.simplenotetakingapp.theme.colorPalette.BaseColorPalette
import com.puzzle.industries.simplenotetakingapp.theme.colorPalette.ColorPaletteType
import com.puzzle.industries.simplenotetakingapp.theme.colorPalette.DarkColorPalette
import com.puzzle.industries.simplenotetakingapp.theme.colorPalette.LightColorPalette


object ColorPaletteFactory {

    fun getColorPalette(colorPaletteType: ColorPaletteType): BaseColorPalette {
        return when(colorPaletteType){
            ColorPaletteType.Dark -> DarkColorPalette()
            ColorPaletteType.Light -> LightColorPalette()
        }
    }
}