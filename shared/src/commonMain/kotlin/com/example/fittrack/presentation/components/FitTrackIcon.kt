package com.example.fittrack.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

/**
 * Cross-platform icon helper.
 *
 * Icons live as XML vectors in:
 *   shared/src/commonMain/composeResources/drawable/
 *
 * Compose Multiplatform reads these on Android, iOS, Desktop, and Web.
 * Use this instead of Material Icons when you need guaranteed multiplatform support.
 */
@Composable
fun FitTrackIcon(
    drawable: DrawableResource,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    Icon(
        painter = painterResource(drawable),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}
