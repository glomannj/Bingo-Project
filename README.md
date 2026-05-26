A console-based Bingo game written in Java. The program generates a randomized 5x5 Bingo card, draws numbers one at a time, and marks matches on the card. This program will loop until a Bingo a Bingo is achieved then displays the winning line.

####Project Structure####
bingo/
├── Main.java         # Entry point; initializes the card and starts the game
├── BingoCard.java    # Represents and manages the 5×5 Bingo card
└── BingoGame.java    # Handles game logic, number drawing, and win detection

####How to Run####
Requirements: Java 8 or higher
# Compile
javac Main.java BingoCard.java BingoGame.java

# Run
java Main

####Gameplay####
1. A randomized Bingo card is generated and displayed at the start.
2. Press Enter to draw a number each turn.
3. Drawn numbers are displayed with their BINGO columns label (e.g. B12, N34).
4. If the number appears on your card, it is automatically marked.
5. The game continues until a row, column, or diagonal is fully marked.
6. When a Bingo is achieved, the winning line is highlighted on the final board.

####Sample Output####
Welcome to Bingo!

Here is your Bingo Card. Good Luck!

     B  -  I  -  N  -  G  -  O
     3    17    33    47    62
    11    22    38    55    70
     8    29     0    60    66
    14    18    41    52    75
     5    25    44    58    68

Press enter to continue...

Number Drawn: B3
Your number was marked

BINGO!!! Congrats you won!

####Class Overview####
BingoCard
- Generates a valid 5x5 card with unique numbers in BINGO column ranges:
  - B:1-15 | I:16-30 | N:31-45 | G:46-60 | O:61-75
- The center square (N, row 2) is a free space (0).
- Key methods: getNumber(), markNumber(), displayCard(), displayWinningLine()

BingoGame
- Draws random numbers each turn and checks them against the card.
- Detects Bingo across all row, columns, and both diagonals.
- Key methods: turn(), checkBingo(), getWinningLine(), playBingo()

Main
- Creates a BingoCard and BingoGame, displays the initial card, and starts the game loop.

####Design Notes####
- Marked numbers are stored as 0  in the 2D array for simple win-condition checking.
- ArrayList<int[]> is used to track winning positions for flexible line display.
- Win detection checks all rows, columns, and both diagonals each turn.

####Potential Improvements####
- Display multiple Bingo cards side by side.
- Add color-coded output for marked numbers.
- Allow players to choose an emoji marker.
- Track and display all previously called numbers.

####Author####
Nathan Gloman - CS 122, Module 5
