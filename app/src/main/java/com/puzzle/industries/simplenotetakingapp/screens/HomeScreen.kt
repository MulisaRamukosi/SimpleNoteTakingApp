package com.puzzle.industries.simplenotetakingapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.puzzle.industries.domain.models.NoteDto
import com.puzzle.industries.simplenotetakingapp.R
import com.puzzle.industries.simplenotetakingapp.viewModels.NoteViewModel
import com.puzzle.industries.simplenotetakingapp.components.ActionButton
import com.puzzle.industries.simplenotetakingapp.components.NoteCard
import com.puzzle.industries.simplenotetakingapp.components.topHeader
import com.puzzle.industries.simplenotetakingapp.navigation.constants.RouteParamKeys
import com.puzzle.industries.simplenotetakingapp.navigation.constants.Routes
import com.puzzle.industries.simplenotetakingapp.previewProviders.providers.NotesListPreviewDataProvider
import com.puzzle.industries.simplenotetakingapp.theme.SimpleNoteTakingAppTheme
import com.puzzle.industries.simplenotetakingapp.theme.spacing.spacing


@Composable
fun HomeScreen(navController: NavController, noteViewModel: NoteViewModel) {
    val notes = noteViewModel.noteList.collectAsState().value
    Content(
        notes = notes,
        onAddNote = { navController.navigate(route = Routes.Note.path) },
        onNoteClicked = {
            navController.navigate(
                route = Routes.Note
                    .addParam(RouteParamKeys.NoteId.name, it.id.toString()).path
            )
        }
    )

}

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
private fun Content(
    notes: List<NoteDto>,
    onAddNote: () -> Unit = {},
    onNoteClicked: (NoteDto) -> Unit = {}
) {
    Scaffold(
        topBar = topHeader(
            title = stringResource(id = R.string.app_name),
            actions = listOf(
                ActionButton(
                    imageVector = Icons.Rounded.Add,
                    description = stringResource(id = R.string.desc_add_note),
                    onActionClick = onAddNote
                )
            )
        )
    ) {

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp),
            contentPadding = PaddingValues(all = MaterialTheme.spacing.small),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
            content = {
                items(items = notes) { note ->
                    NoteCard(note = note) {
                        onNoteClicked(it)
                    }
                }

            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview(@PreviewParameter(NotesListPreviewDataProvider::class) notesList: List<NoteDto>) {
    SimpleNoteTakingAppTheme {
        Content(
            notes = notesList
        )
    }
}
