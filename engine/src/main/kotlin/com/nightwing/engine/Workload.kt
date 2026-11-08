package com.nightwing.engine

data class WorkloadSummary(val sportLoadLast24h:Int,val sportLoadLast72h:Int,val strengthSetsLast7d:Int,val evidence:List<Evidence>)
object WorkloadModel {
 // Duration in minutes × session RPE = arbitrary trend units, not calories or injury risk.
 fun summarise(input:EngineInput):WorkloadSummary {
  val sports=input.activities.filter { it.kind==SessionKind.FOOTBALL || it.kind==SessionKind.TENNIS }
  fun load(hours:Long)=sports.filter { input.now-it.timestamp in 0..hours*3_600_000L }.sumOf { it.durationMinutes*it.perceivedExertion }
  val a=load(24); val b=load(72); val sets=input.performances.filter { input.now-it.timestamp in 0..7L*24*3_600_000 }.sumOf { it.setsCompleted }
  return WorkloadSummary(a,b,sets,listOf(Evidence("Sport load 24h","$a AU","Duration × session RPE"),Evidence("Sport load 72h","$b AU","Recent sport load"),Evidence("Strength sets 7d","$sets","Logged working sets")))
 }
}
