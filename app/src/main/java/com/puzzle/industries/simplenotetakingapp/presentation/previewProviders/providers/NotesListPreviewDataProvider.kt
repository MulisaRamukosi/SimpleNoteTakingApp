package com.puzzle.industries.simplenotetakingapp.presentation.previewProviders.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.puzzle.industries.simplenotetakingapp.persistence.database.dto.NoteDto

class NotesListPreviewDataProvider : PreviewParameterProvider<List<NoteDto>> {
    override val values: Sequence<List<NoteDto>> = sequenceOf(
        listOf(
            NoteDto(title = "testing", description = "some bit off description"),
            NoteDto(title = "some long topic", description = "some desc"),
            NoteDto(title = "testing", description = "some bit off description"),
            NoteDto(title = "some long topic", description = "some desc"),
            NoteDto(title = "some long topic", description = "some desc"),
            NoteDto(title = "testing", description = "some bit off description"),
            NoteDto(title = "testing", description = "some bit off description"),
        )
    )
}