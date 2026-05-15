/**
 * Nathan Gloman
 * 2/8/26
 * CS 122
 * Module 5: Bingo Project
 * The BingoGame class handles the game logic and loop
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BingoGame {
    private BingoCard card;

    /** constructor BingoGame()
     * generates a BingoCard
     */
    public  BingoGame() {
        card = new BingoCard();
    }

    /**
     * method turn()
     * generates random numbers to be called, marks
     * the numbers, and displays the board
     * @param card the BingoCard
     */
    public void turn(BingoCard card) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> calledNums = new ArrayList<>();
        int num;    //the called number

        //generates a random number to be called
        num = rand.nextInt(75) + 1;
        calledNums.add(num);

        //displays the called number
        if (num <= 15) {
            System.out.println("\nNumber Drawn: B" + num);
        }
        else if (num <= 30) {
            System.out.println("\nNumber Drawn: I" + num);
        }
        else if (num <= 45) {
            System.out.println("\nNumber Drawn: N" + num);
        }
        else if (num <= 60) {
            System.out.println("\nNumber Drawn: G" + num);
        }
        else {
            System.out.println("\nNumber Drawn: O" + num);
        }

        //check and mark number
        int size = 5;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (card.getNumber(row, col) == num) {
                    card.markNumber(row, col);
                    System.out.println("Your number was marked");
                }
            }
        }

        card.displayCard(card);

        if (!checkBingo(card)){
            System.out.println("Press enter to continue...");
            input.nextLine();
        }

        if (checkBingo(card)){
            input.close();
        }
    }

    /**
     * method checkBingo()
     * checks row, cols, and both diagonals for a Bingo
     * @param card the BingoCard
     * @return true if there is a Bingo
     */
    public boolean checkBingo(BingoCard card) {
        int size = 5;   //the length of a bingo

        //check rows
        for (int row = 0; row < size; row++) {
            boolean bingo = true;

            for (int col = 0; col < size; col++) {
                if (card.getNumber(row, col) != 0) {
                    bingo = false;
                    break;
                }
            }

            if (bingo) {
                return true;
            }
        }

        //check columns
        for (int col = 0; col < size; col++) {
            boolean bingo = true;

            for (int row = 0; row < size; row++) {
                if (card.getNumber(row, col) != 0) {
                    bingo = false;
                    break;
                }
            }

            if (bingo) {
                return true;
            }
        }

        //check left diagonal
        boolean bingo = true;
        for (int d = 0; d < size; d++) {
            if (card.getNumber(d,d) != 0) {
                bingo = false;
                break;
            }
        }

        if (bingo) {
            return true;
        }

        // right diagonal
        bingo = true;
        for (int d = 0; d < size; d++) {
            if (card.getNumber(d, size - 1 - d) != 0) {
                bingo = false;
                break;
            }
        }

        return bingo;
    }

    /**
     * method getWinningLine()
     * iterates through the winning board and retrieves the elements
     * in the winning line
     * @param card the BingoCard
     * @return the winning line
     */
    public ArrayList<int[]> getWinningLine(BingoCard card) {
        int size = 5;
        ArrayList<int[]> line = new ArrayList<>();

        // check rows
        for (int row = 0; row < size; row++) {
            line.clear();
            boolean bingo = true;

            for (int col = 0; col < size; col++) {
                if (card.getNumber(row, col) != 0) {
                    bingo = false;
                    break;
                }
                line.add(new int[]{row, col});
            }

            if (bingo) return new ArrayList<>(line);
        }

        // check columns
        for (int col = 0; col < size; col++) {
            line.clear();
            boolean bingo = true;

            for (int row = 0; row < size; row++) {
                if (card.getNumber(row, col) != 0) {
                    bingo = false;
                    break;
                }
                line.add(new int[]{row, col});
            }

            if (bingo) return new ArrayList<>(line);
        }

        // left diagonal
        line.clear();
        boolean bingo = true;
        for (int i = 0; i < size; i++) {
            if (card.getNumber(i, i) != 0) {
                bingo = false;
                break;
            }
            line.add(new int[]{i, i});
        }
        if (bingo) return new ArrayList<>(line);

        // right diagonal
        line.clear();
        bingo = true;
        for (int i = 0; i < size; i++) {
            if (card.getNumber(i, size - 1 - i) != 0) {
                bingo = false;
                break;
            }
            line.add(new int[]{i, size - 1 - i});
        }
        if (bingo) return new ArrayList<>(line);

        return null; // no bingo
    }

    /**
     * method playBingo()
     * handles the game loop until there is a winner
     * @param card the BingoCard
     */
    public void playBingo(BingoCard card){
        boolean winner = false;

        do{
            turn(card);
            ArrayList<int[]> winningLine = getWinningLine(card);

            if (winningLine != null) {
                winner = true;
                System.out.println("BINGO!!! Congrats you won!");
                card.displayWinningLine(winningLine);
            }
        }while(!winner);
    }
}

