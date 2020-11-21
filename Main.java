package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid();

        while (true) {
            System.out.println("Pick Players from: user, EasyAI, MediumAI, HardAI" );
            System.out.println("You can play any two players against each other");
            System.out.println("e.g. start user vs EasyAI");
            System.out.println("e.g. start EasyAI vs HardAI");
            System.out.print("Input command: ");
            String input = scanner.nextLine().toLowerCase();

            if ("exit".equals(input)) {
                break;
            }
            // types of players User: humanPlayer, easy: easyAI player, medium: mediumAI player, hard: Hard AI Player
            if (!input.matches("^start\\s+(easyai|user|mediumai|hardai)\\s+vs\\s+(easyai|user|mediumai|hardai)")) {
                System.out.println("Bad parameters!");
                continue;
            }

            String[] inputArray = input.split(" ");

            Context playerOne = getPlayer(inputArray[1]);
            Context playerTwo = getPlayer(inputArray[3]);

            ResultStrings result = playGame(playerOne, playerTwo, grid);
            System.out.println(result.toString());
            System.out.println();
            System.out.println();
            grid = new Grid(); // reset all the box to empty
        }
    }

    private static ResultStrings playGame(Context playerOne, Context playerTwo, Grid grid) {
        while (true) {

            playerOne.move(grid);
            grid.print();
            if (gameIsOver(grid)) {
                break;
            }

            playerTwo.move(grid);
            grid.print();
            if (gameIsOver(grid)) {
                break;
            }
        }
        return grid.getStatus();
    }

    private static boolean gameIsOver(Grid grid) {
        return grid.getStatus() != ResultStrings.GAME_NOT_FINISHED;
    }

    private static Context getPlayer(String s) {
        if ("easyai".equals(s)) {
            return new Context(new EasyAI());
        } else if ("mediumai".equals(s)) {
            return new Context(new MediumAI());
        } else if ("hardai".equals(s)) {
            return new Context((new HardAI()));
        } else {
            return new Context(new HumanPlayer());
        }
    }

}
