package com.example.fittrack.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fittrack.core.theme.DarkSurface
import com.example.fittrack.core.theme.PrimaryNeonGreen
import com.example.fittrack.core.theme.TextSecondary
import fittrack.shared.generated.resources.Res
import fittrack.shared.generated.resources.ic_activity
import fittrack.shared.generated.resources.ic_history
import fittrack.shared.generated.resources.ic_home
import fittrack.shared.generated.resources.ic_profile
import org.jetbrains.compose.resources.DrawableResource

enum class BottomNavTab(val label: String, val icon: DrawableResource) {
    Home("Home", Res.drawable.ic_home),
    Activity("Track", Res.drawable.ic_activity),
    History("History", Res.drawable.ic_history),
    Profile("Profile", Res.drawable.ic_profile)
}

@Composable
fun BottomNavBar(
    selectedTab: BottomNavTab,
    onTabSelected: (BottomNavTab) -> Unit
) {
    NavigationBar(containerColor = DarkSurface, tonalElevation = 8.dp) {
        BottomNavTab.entries.forEach { tab ->
            NavigationBarItem(
                selected = selectedTab == tab,
                onClick = { onTabSelected(tab) },
                label = { Text(tab.label) },
                icon = {
                    FitTrackIcon(
                        drawable = tab.icon,
                        contentDescription = tab.label,
                        modifier = Modifier.size(24.dp),
                        tint = if (selectedTab == tab) PrimaryNeonGreen else TextSecondary
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = PrimaryNeonGreen,
                    selectedTextColor = PrimaryNeonGreen,
                    unselectedIconColor = TextSecondary,
                    unselectedTextColor = TextSecondary,
                    indicatorColor = DarkSurface
                )
            )
        }
    }
}
