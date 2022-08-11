package com.puzzle.industries.simplenotetakingapp.presentation.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun OutlinedTextInput (
    modifier: Modifier,
    labelStringId: Int,
    value: String = "",
    singleLine: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit = {}
){
    OutlinedTextField(
        value = value,
        modifier = modifier,
        label = {
            Text(text = stringResource(id = labelStringId))
        },
        onValueChange = onValueChange,
        singleLine = singleLine,
        keyboardOptions = keyboardOptions
    )

}