/**
 * Nathan Gloman
 * 2/8/26
 * CS 122
 * Module 5: Bingo Project
 * The BingoCard class is represented as a 5x5 2D array.
 */

import java.util.ArrayList;
import java.util.Random;

public class BingoCard {
    private int[][] bingoCard;

    /**
     * constructor BingoCard()
     * generates a 5x5 2D array to represent a Bingo card
     */
    public BingoCard() {
        bingoCard = new int[5][5];
        ArrayList<Integer> usedNums = new ArrayList<>();
        Random rand = new Random();

        //fills the card with random values
        for (int col = 0; col < bingoCard.length; col++) {
            for (int row = 0; row < bingoCard.length; row++) {
                if (row == 2 && col == 2) {
                    bingoCard[row][col] = 0;
                    continue;
                }

                int randNum;
                int minVal = col * 15 + 1;  //the minimum value of each column
                int maxVal = minVal + 14;   //the maximum value of each column

                 do {
                     //generating a random number in respective range
                     randNum = rand.nextInt(maxVal - minVal + 1) + minVal;
                 }while (usedNums.contains(randNum));

                usedNums.add(randNum);
                bingoCard[row][col] = randNum;
            }
        }
    }

    /**
     * method getNumber()
     * gets the numbers from the Bingo card
     * @param row the rows of the card
     * @param col the columns of the card
     * @return the number as row and col
     */
    public int getNumber(int row, int col) {
        return bingoCard[row][col];
    }

    /**
     * method markNumber()
     * marks the called number
     * @param row the rows of the card
     * @param col the columns of the card
     */
    public void markNumber(int row, int col) {
        bingoCard[row][col] = 0;
    }

    /**
     * method displayWinningLine()
     * displays the winning line when the game ends
     * @param winningLine the winning line
     */
    public void displayWinningLine(ArrayList<int[]> winningLine) {
        System.out.println("\nHere is your winning line");
        System.out.println("\n     B  -  I  -  N  -  G  -  O");

        //iterating through the array checking if there is a spot in the winning line
        for (int row = 0; row < bingoCard.length; row++) {
            for (int col = 0; col < bingoCard[row].length; col++) {
                boolean isWinningSpot = false;

                for (int[] pos : winningLine) {
                    if (pos[0] == row && pos[1] == col) {
                        isWinningSpot = true;
                        break;
                    }
                }

                if (isWinningSpot) {
                    System.out.printf("[%4d] ", bingoCard[row][col]);
                } else {
                    System.out.printf(" %4d  ", bingoCard[row][col]);
                }
            }
            System.out.println();
        }
    }

    /**
     * method displayCard()
     * displays the Bingo card
     * @param card the BingoCard
     */
    public void displayCard(BingoCard card) {
        System.out.println("\n" + "     B  -  I  -  N  -  G  -  O");
        for (int row = 0; row < card.bingoCard.length; row++) {
            for (int col = 0; col < card.bingoCard[row].length; col++) {
                System.out.printf("%6d", card.bingoCard[row][col]);
            }
            System.out.println();
        }
    }

}
