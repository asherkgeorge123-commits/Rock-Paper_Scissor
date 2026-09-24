# Rock Paper Scissors — Java Swing GUI

A desktop Rock Paper Scissors game built with Java Swing, made as a personal project to practice object-oriented design and event-driven programming.

## Features
- Graphical interface built with Java Swing
- Score tracking across rounds
- Timer-based "reveal" animation — the computer's move is hidden briefly and buttons are disabled while it plays, so rounds can't overlap
- Separate launcher and instructions windows
- Game logic kept separate from the GUI code

## Structure
The project is split across 5 classes:
- `LauncherFrame` — starting screen with buttons to launch the game or view instructions
- `GameFrame` — the main game window and Swing components
- `GameLogic` — win/loss rules and score tracking, kept independent of the UI
- `Instruction` — the instructions window
- (plus one supporting class)

Splitting logic from the UI this way made it possible to change how the game looked without touching the rules, and to test the rules without a UI.

## How to run
1. Clone the repo
2. Open the project in an IDE that supports Java Swing (e.g. IntelliJ, Eclipse)
3. Run `LauncherFrame`

## Built with
Java, Java Swing

## Status
Personal project, completed for practice with OOP and GUI event handling.
