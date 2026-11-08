package com.nightwing.protocol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nightwing.engine.*

private val Night = Color(0xFF070D18)
private val Panel = Color(0xFF111D30)
private val Blue = Color(0xFF36A7FF)
private val Muted = Color(0xFF9BAEC7)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val now = System.currentTimeMillis()
        val recommendation = AdaptiveTrainingEngine().recommend(
            EngineInput(now, emptyList(), emptyList(), RecoveryCheckIn(now, 7.5, 2, 2))
        )
        setContent { NightwingDashboard(recommendation) }
    }
}

@Composable
private fun NightwingDashboard(recommendation: TrainingRecommendation) {
    MaterialTheme(colorScheme = darkColorScheme(primary = Blue, background = Night, surface = Panel)) {
        Surface(Modifier.fillMaxSize(), color = Night) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Column {
                            Text("NIGHTWING", color = Blue, fontSize = 13.sp, fontWeight = FontWeight.Bold, letterSpacing = 3.sp)
                            Text("THE 365 PROTOCOL", color = Muted, fontSize = 10.sp, letterSpacing = 2.sp)
                        }
                        Text("● SYSTEM ONLINE", color = Color(0xFF67D7A0), fontSize = 10.sp)
                    }
                }
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("Build the capability.", color = Color.White, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                        Text("A training system that adapts to your real life.", color = Muted, style = MaterialTheme.typography.bodyMedium)
                    }
                }
                item { CharacterProgressCard() }
                item {
                    Text("ATHLETIC ATTRIBUTES", color = Blue, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
                }
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        AttributeBar("STRENGTH", 0.08f, "Baseline pending")
                        AttributeBar("AGILITY", 0.08f, "Baseline pending")
                        AttributeBar("ENDURANCE", 0.08f, "Baseline pending")
                        AttributeBar("MOBILITY", 0.08f, "Baseline pending")
                        AttributeBar("CORE STABILITY", 0.08f, "Baseline pending")
                    }
                }
                item {
                    Column(
                        Modifier.fillMaxWidth().background(Panel, RoundedCornerShape(18.dp)).padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(9.dp)
                    ) {
                        Text("TODAY'S ENGINE DECISION", color = Blue, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.5.sp)
                        Text(recommendation.title, color = Color.White, style = MaterialTheme.typography.titleLarge)
                        Text(recommendation.explanation, color = Muted, style = MaterialTheme.typography.bodyMedium)
                        Text("DECISION  /  ${recommendation.decision}", color = Blue, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        recommendation.exercises.forEach {
                            Text("${it.exercise.name}  ·  ${it.sets} sets  ·  ${it.repTarget} reps", color = Color.White, fontSize = 13.sp)
                        }
                    }
                }
                item {
                    Text("TRAINING  ·  SPORTS  ·  RECOVERY  ·  HISTORY", color = Muted, fontSize = 10.sp, letterSpacing = 1.sp)
                }
            }
        }
    }
}

@Composable
private fun CharacterProgressCard() {
    Column(
        Modifier.fillMaxWidth().background(Panel, RoundedCornerShape(22.dp)).padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("YOUR ATHLETIC EVOLUTION", color = Muted, fontSize = 10.sp, letterSpacing = 2.sp)
        // Static character artwork will occupy this dedicated hero viewport.
        Box(
            Modifier.fillMaxWidth().height(230.dp).background(
                brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                    listOf(Color(0xFF172D49), Color(0xFF0B1423), Panel)
                ),
                shape = RoundedCornerShape(16.dp)
            ),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("N", color = Blue, fontSize = 76.sp, fontWeight = FontWeight.Black)
                Text("NIGHTWING", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold, letterSpacing = 4.sp)
                Text("CHARACTER ARTWORK VIEWPORT", color = Muted, fontSize = 9.sp, letterSpacing = 1.sp)
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text("PROTOCOL PROGRESS", color = Muted, fontSize = 10.sp, letterSpacing = 1.sp)
                Text("Baseline not yet established", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            }
            Text("0%", color = Blue, fontSize = 25.sp, fontWeight = FontWeight.Bold)
        }
        LinearProgressIndicator(
            progress = { 0f },
            modifier = Modifier.fillMaxWidth().height(7.dp),
            color = Blue,
            trackColor = Color(0xFF263B55)
        )
        Text("Progress will be earned through completed, logged training — not elapsed days.", color = Muted, fontSize = 11.sp)
    }
}

@Composable
private fun AttributeBar(label: String, progress: Float, status: String) {
    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(label, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.sp)
            Text(status, color = Muted, fontSize = 10.sp)
        }
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth().height(5.dp),
            color = Blue,
            trackColor = Color(0xFF263B55)
        )
    }
}
