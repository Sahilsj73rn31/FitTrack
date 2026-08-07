package com.example.fittrack.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fittrack.core.theme.CardBorder
import com.example.fittrack.core.theme.DarkSurface
import com.example.fittrack.core.theme.TextPrimary
import com.example.fittrack.core.theme.TextSecondary

@Composable
fun StatCard(modifier: Modifier = Modifier, title: String, value: String, unit: String) {
    Card(
        modifier = modifier.border(1.dp, CardBorder, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = DarkSurface),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = title, color = TextSecondary, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = value, color = TextPrimary, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = unit, color = TextSecondary, fontSize = 11.sp)
        }
    }
}
