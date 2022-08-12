package com.puzzle.industries.simplenotetakingapp.previewProviders.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.puzzle.industries.domain.models.NoteDto

class NoteScreenDataProvider : PreviewParameterProvider<NoteDto?> {
    override val values: Sequence<NoteDto?>
        get() = sequenceOf(
            null,
            NoteDto(title = "some title", description = "some description")
        )
}