# Adaptive Engine Design v0.1

## Goal
Produce transparent, approval-first training recommendations from the athlete history.

## Inputs
Exercise sets/reps, variation, RPE, form, pain; football and tennis duration/intensity/session RPE; sleep, soreness, fatigue; available equipment and constraints.

## Priority
1. Pain safety gate
2. Severe recovery gate
3. Recent sports workload gate
4. Bodyweight session selection
5. Progression eligibility

## Workload
Sports session load = duration minutes × session RPE. This is an arbitrary trend unit, not calories or injury probability. Strength set counts remain separate.

## Progression
Two recent exposures must reach the upper rep target with all working sets completed, form >= 4/5, RPE <= 7/10 and no pain. New variations are proposed, never silently applied.

## Limitations
Thresholds are provisional, not clinically validated. The engine is not medical advice. Bodyweight-only pulling options are limited; prone upper-back drills are not equivalent to rows or pull-ups.
