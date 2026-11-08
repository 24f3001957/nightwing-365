package com.nightwing.engine

object BodyweightLibrary {
 val all=listOf(
 ExerciseDefinition("incline_push_up","Incline push-up",MovementPattern.PUSH,1,primaryMuscles=setOf("chest","triceps"),progressionId="push_up",minReps=8,maxReps=15),
 ExerciseDefinition("push_up","Push-up",MovementPattern.PUSH,2,primaryMuscles=setOf("chest","triceps"),regressionId="incline_push_up",progressionId="decline_push_up",minReps=6,maxReps=15),
 ExerciseDefinition("decline_push_up","Decline push-up",MovementPattern.PUSH,3,primaryMuscles=setOf("chest","triceps"),regressionId="push_up",minReps=5,maxReps=12),
 ExerciseDefinition("bodyweight_squat","Bodyweight squat",MovementPattern.SQUAT,1,primaryMuscles=setOf("quads","glutes"),progressionId="split_squat",minReps=10,maxReps=20),
 ExerciseDefinition("split_squat","Split squat",MovementPattern.SQUAT,2,primaryMuscles=setOf("quads","glutes"),regressionId="bodyweight_squat",progressionId="reverse_lunge"),
 ExerciseDefinition("glute_bridge","Glute bridge",MovementPattern.HINGE,1,primaryMuscles=setOf("glutes","hamstrings"),progressionId="single_leg_glute_bridge",minReps=10,maxReps=20),
 ExerciseDefinition("single_leg_glute_bridge","Single-leg glute bridge",MovementPattern.HINGE,2,primaryMuscles=setOf("glutes","hamstrings"),regressionId="glute_bridge"),
 ExerciseDefinition("dead_bug","Dead bug",MovementPattern.CORE,1,primaryMuscles=setOf("core"),progressionId="hollow_hold"),
 ExerciseDefinition("hollow_hold","Hollow-body hold",MovementPattern.CORE,2,primaryMuscles=setOf("core"),regressionId="dead_bug",minReps=15,maxReps=35),
 ExerciseDefinition("prone_y_t_w","Prone Y-T-W",MovementPattern.PULL,1,primaryMuscles=setOf("upper_back","rear_delts"),minReps=6,maxReps=10),
 ExerciseDefinition("reverse_snow_angels","Prone reverse snow angels",MovementPattern.PULL,1,primaryMuscles=setOf("upper_back","rear_delts"),minReps=8,maxReps=15),
 ExerciseDefinition("calf_raise","Calf raise",MovementPattern.LOCOMOTION,1,primaryMuscles=setOf("calves"),progressionId="single_leg_calf_raise",minReps=12,maxReps=20),
 ExerciseDefinition("single_leg_calf_raise","Single-leg calf raise",MovementPattern.LOCOMOTION,2,primaryMuscles=setOf("calves"),regressionId="calf_raise"),
 ExerciseDefinition("hip_mobility_flow","Hip mobility flow",MovementPattern.MOBILITY,1,primaryMuscles=setOf("hips"),minReps=5,maxReps=8))
}
