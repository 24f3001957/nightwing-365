package com.nightwing.engine
object ProgressionPolicy {
 fun shouldProgress(e:ExerciseDefinition,h:List<ExercisePerformance>):Boolean { val r=h.filter { it.exerciseId==e.id }.sortedByDescending { it.timestamp }.take(2); if(r.size<2)return false; return r.all { it.pain==0 && it.formQuality>=4 && it.perceivedExertion<=7.0 && it.setsCompleted>=e.defaultSets && it.repsPerSet.size>=e.defaultSets && it.repsPerSet.take(e.defaultSets).all { n -> n>=e.maxReps } } }
 fun shouldRegress(h:List<ExercisePerformance>):Boolean { val p=h.maxByOrNull { it.timestamp } ?: return false; return p.pain>0 || p.formQuality<=2 }
}
