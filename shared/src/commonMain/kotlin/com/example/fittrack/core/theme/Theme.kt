package com.example.fittrack.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val FitTrackColorScheme = darkColorScheme(
    primary = PrimaryNeonGreen,
    onPrimary = DarkBackground,
    primaryContainer = PrimaryNeonGreenGlow,
    secondary = SecondaryOrange,
    onSecondary = DarkBackground,
    tertiary = SecondaryCyan,
    background = DarkBackground,
    onBackground = TextPrimary,
    surface = DarkSurface,
    onSurface = TextPrimary,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = TextSecondary,
    outline = CardBorder,
    outlineVariant = DividerColor
)

@Composable
fun FitTrackTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = FitTrackColorScheme,
        typography = AppTypography,
        content = content
    )
}
