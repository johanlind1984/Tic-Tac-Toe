package java_kurs_udemy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean isWinner = false;
        int turn = 0;
        String[] playerMarkers = new String[2];
        PlayArea playField = new PlayArea();

        while (!isWinner) {
            System.out.println("Welcome to Tic-Tac-Toe");
            System.out.println("#-#-#-#-#-#-#-#-#-#-#-#");
            playField.drawPlayfield();
            System.out.println("Player 1, please chose your marker. 1 for 'X' and 2. for 'O'");
            playerMarkers = chooseMarker();

            while (!isWinner && turn < 9) {
                if (turn % 2 == 0) {
                    playField.placeMarker(playerMarkers[0]);
                    isWinner = playField.isWinner(playerMarkers[0]);

                } else {
                    playField.placeMarker(playerMarkers[1]);
                    isWinner = playField.isWinner(playerMarkers[1]);

                }

                playField.drawPlayfield();
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


