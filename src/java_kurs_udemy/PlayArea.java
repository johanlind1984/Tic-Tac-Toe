package java_kurs_udemy;

import java.util.Scanner;

public class PlayArea {
    // This class handles everything about the playField. Methods like check if someone won, print the play field and placing markers.
    private static String[] playField = {" ", " ", " ", " ", " ", " ", " ", " ", " "};

    public static void drawPlayfield() {
        // this method prints out the playfiend. Arguments is the arrayw the playField.

        System.out.flush();
        System.out.println(" _____________");
        System.out.println(" | " + playField[0] + " | " + playField[1] + " | " + playField[2] + " | ");
        System.out.println(" _____________");
        System.out.println(" | " + playField[3] + " | " + playField[4] + " | " + playField[5] + " | ");
        System.out.println(" _____________");
        System.out.println(" | " + playField[6] + " | " + playField[7] + " | " + playField[8] + " | ");
        System.out.println(" _____________");
    }

    public static String[] placeMarker(String marker) {
        // this method places a player marker in the playField and returns the playField with the marker position
        Scanner userInput = new Scanner(System.in);
        int valueInput;

        System.out.println("Player '" + marker + "' place your marker at a position between 1-9");

        while (true) {
            if (userInput.hasNextInt()) {
                valueInput = userInput.nextInt();

                if (valueInput > 0 && valueInput < 10) {
                    if (playField[valueInput - 1] != "X" && playField[valueInput - 1] != "O") {
                        playField[valueInput - 1] = marker;
                        userInput.nextLine();
                        return playField;

                    } else {
                        System.out.println("Position was already taken");

                    }
                } else {
                    System.out.println("You must enter a valid position that's not taken between 1-9. Try again");

                }
            } else {
                System.out.println("You must enter a valid position that's not taken between 1-9. Try again");

            }
            userInput.nextLine();
        }
    }

    public static boolean isWinner(String marker) {
        // This method checks if a player won and returns true or false.

        if (((playField[0] == playField[1]) && (playField[1] == playField[2]) && (playField[2] == marker)) ||
                ((playField[3] == playField[4]) && (playField[4] == playField[5]) && (playField[5] == marker)) ||
                ((playField[6] == playField[7]) && (playField[7] == playField[8]) && (playField[8] == marker)) ||
                ((playField[0] == playField[3]) && (playField[3] == playField[6]) && (playField[6] == marker)) ||
                ((playField[1] == playField[4]) && (playField[4] == playField[7]) && (playField[7] == marker)) ||
                ((playField[2] == playField[5]) && (playField[5] == playField[8]) && (playField[8] == marker)) ||
                ((playField[0] == playField[4]) && (playField[4] == playField[8]) && (playField[8] == marker)) ||
                ((playField[2] == playField[4]) && (playField[4] == playField[6]) && (playField[6] == marker))) {
            System.out.println("We got a winner! Congrats " + marker);
            return true;

        } else {
            return false;
        }
    }
}