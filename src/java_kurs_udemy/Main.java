package java_kurs_udemy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean isWinner = false;
        int turn = 0;
        PlayArea playField = new PlayArea();

        while (!isWinner) {
            System.out.println("Welcome to Tic-Tac-Toe");
            System.out.println("#-#-#-#-#-#-#-#-#-#-#-#");
            playField.drawPlayfield();
            System.out.println("Player 1, please chose your marker. 1 for 'X' and 2. for 'O'");
            String[] playerMarkers = Players.chooseMarker();

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
}


