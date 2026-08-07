package com.example.fittrack.presentation.screens.dashboardscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fittrack.core.theme.*
import com.example.fittrack.presentation.components.StatCard

data class LeaderboardUser(val rank: Int, val name: String, val distance: String, val isMe: Boolean = false)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    val leaderboardData = listOf(
        LeaderboardUser(1, "Alex Rivera", "42.3 km"),
        LeaderboardUser(2, "Sarah Chen", "38.5 km"),
        LeaderboardUser(3, "You (FitTracker)", "31.2 km", isMe = true),
        LeaderboardUser(4, "Mike Johnson", "29.0 km"),
        LeaderboardUser(5, "Emma Watson", "25.7 km")
    )

    FitTrackTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "FITTRACK",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 1.5.sp,
                            color = PrimaryNeonGreen
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkBackground)
                )
            },
            bottomBar = {
                NavigationBar(containerColor = DarkSurface, tonalElevation = 8.dp) {
                    NavigationBarItem(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        label = { Text("Tracker") },
                        icon = { Icon(Icons.Default.DirectionsRun, contentDescription = "Track") },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = PrimaryNeonGreen,
                            selectedTextColor = PrimaryNeonGreen,
                            unselectedIconColor = TextSecondary,
                            unselectedTextColor = TextSecondary,
                            indicatorColor = DarkBackground
                        )
                    )
                    NavigationBarItem(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        label = { Text("Leaderboard") },
                        icon = { Icon(Icons.Default.Leaderboard, contentDescription = "Leaderboard") },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = PrimaryNeonGreen,
                            selectedTextColor = PrimaryNeonGreen,
                            unselectedIconColor = TextSecondary,
                            unselectedTextColor = TextSecondary,
                            indicatorColor = DarkBackground
                        )
                    )
                }
            },
            containerColor = DarkBackground
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                if (selectedTab == 0) {
                    TrackerTabContent(leaderboardData.first { it.isMe }.distance)
                } else {
                    LeaderboardTabContent(leaderboardData)
                }
            }
        }
    }
}

@Composable
fun TrackerTabContent(userDistance: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(DarkSurface)
                .border(1.dp, CardBorder, RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.Map, contentDescription = "Map", modifier = Modifier.size(48.dp), tint = TextSecondary)
                Spacer(modifier = Modifier.height(8.dp))
                Text("GPS Map View Active", color = TextSecondary, fontSize = 14.sp)
                Text("Python API sync ready", color = PrimaryNeonGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatCard(modifier = Modifier.weight(1f), title = "Total Distance", value = userDistance, unit = "This Week")
            StatCard(modifier = Modifier.weight(1f), title = "Avg Pace", value = "5'24\"", unit = "/km")
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { /* Action Trigger */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryNeonGreen)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(Icons.Default.PlayArrow, contentDescription = "Start", tint = DarkBackground)
                Spacer(modifier = Modifier.width(8.dp))
                Text("START TRACKING WORKOUT", color = DarkBackground, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun LeaderboardTabContent(users: List<LeaderboardUser>) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Global Weekly Rankings",
            color = TextPrimary,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(users) { _, user ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (user.isMe) PrimaryNeonGreen.copy(alpha = 0.15f) else DarkSurface)
                        .border(1.dp, if (user.isMe) PrimaryNeonGreen else CardBorder, RoundedCornerShape(12.dp))
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(if (user.isMe) PrimaryNeonGreen else CardBorder),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = user.rank.toString(),
                            color = if (user.isMe) DarkBackground else TextPrimary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = user.name,
                        color = TextPrimary,
                        fontSize = 16.sp,
                        fontWeight = if (user.isMe) FontWeight.Bold else FontWeight.Medium,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = user.distance,
                        color = if (user.isMe) PrimaryNeonGreen else SecondaryOrange,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
