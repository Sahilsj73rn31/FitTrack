package com.example.fittrack

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.fittrack.core.theme.FitTrackTheme
import com.example.fittrack.presentation.navigation.AppNavigation

@Composable
@Preview
fun App() {
    FitTrackTheme {
        AppNavigation()
    }
}
