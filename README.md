# NIGHTWING: The 365 Protocol

An adaptive, bodyweight-first athletic-development platform with a native Android application and a standalone Kotlin decision engine.

## Product vision
NIGHTWING is an explainable personal training system, not a static workout calendar. It uses exercise performance, training history, perceived exertion, movement quality, pain reports, recovery signals, and football/tennis sessions to propose an appropriate next training action.

365 days is a milestone, not a deadline.

## Architecture
- Android: Kotlin, Jetpack Compose, MVVM
- Persistence: Room and DataStore
- Decision engine: standalone Kotlin/JVM module
- Decisions: deterministic, explainable, approval-first
- Evaluation: unit tests and scenario replay

## Core principles
1. Pain and recovery constraints take priority over progression.
2. Football and tennis count as training load.
3. Sports load and strength volume remain separate measures.
4. Progression requires repeated successful performance, good form, manageable effort, and no reported pain.
5. Recommendations remain proposals until the athlete approves them.
6. No missed-day punishment, streak resets, or training through pain.

## Repository layout
- `app/` — native Android application
- `engine/` — standalone Kotlin adaptive decision engine
- `docs/` — architecture and evaluation documentation

## Status
Early development. Rule thresholds are provisional engineering defaults, not clinically validated cut-offs. This project does not diagnose injuries or prescribe treatment.

## Development
Open the repository root in Android Studio and sync Gradle. Run engine tests with:

```bash
./gradlew :engine:test
```

A Gradle wrapper can be generated using the installed Gradle distribution if it is not yet committed.

## License
License selection pending.
