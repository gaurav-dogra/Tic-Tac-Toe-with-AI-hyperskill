package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid();

        while (true) {

            System.out.print("Input command: ");
            String input = scanner.nextLine().toLowerCase();

            if ("exit".equals(input)) {
                break;
            }
            // correct input options are
            // start easy easy
            // start user user
            // start user easy
            // start easy user
            if (!input.matches("^start\\s+(easy|user)\\s+(easy|user)")) {
                System.out.println("Bad parameters!");
                continue;
            }

            String[] inputArray = input.split(" ");

            Context playerOne = getPlayer(inputArray[1]);
            Context playerTwo = getPlayer(inputArray[2]);

            ResultStrings result = playGame(playerOne, playerTwo, grid);
            grid = new Grid(); // reset all the box to empty
            System.out.println(result.toString());
        }
    }

    private static ResultStrings playGame(Context playerOne, Context playerTwo, Grid grid) {
        grid.print();
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
        if ("easy".equals(s)) {
            return new Context(new EasyAI());
        } else {
            return new Context(new RealPlayer());
        }
    }

}
