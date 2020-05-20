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
            // theree types of players User: realPlayer, easy: easyAI player, medium: mediumAI player
            if (!input.matches("^start\\s+(easy|user|medium|hard)\\s+(easy|user|medium|hard)")) {
                System.out.println("Bad parameters!");
                continue;
            }

            String[] inputArray = input.split(" ");

            Context playerOne = getPlayer(inputArray[1]);
            Context playerTwo = getPlayer(inputArray[2]);

            ResultStrings result = playGame(playerOne, playerTwo, grid);
            System.out.println(result.toString());
            grid = new Grid(); // reset all the box to empty
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
        } else if ("medium".equals(s)) {
            return new Context(new MediumAI());
        } else if ("hard".equals(s)) {
            return new Context(new HardAI());
        } else {
            return new Context(new RealPlayer());
        }
    }

}
