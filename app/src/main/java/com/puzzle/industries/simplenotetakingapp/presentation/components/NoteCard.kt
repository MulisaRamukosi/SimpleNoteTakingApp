package com.puzzle.industries.simplenotetakingapp.presentation.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.puzzle.industries.simplenotetakingapp.persistence.database.dto.NoteDto
import com.puzzle.industries.simplenotetakingapp.presentation.previewProviders.providers.NoteDtoPreviewDataProvider
import com.puzzle.industries.simplenotetakingapp.presentation.theme.SimpleNoteTakingAppTheme
import com.puzzle.industries.simplenotetakingapp.presentation.theme.spacing.spacing

@Composable
fun NoteCard(note: NoteDto, onClick : (NoteDto) -> Unit = {}){
    Card(
        modifier = Modifier.fillMaxWidth()
            .clickable {
                onClick(note)
            },

    ) {
        Column(
            modifier = Modifier.padding(all = MaterialTheme.spacing.small)
        ) {

            if(note.title.isNotBlank()){
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.h6,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Divider(modifier = Modifier
                    .padding(vertical = MaterialTheme.spacing.small)
                )
            }

            if(note.description.isNotBlank()){
                Text(
                    text = note.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Text(
                modifier = Modifier.padding(top = MaterialTheme.spacing.small),
                text = note.lastModifyDate.toString(),
                style = MaterialTheme.typography.caption,
                maxLines = 1
            )
        }
    }
}

@Preview(group = "light")
@Preview(group = "dark", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NotePreview(@PreviewParameter(NoteDtoPreviewDataProvider::class) note : NoteDto){
    SimpleNoteTakingAppTheme {
        NoteCard(note = note)
    }
}