package com.nightwing.protocol
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nightwing.engine.*
class MainActivity:ComponentActivity(){ override fun onCreate(savedInstanceState:Bundle?){ super.onCreate(savedInstanceState); val n=System.currentTimeMillis(); val recommendation=AdaptiveTrainingEngine().recommend(EngineInput(n,emptyList(),emptyList(),RecoveryCheckIn(n,7.5,2,2))); setContent { Home(recommendation) } } }
@Composable private fun Home(r:TrainingRecommendation){ MaterialTheme(colorScheme=darkColorScheme(primary=Color(0xFF36A7FF),background=Color(0xFF070D18))){ Surface(Modifier.fillMaxSize(),color=Color(0xFF070D18)){ Column(Modifier.fillMaxSize().padding(24.dp),verticalArrangement=Arrangement.spacedBy(16.dp)){ Text("NIGHTWING // THE 365 PROTOCOL",color=Color(0xFF36A7FF),fontSize=12.sp); Text("Build the capability.",style=MaterialTheme.typography.headlineMedium,color=Color.White); Text(r.title,color=Color.White,style=MaterialTheme.typography.titleLarge); Text(r.explanation,color=Color.LightGray); Text("Decision: "+r.decision,color=Color(0xFF36A7FF)); r.exercises.forEach { Text(it.exercise.name+" — "+it.sets+" × "+it.repTarget,color=Color.White) } } } } }
