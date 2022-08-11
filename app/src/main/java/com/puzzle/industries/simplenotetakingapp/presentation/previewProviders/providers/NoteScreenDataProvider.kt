package com.puzzle.industries.simplenotetakingapp.presentation.previewProviders.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.puzzle.industries.simplenotetakingapp.persistence.database.dto.NoteDto

class NoteScreenDataProvider : PreviewParameterProvider<NoteDto?> {
    override val values: Sequence<NoteDto?>
        get() = sequenceOf(
            null,
            NoteDto(title = "some title", description = "some description")
        )
}