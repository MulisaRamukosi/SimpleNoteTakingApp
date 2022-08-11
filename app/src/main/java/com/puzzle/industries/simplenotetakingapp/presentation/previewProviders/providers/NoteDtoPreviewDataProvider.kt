package com.puzzle.industries.simplenotetakingapp.presentation.previewProviders.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.puzzle.industries.simplenotetakingapp.persistence.database.dto.NoteDto
import java.util.*

class NoteDtoPreviewDataProvider : PreviewParameterProvider<NoteDto> {
    override val values: Sequence<NoteDto> = sequenceOf(
        NoteDto(
            title = "Something cool",
            description = "something once more",
            lastModifyDate = Date()
        ),

        NoteDto(
            title = "Some once again, but this time around it's a very long title for testing purposes",
            description = "This text is mainly to test the wrapping function of the sentence that is" +
                    "very long and goes over multiple lines",
            lastModifyDate = Date()
        ),

        NoteDto(
            title = "",
            description = "This text is mainly to test the wrapping function of the sentence that is " +
                    "very long and goes over multiple lines, this one tests maxLines of 3, also this " +
                    "dto does not have a title.",
            lastModifyDate = Date()
        )
    )
}