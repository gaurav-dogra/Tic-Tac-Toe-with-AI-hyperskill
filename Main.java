package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid();

        while (true) {

            grid.print();

            getNextMove(grid); // user move
            grid.print();

            if (grid.getStatus() != ResultStrings.GAME_NOT_FINISHED) {
                System.out.println(grid.getStatus());
                break;
            }

            moveByAI(grid); // AI move
            grid.print();

            if (grid.getStatus() != ResultStrings.GAME_NOT_FINISHED) {
                System.out.println(grid.getStatus());
                break;
            }
        }
    }

    private static void moveByAI(Grid grid) {
        System.out.println("Making move level \"easy\"");
        while (true) {
            int row = (int) (Math.random() * 3);
            int column = (int) (Math.random() * 3);
            if (grid.isEmpty(row, column)) {
                grid.changeCell(row, column);
                break;
            }
        }
    }

    private static void getNextMove(Grid grid) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the coordinates: ");
            int coordinateOne;
            int coordinateTwo;

            try {

                coordinateOne = scanner.nextInt();
                coordinateTwo = scanner.nextInt();
                coordinateOne--;
                coordinateTwo--;
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
                continue;
            }

            if (coordinateOne > 2 || coordinateTwo > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (!grid.isEmpty(coordinateOne, coordinateTwo)) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                grid.changeCell(coordinateOne, coordinateTwo);
                break;
            }

        }
    }

}
