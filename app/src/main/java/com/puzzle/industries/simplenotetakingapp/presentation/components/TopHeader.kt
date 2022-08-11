package com.puzzle.industries.simplenotetakingapp.presentation.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.puzzle.industries.simplenotetakingapp.R
import com.puzzle.industries.simplenotetakingapp.presentation.previewProviders.models.TopHeaderModel
import com.puzzle.industries.simplenotetakingapp.presentation.previewProviders.providers.TopHeaderPreviewDataProvider
import com.puzzle.industries.simplenotetakingapp.presentation.theme.SimpleNoteTakingAppTheme
import com.puzzle.industries.simplenotetakingapp.presentation.theme.spacing.spacing

data class ActionButton(
    val imageVector: ImageVector,
    val description: String,
    val onActionClick: () -> Unit = {}
)

@Composable
fun topHeader(
    title: String = stringResource(id = R.string.app_name),
    subTitle: String = "",
    isHomeEnabled : Boolean = false,
    actions: List<ActionButton> = emptyList(),
    onHomeClick: () -> Unit = {}
) : @Composable () -> Unit{
    return {
        TopAppBar(
            elevation = 0.dp,
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        ) {
            Row(
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small),
                verticalAlignment = Alignment.CenterVertically,
            ){
                if(isHomeEnabled){
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = "Arrow back",
                        modifier = Modifier.clickable {
                            onHomeClick()
                        }
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(weight = 1f)
                        .padding(
                            horizontal = MaterialTheme.spacing.medium,
                            vertical = MaterialTheme.spacing.small
                        )
                ){
                    if (title.isNotBlank()){
                        Text(
                            text = title,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    if(subTitle.isNotEmpty()){
                        Text(
                            text = subTitle,
                            style = MaterialTheme.typography.caption
                        )
                    }
                }

                actions.forEach {
                    Icon(
                        imageVector = it.imageVector,
                        contentDescription = it.description,
                        modifier = Modifier
                            .padding(horizontal = MaterialTheme.spacing.small)
                            .clickable {
                                it.onActionClick()
                            }
                    )
                }
            }
        }
    }
}

@Preview
@Preview(
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun PreviewHeader(
    @PreviewParameter(TopHeaderPreviewDataProvider::class) topHeaderData : TopHeaderModel
){
    SimpleNoteTakingAppTheme {
        topHeader(
            title = topHeaderData.Title,
            subTitle = topHeaderData.SubTitle,
            isHomeEnabled = topHeaderData.IsHomeEnabled,
            actions = topHeaderData.actions
        ).invoke()
    }

}