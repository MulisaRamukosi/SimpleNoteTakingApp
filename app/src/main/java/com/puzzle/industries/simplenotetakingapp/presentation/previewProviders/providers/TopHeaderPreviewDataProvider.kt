package com.puzzle.industries.simplenotetakingapp.presentation.previewProviders.providers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.puzzle.industries.simplenotetakingapp.presentation.components.ActionButton
import com.puzzle.industries.simplenotetakingapp.presentation.previewProviders.models.TopHeaderModel

class TopHeaderPreviewDataProvider : PreviewParameterProvider<TopHeaderModel>{
    override val values: Sequence<TopHeaderModel> = sequenceOf(
        TopHeaderModel(
            Title = "Test",
            SubTitle = "Test",
            IsHomeEnabled = false,
            actions = listOf(
                ActionButton(
                    imageVector = Icons.Rounded.Add,
                    description = "add note"
                )
            )
        ),
        TopHeaderModel(
            Title = "Test2",
            SubTitle = "",
            IsHomeEnabled = true
        ),
        TopHeaderModel(
            Title = "Test3",
            SubTitle = "some subtitle",
            IsHomeEnabled = true,
            actions = listOf(
                ActionButton(
                    imageVector = Icons.Rounded.Add,
                    description = "add note"
                ),
                ActionButton(
                    imageVector = Icons.Rounded.Delete,
                    description = "delete note"
                )
            )
        )
    )
}