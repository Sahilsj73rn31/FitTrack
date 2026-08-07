package com.example.fittrack.presentation.screens.history

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.fittrack.core.theme.SecondaryOrange
import com.example.fittrack.core.theme.TextPrimary
import com.example.fittrack.core.theme.TextSecondary
import com.example.fittrack.domain.model.ExerciseType
import com.example.fittrack.domain.model.Workout

@Composable
fun HistoryScreen() {
    val mockHistory = listOf(
        Workout(1, 1, ExerciseType.RUNNING, 5.2, 28, 320, "5'23\"", startedAt = "Aug 6", endedAt = ""),
        Workout(2, 1, ExerciseType.CYCLING, 12.8, 45, 410, "3'31\"", startedAt = "Aug 5", endedAt = ""),
        Workout(3, 1, ExerciseType.WALKING, 3.1, 35, 180, "11'17\"", startedAt = "Aug 4", endedAt = "")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(Dimens.ScreenPadding)
    ) {
        Text("Workout History", color = TextPrimary, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Past sessions & spot reviews", color = TextSecondary, fontSize = 14.sp, modifier = Modifier.padding(bottom = Dimens.MD))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(mockHistory) { workout ->
                WorkoutHistoryCard(workout)
            }
        }
    }
}

@Composable
private fun WorkoutHistoryCard(workout: Workout) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(DarkSurface)
            .border(1.dp, CardBorder, RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(workout.exerciseType.label, color = PrimaryNeonGreen, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(workout.startedAt, color = TextSecondary, fontSize = 12.sp)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text("${workout.distanceKm} km", color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text("${workout.durationMinutes} min • ${workout.caloriesBurned} cal", color = SecondaryOrange, fontSize = 12.sp)
        }
    }
}
