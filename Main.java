/**
 * Nathan Gloman
 * 2/8/26
 * CS 122
 * Module 5: Bingo Project
 * This is a simple game of Bingo. The program generates a 5x5 2D array with
 * random values in their respective ranges to represent a Bingo card. Random
 * numbers are drawn, displayed to the user, and marked on the Bingo card.
 * The game keeps looping until a Bingo is reached and the winning line is displayed.
 *
 * Test Data:
 * I did a lot of testing on formatting the output of the Bingo Card. I used different
 * formatting specifiers until I found the one that works the best. I also tested the
 * use of single dimensions arrays and ArrayLists to keep track of called numbers
 * and the winning line. I found that using ArrayLists were more beneficial due to
 * their incorporated methods.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BingoCard card = new BingoCard();
        BingoGame game = new BingoGame();
        Scanner input = new Scanner(System.in);

        System.out.println("\n" + "         Welcome to Bingo!\n");
        System.out.println("Here is your Bingo Card. Good Luck!");
        card.displayCard(card);

        System.out.println("Press enter to continue...");
        input.nextLine();

        game.playBingo(card);

        input.close();
    }
}

/**
 * Reflection Questions
 * 1. The most challenging part of this project was how to display the winning line.
 * I was trying to accomplish two functionalities within one method. After the help
 * of generative AI, I was able to overcome this problem.
 *
 * 2. I used a generative AI to help me display the winning line. Instead of
 * having one method do two things, the AI broke my problem up into two methods,
 * getWinningLine() and displayWinningLine(). I then altered playGame()
 * by adding an ArrayList, setting it to getWinningLine(), then calling
 * displayWinningLine(). I found this very helpful and efficient but will always
 * try to work out problems on my own before asking AI for assistance.
 *
 * 3. The biggest skill I feel I have improved is keeping track of where program
 * execution is taking place within a 2D array. Another skill I feel has improved is
 * the general organization of a program, specifically where to put the logic, and
 * where to keep things more simplified.
 *
 * 4. If I had more time I would have added multiple Bingo Cards and have them
 * displayed horizontally in the console for easier viewing. I would have also added
 * some color and the ability to pick different emojis for marking numbers.
 */
