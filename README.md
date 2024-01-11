# Stick Hero Game

**Developed by:**
- Agranye Tripathi (2022011)
- Sarthak Sharma (2022456)

## How to Play the Game

1. **Hold and Release the Mouse to Extend the Stick**
2. **Click the Mouse Once to Flip the Character onto the Cherry**
3. **Require More Than 3 Cherries to Revive**
4. **For a Consecutive Streak of 15 Successful Moves, Players are Awarded an Extra 50 Points**

## Code Explanation

1. First, we load our initial scene with three options:
    - **Start**
    - **Exit**
    - **Reload**

2. Upon starting, we enter the main game screen with three major point systems:
    - **Cherries:** Used to revive the character
    - **Normal Points**
    - **Bonus Points:** Earned after a streak of 15 successful moves

3. The game also includes a pause option, from which we can:
    - **Save and Exit**
    - **Resume**

4. If the user undershoots or overshoots the stick, the character falls, leading to the next scene with three options:
    - **Restart**
    - **Revive (only if cherries >= 3)**
    - **Main Menu**

## Important Concepts Applied

1. **INHERITANCE:** Utilized in the game's class structure.
2. **Serialization and Deserialization:** Implemented for saving and loading games.
3. **THREADING:** Applied to maintain a count for successful move streaks.
4. **Singleton/DESGIN PATTERNS:** Used in the `Admin` and `StickHero` classes to ensure only one instance exists.
5.  **JUNIT:**
