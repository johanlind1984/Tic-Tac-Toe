package java_kurs_udemy;

import java.util.Scanner;

public class PlayArea {

    // This class handles everything about the playfield. Methods like check if someone won, print the play field and placing markers.

    public static void drawPlayfield(String[] playfield) {
        // this method prints out the playfiend. Arguments is the arrayw the playfield.

        System.out.flush();
        System.out.println(" _____________");
        System.out.println(" | " + playfield[0] + " | " + playfield[1] + " | " + playfield[2] + " | ");
        System.out.println(" _____________");
        System.out.println(" | " + playfield[3] + " | " + playfield[4] + " | " + playfield[5] + " | ");
        System.out.println(" _____________");
        System.out.println(" | " + playfield[6] + " | " + playfield[7] + " | " + playfield[8] + " | ");
        System.out.println(" _____________");
    }

    public static String[] placeMarker(String marker, String[] playfield) {
        // this method places a player marker in the playfield and returns the playfield with the marker position
        Scanner userInput = new Scanner(System.in);
        int valueInput;

        System.out.println("Player '" + marker + "' place your marker at a position between 1-9");

        while (true) {
            if (userInput.hasNextInt()) {
                valueInput = userInput.nextInt();

                if (valueInput > 0 && valueInput < 10) {
                    if (playfield[valueInput - 1] != "X" && playfield[valueInput - 1] != "O") {
                        playfield[valueInput - 1] = marker;
                        userInput.nextLine();
                        return playfield;

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

    public static boolean isWinner(String[] playfield, String marker) {
        // This method checks if a player won and returns true or false.

        if (((playfield[0] == playfield[1]) && (playfield[1] == playfield[2]) && (playfield[2] == marker)) ||
                ((playfield[3] == playfield[4]) && (playfield[4] == playfield[5]) && (playfield[5] == marker)) ||
                ((playfield[6] == playfield[7]) && (playfield[7] == playfield[8]) && (playfield[8] == marker)) ||
                ((playfield[0] == playfield[3]) && (playfield[3] == playfield[6]) && (playfield[6] == marker)) ||
                ((playfield[1] == playfield[4]) && (playfield[4] == playfield[7]) && (playfield[7] == marker)) ||
                ((playfield[2] == playfield[5]) && (playfield[5] == playfield[8]) && (playfield[8] == marker)) ||
                ((playfield[0] == playfield[4]) && (playfield[4] == playfield[8]) && (playfield[8] == marker)) ||
                ((playfield[2] == playfield[4]) && (playfield[4] == playfield[6]) && (playfield[6] == marker))) {
            System.out.println("We got a winner! Congrats " + marker);
            return true;

        } else {
            return false;
        }
    }
}