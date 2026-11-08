package com.nightwing.engine
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
class AdaptiveTrainingEngineTest {
 private val engine=AdaptiveTrainingEngine(); private val now=1800000000000L
 private fun input(r:RecoveryCheckIn?=RecoveryCheckIn(now,7.5,2,2,0),a:List<ActivitySession> = emptyList())=EngineInput(now,emptyList(),a,r)
 @Test fun painWins(){ assertEquals(DecisionType.REVIEW_PAIN,engine.recommend(input(RecoveryCheckIn(now,8.0,1,1,6))).decision) }
 @Test fun poorRecoveryRests(){ assertEquals(DecisionType.REST,engine.recommend(input(RecoveryCheckIn(now,4.0,8,8,0))).decision) }
 @Test fun footballLoadRecovers(){ assertEquals(DecisionType.RECOVER,engine.recommend(input(a=listOf(ActivitySession(SessionKind.FOOTBALL,now-2000,90,8,9)))).decision) }
 @Test fun readyAthleteGetsBodyweightProposal(){ val x=engine.recommend(input()); assertEquals(DecisionType.TRAIN,x.decision); assertTrue(x.exercises.isNotEmpty()); assertEquals(ApprovalStatus.PROPOSED,x.approvalStatus) }
}
