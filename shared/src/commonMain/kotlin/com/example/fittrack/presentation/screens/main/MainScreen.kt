package com.example.fittrack.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fittrack.core.theme.DarkBackground
import com.example.fittrack.core.theme.PrimaryNeonGreen
import com.example.fittrack.presentation.components.BottomNavBar
import com.example.fittrack.presentation.components.BottomNavTab
import com.example.fittrack.presentation.screens.activity.ActivityScreen
import com.example.fittrack.presentation.screens.history.HistoryScreen
import com.example.fittrack.presentation.screens.home.HomeScreen
import com.example.fittrack.presentation.screens.profile.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var selectedTab by rememberSaveable { mutableStateOf(BottomNavTab.Home) }

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
            BottomNavBar(selectedTab = selectedTab, onTabSelected = { selectedTab = it })
        },
        containerColor = DarkBackground
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (selectedTab) {
                BottomNavTab.Home -> HomeScreen()
                BottomNavTab.Activity -> ActivityScreen()
                BottomNavTab.History -> HistoryScreen()
                BottomNavTab.Profile -> ProfileScreen()
            }
        }
    }
}
