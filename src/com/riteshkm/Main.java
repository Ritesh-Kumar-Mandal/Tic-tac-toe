package com.riteshkm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] gameBoard = new char[3][3];

        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter cells: ");
//        String gamePlay = scanner.nextLine();
//        char[] result = gamePlay.toCharArray();
        int ticTac = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
//                gameBoard[i][j] = result[ticTac];
                gameBoard[i][j] = '_';
                ticTac++;
            }
        }
        printBoard(gameBoard);

        char turn = 0;

        while(!isGameFinished(gameBoard)){
            System.out.print("Enter the coordinates: ");
            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (validInput(x, y, gameBoard)) {
                    if(turn%2==0) gameBoard[x-1][y-1] = 'X';
                    else gameBoard[x-1][y-1] = 'O';
                    printBoard(gameBoard);
                    turn++;
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
            }
        }

//        isGameFinished(gameBoard);
    }

    private static boolean validInput(int x, int y, char[][] gameBoard){

        if( (x>3||x<1) || (y>3||y<1) ){
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }else if (gameBoard[x-1][y-1]!='_'){
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        return true;
    }


    private static void printBoard(char[][] gameBoard) {
        System.out.println("---------");
        System.out.println("|" + " " + gameBoard[0][0] + " " + gameBoard[0][1] + " " + gameBoard[0][2] + " " + "|");
        System.out.println("|" + " " + gameBoard[1][0] + " " + gameBoard[1][1] + " " + gameBoard[1][2] + " " + "|");
        System.out.println("|" + " " + gameBoard[2][0] + " " + gameBoard[2][1] + " " + gameBoard[2][2] + " " + "|");
        System.out.println("---------");
    }


    private static boolean isGameFinished(char[][] gameBoard) {

        long Xcount = 0, Ocount = 0, _count = 0;

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(gameBoard[i][j]=='X') Xcount++;
                else if(gameBoard[i][j]=='O') Ocount++;
                else _count++;
            }
        }

        if( (isTheWinner(gameBoard, 'X') && isTheWinner(gameBoard, 'O')) || (Math.abs(Xcount - Ocount) > 1) ) {
//        printBoard(gameBoard);
            System.out.println("Impossible");
            return false;
        }

        if (isTheWinner(gameBoard, 'X')) {
//        printBoard(gameBoard);
            System.out.println("X wins");
            return true;

        }
        if (isTheWinner(gameBoard, 'O')) {
//        printBoard(gameBoard);
            System.out.println("O wins");
            return true;
        }

        if(_count>0){
//            System.out.println("Game not finished");
            return false;
        }

        System.out.println("Draw");
        return true;
    }

    private static boolean isTheWinner(char[][] gameBoard, char symbol) {
        return (gameBoard[0][0] == symbol && gameBoard[0][1] == symbol && gameBoard[0][2] == symbol) ||
                (gameBoard[1][0] == symbol && gameBoard[1][1] == symbol && gameBoard[1][2] == symbol) ||
                (gameBoard[2][0] == symbol && gameBoard[2][1] == symbol && gameBoard[2][2] == symbol) ||

                (gameBoard[0][0] == symbol && gameBoard[1][0] == symbol && gameBoard[2][0] == symbol) ||
                (gameBoard[0][1] == symbol && gameBoard[1][1] == symbol && gameBoard[2][1] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][2] == symbol && gameBoard[2][2] == symbol) ||

                (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol);


    }
}