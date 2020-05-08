package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        final String input = scanner.next();
        final Grid grid = new Grid(input);
        grid.print();
        getNextMove(scanner, grid);
        grid.print();
        System.out.println(grid.getStatus());
    }

    private static void getNextMove(Scanner scanner, Grid gri{
        while (true) {
            System.out.print("Enter the coordinates: ");
            int coordinateOne;
            int coordinateTwo;

            try {

                coordinateOne = scanner.nextInt();
                coordinateTwo = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
                continue;
            }

            if (coordinateOne > 3 || coordinateTwo > 3) {
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
