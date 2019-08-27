package java_kurs_udemy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int turn = 0;
        boolean isWinner = false;
        String[] playField = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        String[] testField = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] playerMarkers = new String[2];

        while (!isWinner) {
            System.out.println("Welcome to Tic-Tac-Toe");
            System.out.println("#-#-#-#-#-#-#-#-#-#-#-#");
            PlayArea.drawPlayfield(testField);
            System.out.println("Player 1, please chose your marker. 1 for 'X' and 2. for 'O'");
            playerMarkers = chooseMarker();

            while (!isWinner && turn < 9) {
                if (turn % 2 == 0) {
                    playField = PlayArea.placeMarker(playerMarkers[0], playField);
                    isWinner = PlayArea.isWinner(playField, playerMarkers[0]);

                } else {
                    playField = PlayArea.placeMarker(playerMarkers[1], playField);
                    isWinner = PlayArea.isWinner(playField, playerMarkers[1]);

                }

                PlayArea.drawPlayfield(playField);
                turn++;
            }
        }
    }

    public static String[] chooseMarker() {
        // This method check if 1 or 2 is chosen by player 1 and assigns the players markers. If 1 or 2 is not chosen in input the loop keeps asking until 1 or 2 is chosen.
        Scanner userInput = new Scanner(System.in);
        String[] playerMarkers = new String[2];

        while (true) {
            if (userInput.hasNextInt()) {
                int valueInput = userInput.nextInt();

                if (valueInput == 1) {
                    playerMarkers[0] = "X";
                    playerMarkers[1] = "O";
                    System.out.println("Player 1 choose X so Player 2 is O");
                    userInput.nextLine();
                    break;

                } else if (valueInput == 2) {
                    playerMarkers[0] = "O";
                    playerMarkers[1] = "X";
                    System.out.println("Player 1 choose O so Player 2 is X");
                    userInput.nextLine();
                    break;

                }
            } else {
                System.out.println("You have to choose either 1 or 2. Try again!");

            }
            userInput.nextLine();
        }
        return playerMarkers;
    }
}


