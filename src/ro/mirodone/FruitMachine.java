package ro.mirodone;

import java.util.Random;
import java.util.Scanner;

class FruitMachine {

    private Scanner scan = new Scanner(System.in);
    private Random r = new Random();
    private int Credits = 10;
    private boolean game = true;

    void theGame() {

        while (game) {

            //The game menu is displayed and allows the user to navigate.
            System.out.println("++++++++++++++++++" + "\n" + "Welcome to my Fruit Machine!" +
                    "\n" + "Game Menu" + "\n" +
                    "1. Credits Enquiry (1)" + "\n" +
                    "2. Play (2)" + "\n" +
                    "3. Quit Game (3)");
            int userChoice = scan.nextInt();

            //The user opts to quit the program.
            if (userChoice == 3) {
                System.out.println("Credits remaining: " + Credits);
                System.out.println("Thank you for playing.");
                game = false;
            }

            //The user makes an enquiry for their credits balance.
            if (userChoice == 1) {
                System.out.println("You currently have " + Credits + " credits remaining.");
            }

            //The user decides the play the game.
            if (userChoice == 2) {
                if (Credits == 0) {
                    System.out.println("Game Over! Thanks for playing.");
                    game = false;
                } else {
                    String[] reel = {"Plum", "Orange", "Bell", "Cherry", "Bar",
                            "Cherry", "Seven"};
                    //We generate our 3 random numbers
                    int Reel1 = r.nextInt(6) + 1;
                    int Reel2 = r.nextInt(6) + 1;
                    int Reel3 = r.nextInt(6) + 1;


                    Credits--;
                    System.out.println("Here is your spin! {||" + reel[Reel1] + "||" + reel[Reel2] + "||" + reel[Reel3] + "||}");
                    //To check if the user got 7-7-7
                    if (Reel1 == 6 && Reel2 == 6 && Reel3 == 6) {
                        Credits = (Credits + 150);
                        System.out.println("Congratulations on your win of 150 credits, you currently have " + Credits + " credits remaining.");
                    }
                    //To check if all of the user's numbers are identical
                    else if (Reel1 == Reel2 && Reel1 == Reel3) {
                        Credits = (Credits + 80);
                        System.out.println("Congratulations on your win of 80 credits, you currently have " + Credits + " credits remaining.");
                    }
                    //To check if the any 2 of the user's numbers are matching + Seven
                    else if (Reel1 == Reel2 && Reel3 == 6 || Reel1 == Reel3 && Reel2 == 6 || Reel2 == Reel3 && Reel1 == 6) {
                        Credits = (Credits + 20);
                        System.out.println("Congratulations on your win of 20 credits, you currently have " + Credits + " credits remaining.");
                    }
                    //To check if the any 2 of the user's numbers are matching
                    else if (Reel1 == Reel2 || Reel1 == Reel3 || Reel2 == Reel3) {
                        Credits = (Credits + 10);
                        System.out.println("Congratulations on your win of 10 credits, you currently have " + Credits + " credits remaining.");
                    }
                    //To check if any 1 of the user's number is a 7
                    else if (Reel1 == 6 || Reel2 == 6 || Reel3 == 6) {
                        Credits = (Credits + 2);
                        System.out.println("Congratulations on your win of 2 credits, you currently have " + Credits + " credits remaining.");
                    } else {
                        System.out.println("Unlucky you did not win, you currently have " + Credits + " credits remaining.");
                    }
                }
            }
        }
    }
}
