package com.puzzle.industries.simplenotetakingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.puzzle.industries.simplenotetakingapp.navigation.MainNavigation
import com.puzzle.industries.simplenotetakingapp.theme.SimpleNoteTakingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleNoteTakingAppTheme {
                MainNavigation()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleNoteTakingAppTheme {
        MainNavigation()
    }
}