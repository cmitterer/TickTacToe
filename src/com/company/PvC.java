package com.company;
import java.util.*;

public class PvC {

    public static void beginGame (boolean order) {
        Scanner sc = new Scanner(System.in);
        boolean looping = true;
        int row = 1;
        int column = 1;
        String symbol;

        String [][] board = {{"-", "-", "-"},
                {"-", "-", "-"},
                {"-", "-", "-"}};

        while (looping) {
            System.out.println("     |     |     \n"+
                    "  "+board[0][0]+"  |  "+board[0][1]+"  |  "+board[0][2]+"  \n"+
                    "_____|_____|_____");
            System.out.println("     |     |     \n"+
                    "  "+board[1][0]+"  |  "+board[1][1]+"  |  "+board[1][2]+"  \n"+
                    "_____|_____|_____");
            System.out.println("     |     |     \n"+
                    "  "+board[2][0]+"  |  "+board[2][1]+"  |  "+board[2][2]+"  \n"+
                    "     |     |     ");
            if (order) {
                boolean action; boolean confirming = true;
                System.out.println("It is your turn!");
                symbol = "X";
                while (confirming) {
                    action = true;
                    while (action) {
                        System.out.println("What row would you like to place your symbol?");
                        try {
                            row = sc.nextInt() - 1;
                            if (row >= 0 && row <= 2) {
                                action = false;
                            } else {
                                System.out.println("Number inputted is either lower than 1 or higher than 3.");
                                System.out.println("Please input a number between 1 and 3.");
                            }
                        } catch (InputMismatchException ime) {
                            System.out.println("Not a number. Please input a number between 1 and 3.");
                        }
                    }
                    action = true;
                    while (action) {
                        System.out.println("What column would you like to place your symbol?");
                        try {
                            column = sc.nextInt() - 1;
                            if (column >= 0 && column <= 2) {
                                action = false;
                            } else {
                                System.out.println("Number inputted is either lower than 1 or higher than 3.");
                                System.out.println("Please input a number between 1 and 3.");
                            }
                        } catch (InputMismatchException ime) {
                            System.out.println("Not a number. Please input a number between 1 and 3.");
                        }
                    }

                    if (board[row][column].equals("-")) {
                        board[row][column] = symbol;
                        confirming = false;
                    } else {
                        System.out.println("\nThis location already has a symbol in it. Input a valid location.");
                    }
                }

                board[row][column] = symbol;

                int match = Match.isMatching(board);
                boolean tie = Match.tieGame(board);

                if (match == 1 && !tie) {
                    System.out.println("Player 1 wins!");

                    System.out.println("     |     |     \n"+
                            "  "+board[0][0]+"  |  "+board[0][1]+"  |  "+board[0][2]+"  \n"+
                            "_____|_____|_____");
                    System.out.println("     |     |     \n"+
                            "  "+board[1][0]+"  |  "+board[1][1]+"  |  "+board[1][2]+"  \n"+
                            "_____|_____|_____");
                    System.out.println("     |     |     \n"+
                            "  "+board[2][0]+"  |  "+board[2][1]+"  |  "+board[2][2]+"  \n"+
                            "     |     |     ");

                    looping = false;
                } else if (match == 2 && !tie) {
                    System.out.println("Player 2 wins!");

                    System.out.println("     |     |     \n"+
                            "  "+board[0][0]+"  |  "+board[0][1]+"  |  "+board[0][2]+"  \n"+
                            "_____|_____|_____");
                    System.out.println("     |     |     \n"+
                            "  "+board[1][0]+"  |  "+board[1][1]+"  |  "+board[1][2]+"  \n"+
                            "_____|_____|_____");
                    System.out.println("     |     |     \n"+
                            "  "+board[2][0]+"  |  "+board[2][1]+"  |  "+board[2][2]+"  \n"+
                            "     |     |     ");

                    looping = false;
                } else if (match == 0 && !tie) {
                    if (order) {
                        order = false;
                    } else {
                        order = true;
                    }
                } else if (tie) {
                    System.out.println("Tie Game!");

                    System.out.println("     |     |     \n"+
                            "  "+board[0][0]+"  |  "+board[0][1]+"  |  "+board[0][2]+"  \n"+
                            "_____|_____|_____");
                    System.out.println("     |     |     \n"+
                            "  "+board[1][0]+"  |  "+board[1][1]+"  |  "+board[1][2]+"  \n"+
                            "_____|_____|_____");
                    System.out.println("     |     |     \n"+
                            "  "+board[2][0]+"  |  "+board[2][1]+"  |  "+board[2][2]+"  \n"+
                            "     |     |     ");

                    looping = false;
                }
            } else {
                System.out.println("It is the computer's turn.\n");

                symbol = "O";
                boolean confirming = true;
                while (confirming) {
                    int [] location = AI.getLocation(board, symbol);
                    row = location[0]; column = location[1];

                    if (board[row][column].equals("-")) {
                        board[row][column] = symbol;
                        confirming = false;
                    }
                }


                int match = Match.isMatching(board);
                boolean tie = Match.tieGame(board);

                if (match == 1 && !tie) {
                    System.out.println("Player 1 wins!");

                    System.out.println("     |     |     \n"+
                            "  "+board[0][0]+"  |  "+board[0][1]+"  |  "+board[0][2]+"  \n"+
                            "_____|_____|_____");
                    System.out.println("     |     |     \n"+
                            "  "+board[1][0]+"  |  "+board[1][1]+"  |  "+board[1][2]+"  \n"+
                            "_____|_____|_____");
                    System.out.println("     |     |     \n"+
                            "  "+board[2][0]+"  |  "+board[2][1]+"  |  "+board[2][2]+"  \n"+
                            "     |     |     ");

                    looping = false;
                } else if (match == 2 && !tie) {
                    System.out.println("Player 2 wins!");
                    System.out.println("     |     |     \n"+
                            "  "+board[0][0]+"  |  "+board[0][1]+"  |  "+board[0][2]+"  \n"+
                            "_____|_____|_____");
                    System.out.println("     |     |     \n"+
                            "  "+board[1][0]+"  |  "+board[1][1]+"  |  "+board[1][2]+"  \n"+
                            "_____|_____|_____");
                    System.out.println("     |     |     \n"+
                            "  "+board[2][0]+"  |  "+board[2][1]+"  |  "+board[2][2]+"  \n"+
                            "     |     |     ");

                    looping = false;
                } else if (match == 0 && !tie) {
                    if (order) {
                        order = false;
                    } else {
                        order = true;
                    }
                } else if (tie) {
                    System.out.println("Tie Game!");
                    System.out.println("     |     |     \n"+
                            "  "+board[0][0]+"  |  "+board[0][1]+"  |  "+board[0][2]+"  \n"+
                            "_____|_____|_____");
                    System.out.println("     |     |     \n"+
                            "  "+board[1][0]+"  |  "+board[1][1]+"  |  "+board[1][2]+"  \n"+
                            "_____|_____|_____");
                    System.out.println("     |     |     \n"+
                            "  "+board[2][0]+"  |  "+board[2][1]+"  |  "+board[2][2]+"  \n"+
                            "     |     |     ");

                    looping = false;
                }
            }

        }
        System.out.println("Game Over Please Click the Green Arrow to play Again");
    }
}