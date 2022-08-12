package com.puzzle.industries.simplenotetakingapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.navigation.NavController
import com.puzzle.industries.domain.models.NoteDto
import com.puzzle.industries.simplenotetakingapp.R
import com.puzzle.industries.simplenotetakingapp.viewModels.NoteViewModel
import com.puzzle.industries.simplenotetakingapp.components.ActionButton
import com.puzzle.industries.simplenotetakingapp.components.BackPressHandler
import com.puzzle.industries.simplenotetakingapp.components.OutlinedTextInput
import com.puzzle.industries.simplenotetakingapp.components.topHeader
import com.puzzle.industries.simplenotetakingapp.previewProviders.providers.NoteScreenDataProvider
import com.puzzle.industries.simplenotetakingapp.theme.SimpleNoteTakingAppTheme
import com.puzzle.industries.simplenotetakingapp.theme.spacing.spacing
import java.util.*


@Composable
fun NoteScreen(
    navController: NavController,
    noteViewModel: NoteViewModel,
    noteId: String? = ""
) {

    val note: NoteDto? =
        if (noteId.isNullOrBlank()) null else noteViewModel.getNoteById(UUID.fromString(noteId))
    var title by remember { mutableStateOf(note?.title ?: "") }
    var description by remember { mutableStateOf(note?.description ?: "") }

    val attemptToSaveNoteAndExit: () -> Unit = {
        val newNote = NoteDto(title = title, description = description)

        if (note == null) noteViewModel.addNote(newNote)
        else noteViewModel.updateNote(newNote = newNote, oldNote = note)

        navController.popBackStack()
    }

    BackPressHandler {
        attemptToSaveNoteAndExit()
    }

    Content(
        note = note,
        title = title,
        description = description,
        onNoteDelete = {
            noteViewModel.deleteNote(it)
            navController.popBackStack()
        },
        onHomeClick = { attemptToSaveNoteAndExit() },
        onTitleChange = { title = it },
        onDescriptionChange = { description = it }
    )
}

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
private fun Content(
    note: NoteDto? = null,
    title: String = "",
    description: String = "",
    onNoteDelete: (NoteDto) -> Unit = {},
    onHomeClick: () -> Unit = {},
    onTitleChange: (String) -> Unit = {},
    onDescriptionChange: (String) -> Unit = {}
) {

    Scaffold(
        topBar = topHeader(
            isHomeEnabled = true,
            actions = if (note == null) emptyList()
            else listOf(
                ActionButton(
                    imageVector = Icons.Rounded.Delete,
                    description = stringResource(id = R.string.delete_note),
                    onActionClick = { onNoteDelete(note) }
                )
            ),
            onHomeClick = onHomeClick
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = MaterialTheme.spacing.medium)
        ) {

            OutlinedTextInput(
                modifier = Modifier.fillMaxWidth(),
                labelStringId = R.string.title,
                value = title,
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                onValueChange = onTitleChange
            )

            OutlinedTextInput(
                modifier = Modifier.fillMaxWidth(),
                labelStringId = R.string.description,
                value = description,
                onValueChange = onDescriptionChange
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview(@PreviewParameter(NoteScreenDataProvider::class) note: NoteDto?) {
    SimpleNoteTakingAppTheme {
        Content(note = note, title = note?.title ?: "", description = note?.description ?: "")
    }
}