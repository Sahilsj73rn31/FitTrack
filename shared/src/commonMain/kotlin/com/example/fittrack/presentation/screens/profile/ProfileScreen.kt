package com.example.fittrack.presentation.screens.profile

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
import androidx.compose.foundation.shape.CircleShape
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
import com.example.fittrack.core.theme.TextPrimary
import com.example.fittrack.core.theme.TextSecondary
import com.example.fittrack.presentation.components.FitTrackIcon
import fittrack.shared.generated.resources.Res
import fittrack.shared.generated.resources.ic_profile

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(Dimens.ScreenPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.MD)
    ) {
        Spacer(modifier = Modifier.height(Dimens.LG))

        Box(
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape)
                .background(PrimaryNeonGreen.copy(alpha = 0.2f))
                .border(2.dp, PrimaryNeonGreen, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            FitTrackIcon(
                drawable = Res.drawable.ic_profile,
                contentDescription = "Profile",
                modifier = Modifier.size(48.dp),
                tint = PrimaryNeonGreen
            )
        }

        Text("FitTracker", color = TextPrimary, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Rank #3 this week", color = PrimaryNeonGreen, fontSize = 14.sp)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ProfileStatCard("31.2", "Total km", Modifier.weight(1f))
            ProfileStatCard("5", "Workouts", Modifier.weight(1f))
            ProfileStatCard("1840", "Calories", Modifier.weight(1f))
        }

        Text("Spot Reviews", color = TextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
        Text(
            "Leave reviews about specific spots on your route — coming in Week 2",
            color = TextSecondary,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun ProfileStatCard(value: String, label: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(DarkSurface)
            .border(1.dp, CardBorder, RoundedCornerShape(12.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(value, color = TextPrimary, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(label, color = TextSecondary, fontSize = 11.sp)
    }
}
