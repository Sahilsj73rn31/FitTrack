package com.example.fittrack.presentation.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

import fittrack.shared.generated.resources.Res
import fittrack.shared.generated.resources.fittrack_logo

@Composable
fun AppLogo() {

    Image(
        painter = painterResource(Res.drawable.fittrack_logo),
        contentDescription = "FitTrack Logo",
        modifier = Modifier.size(140.dp)
    )

}