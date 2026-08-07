package com.example.fittrack.presentation.screens.home

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fittrack.core.theme.CardBorder
import com.example.fittrack.core.theme.DarkBackground
import com.example.fittrack.core.theme.DarkSurface
import com.example.fittrack.core.theme.Dimens
import com.example.fittrack.core.theme.PrimaryNeonGreen
import com.example.fittrack.core.theme.RingCalories
import com.example.fittrack.core.theme.RingDistance
import com.example.fittrack.core.theme.RingSteps
import com.example.fittrack.core.theme.SecondaryOrange
import com.example.fittrack.core.theme.TextPrimary
import com.example.fittrack.core.theme.TextSecondary
import com.example.fittrack.domain.model.User
import com.example.fittrack.presentation.components.ActivityRing
import com.example.fittrack.presentation.components.FitTrackIcon
import com.example.fittrack.presentation.components.StatCard
import com.example.fittrack.presentation.viewmodel.HomeViewModel
import fittrack.shared.generated.resources.Res
import fittrack.shared.generated.resources.ic_map
import fittrack.shared.generated.resources.ic_run

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel { HomeViewModel() }) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.isLoading) {
        Box(Modifier.fillMaxSize().background(DarkBackground), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = PrimaryNeonGreen)
        }
        return
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(Dimens.ScreenPadding),
        verticalArrangement = Arrangement.spacedBy(Dimens.MD)
    ) {
        item {
            Text(
                text = "Hello, ${uiState.userName}",
                color = TextPrimary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Your weekly summary", color = TextSecondary, fontSize = 14.sp)
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ActivityRing(
                    progress = (uiState.weeklyStats.totalDistanceKm / 50f).coerceAtMost(1f),
                    ringColor = RingDistance,
                    label = "Distance",
                    value = "${uiState.weeklyStats.totalDistanceKm} km"
                )
                ActivityRing(
                    progress = (uiState.weeklyStats.totalCalories / 2500f).coerceAtMost(1f),
                    ringColor = RingCalories,
                    label = "Calories",
                    value = "${uiState.weeklyStats.totalCalories}"
                )
                ActivityRing(
                    progress = (uiState.weeklyStats.workoutsCompleted / 7f).coerceAtMost(1f),
                    ringColor = RingSteps,
                    label = "Workouts",
                    value = "${uiState.weeklyStats.workoutsCompleted}"
                )
            }
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(DarkSurface)
                    .border(1.dp, CardBorder, RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    FitTrackIcon(
                        drawable = Res.drawable.ic_map,
                        contentDescription = "Map",
                        modifier = Modifier.size(48.dp),
                        tint = TextSecondary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Route Map", color = TextSecondary, fontSize = 14.sp)
                    Text("GPS tracking — Week 2", color = PrimaryNeonGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                StatCard(
                    modifier = Modifier.weight(1f),
                    title = "Avg Pace",
                    value = uiState.weeklyStats.averagePace,
                    unit = "/km"
                )
                StatCard(
                    modifier = Modifier.weight(1f),
                    title = "Duration",
                    value = "${uiState.weeklyStats.totalDurationMinutes}",
                    unit = "min this week"
                )
            }
        }

        item {
            Text("Leaderboard", color = TextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        items(uiState.leaderboard) { user ->
            LeaderboardRow(user = user, isMe = user.name.contains("You"))
        }
    }
}

@Composable
private fun LeaderboardRow(user: User, isMe: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(if (isMe) PrimaryNeonGreen.copy(alpha = 0.15f) else DarkSurface)
            .border(1.dp, if (isMe) PrimaryNeonGreen else CardBorder, RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(if (isMe) PrimaryNeonGreen else CardBorder),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = user.weeklyRank.toString(),
                color = if (isMe) DarkBackground else TextPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = user.name,
            color = TextPrimary,
            fontSize = 16.sp,
            fontWeight = if (isMe) FontWeight.Bold else FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "${user.totalDistanceKm} km",
            color = if (isMe) PrimaryNeonGreen else SecondaryOrange,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
