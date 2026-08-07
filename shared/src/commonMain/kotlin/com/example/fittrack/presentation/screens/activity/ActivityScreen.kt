package com.example.fittrack.presentation.screens.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fittrack.core.theme.CardBorder
import com.example.fittrack.core.theme.DarkBackground
import com.example.fittrack.core.theme.DarkSurface
import com.example.fittrack.core.theme.Dimens
import com.example.fittrack.core.theme.PrimaryNeonGreen
import com.example.fittrack.core.theme.TextPrimary
import com.example.fittrack.core.theme.TextSecondary
import com.example.fittrack.domain.model.ExerciseType
import com.example.fittrack.presentation.components.FitTrackIcon
import fittrack.shared.generated.resources.Res
import fittrack.shared.generated.resources.ic_activity
import fittrack.shared.generated.resources.ic_map

@Composable
fun ActivityScreen() {
    var selectedType by remember { mutableStateOf(ExerciseType.RUNNING) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(Dimens.ScreenPadding),
        verticalArrangement = Arrangement.spacedBy(Dimens.MD)
    ) {
        Text("Start Workout", color = TextPrimary, fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Text("Exercise type", color = TextSecondary, fontSize = 14.sp)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ExerciseType.entries.take(4).forEach { type ->
                FilterChip(
                    selected = selectedType == type,
                    onClick = { selectedType = type },
                    label = { Text(type.label, fontSize = 12.sp) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = PrimaryNeonGreen.copy(alpha = 0.2f),
                        selectedLabelColor = PrimaryNeonGreen
                    )
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(16.dp))
                .background(DarkSurface)
                .border(1.dp, CardBorder, RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FitTrackIcon(
                    drawable = Res.drawable.ic_map,
                    contentDescription = "GPS Map",
                    modifier = Modifier.size(64.dp),
                    tint = TextSecondary
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text("Live GPS Map", color = TextPrimary, fontSize = 16.sp)
                Text("Tracks area covered on map", color = TextSecondary, fontSize = 13.sp)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatLabel("0.00", "km")
            StatLabel("00:00", "time")
            StatLabel("0", "cal")
        }

        Button(
            onClick = { /* Week 2: start GPS tracking */ },
            modifier = Modifier.fillMaxWidth().height(60.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryNeonGreen)
        ) {
            FitTrackIcon(
                drawable = Res.drawable.ic_activity,
                contentDescription = "Start",
                tint = DarkBackground,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("START ${selectedType.label.uppercase()}", color = DarkBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun StatLabel(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = TextPrimary, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text(label, color = TextSecondary, fontSize = 12.sp)
    }
}
