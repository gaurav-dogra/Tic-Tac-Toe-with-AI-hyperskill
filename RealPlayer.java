package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RealPlayer implements IMoveStrategy {
    @Override
    public void move(Grid grid) {
        final Scanner scanner = new Scanner(System.in);

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

            if (coordinateOne > 2 || coordinateTwo > 2) {
                System.out.println("Coordinates should be from 0 to 2!");
                continue;
            }

            if (!grid.isEmpty(coordinateOne, coordinateTwo)) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                grid.updateCell(coordinateOne, coordinateTwo, grid.getCurrentPlayerSign());
                break;
            }

        }
    }
}
