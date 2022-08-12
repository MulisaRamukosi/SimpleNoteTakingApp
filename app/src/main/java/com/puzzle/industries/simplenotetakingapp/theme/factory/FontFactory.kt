package com.puzzle.industries.simplenotetakingapp.theme.factory

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.puzzle.industries.simplenotetakingapp.theme.font.BaseFont
import com.puzzle.industries.simplenotetakingapp.theme.font.FontType
import com.puzzle.industries.simplenotetakingapp.theme.font.JosefinSanFont
import com.puzzle.industries.simplenotetakingapp.theme.font.RobotoFont

object FontFactory {

    fun getFont(fontType: FontType) : Typography{
        val baseFont: BaseFont = when(fontType){
            FontType.Roboto -> RobotoFont()
            FontType.JosefinSan -> JosefinSanFont()
        }

        val fontFamily = FontFamily(
            Font(
                resId = baseFont.regular,
                weight = FontWeight.Normal
            ),
            Font(
                resId = baseFont.medium,
                weight = FontWeight.Medium
            ),
            Font(
                resId = baseFont.light,
                weight = FontWeight.Light
            ),
            Font(
                resId = baseFont.bold,
                weight = FontWeight.Bold
            )
        )

        return Typography(defaultFontFamily = fontFamily)
    }

}