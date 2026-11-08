package com.nightwing.engine

enum class MovementPattern { PUSH, PULL, SQUAT, HINGE, CORE, LOCOMOTION, MOBILITY }
enum class SessionKind { STRENGTH, FOOTBALL, TENNIS, OTHER }
enum class DecisionType { TRAIN, PROGRESS, MAINTAIN, REDUCE, RECOVER, REST, REVIEW_PAIN }
enum class ApprovalStatus { PROPOSED, APPROVED, REJECTED }
data class ExerciseDefinition(val id:String,val name:String,val pattern:MovementPattern,val level:Int,val equipment:Set<String> = emptySet(),val primaryMuscles:Set<String>,val regressionId:String?=null,val progressionId:String?=null,val defaultSets:Int=3,val minReps:Int=6,val maxReps:Int=12,val restSeconds:Int=90)
data class ExercisePerformance(val exerciseId:String,val timestamp:Long,val setsCompleted:Int,val repsPerSet:List<Int>,val perceivedExertion:Double,val formQuality:Int,val pain:Int=0)
data class ActivitySession(val kind:SessionKind,val timestamp:Long,val durationMinutes:Int,val intensity:Int,val perceivedExertion:Int)
data class RecoveryCheckIn(val timestamp:Long,val sleepHours:Double,val soreness:Int,val fatigue:Int,val pain:Int=0)
data class AthleteConstraints(val availableEquipment:Set<String> = emptySet(),val unavailablePatterns:Set<MovementPattern> = emptySet(),val userApprovedPlanRequired:Boolean=true)
data class EngineInput(val now:Long,val performances:List<ExercisePerformance>,val activities:List<ActivitySession>,val recovery:RecoveryCheckIn?,val constraints:AthleteConstraints=AthleteConstraints())
data class PlannedExercise(val exercise:ExerciseDefinition,val sets:Int,val repTarget:String,val restSeconds:Int,val rationale:String)
data class Evidence(val label:String,val observedValue:String,val interpretation:String)
data class TrainingRecommendation(val id:String,val decision:DecisionType,val title:String,val explanation:String,val loadMultiplier:Double,val exercises:List<PlannedExercise>,val evidence:List<Evidence>,val approvalStatus:ApprovalStatus=ApprovalStatus.PROPOSED,val generatedAt:Long)
