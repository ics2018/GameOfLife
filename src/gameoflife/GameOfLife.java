package gameoflife;

import javax.swing.*;

public class GameOfLife {

    public static void main(String[] args) {
        String board[][] = new String[20][20];
        String myInput;
        int generation = 0;

        //initialize the board to spaces
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                board[i][j] = ".";
            }
        }

        int cells = 0;
        //Determine the number of cells to start with
        myInput = JOptionPane.showInputDialog("Welcome to the game of life!\n"
                + "Please enter how many cells you wish to start the game with.");
        cells = Integer.parseInt(myInput);

        //Place random cells on the board
        int randCol, randRow;
        for (int i = 0; i < cells; i++) {
            randCol = (int) (Math.random() * 20);
            randRow = (int) (Math.random() * 20);
            board[randCol][randRow] = "O";
        }

        String continueGame = "";
        while (!continueGame.equals("exit")) {
            //Temporary board for placing new cells
            String board2[][] = new String[20][20];

            //Display current board
            System.out.println("----Generation "+generation+"-------------------------------------");
            generation++;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.print("\n");
            }
            

            //Menu
            continueGame = JOptionPane.showInputDialog("1 - Advance one generation.\n"
                    + "exit - exit game");
            if (continueGame.equals("1")) {
                //Propagate neighbours
                int neighbours;
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 20; j++) {
                        neighbours = 0;
                        //assume the cell in the next generation is not alive
                        board2[i][j] = ".";
                        //count the number of neighbours the cell has

                        //Note : check i and j to prevent ArrayIndexOutOfBounds Exceptions
                        if (i > 0 && j > 0) {
                            if (board[i - 1][j - 1].equals("O")) {
                                neighbours++;
                            }
                        }
                        if (i > 0) {
                            if (board[i - 1][j].equals("O")) {
                                neighbours++;
                            }
                        }
                        if (i > 0 && j < 19) {
                            if (board[i - 1][j + 1].equals("O")) {
                                neighbours++;
                            }
                        }
                        if (j > 0) {
                            if (board[i][j - 1].equals("O")) {
                                neighbours++;
                            }
                        }
                        if (j < 19) {
                            if (board[i][j + 1].equals("O")) {
                                neighbours++;
                            }
                        }
                        if (i < 19 && j > 0) {
                            if (board[i + 1][j - 1].equals("O")) {
                                neighbours++;
                            }
                        }
                        if (i < 19) {
                            if (board[i + 1][j].equals("O")) {
                                neighbours++;
                            }
                        }
                        if (i < 19 && j < 19) {
                            if (board[i + 1][j + 1].equals("O")) {
                                neighbours++;
                            }
                        }
                        //Determine if the cell in the next generation is alive
                        if (board[i][j].equals("O") && (neighbours == 2 || neighbours == 3)) {
                            board2[i][j] = "O";
                        }
                        if (board[i][j].equals(".") && neighbours == 3) {
                            board2[i][j] = "O";
                        }
                    }
                }
                //Replace board with the new board
                board = board2;
            }
        }
    }
}
