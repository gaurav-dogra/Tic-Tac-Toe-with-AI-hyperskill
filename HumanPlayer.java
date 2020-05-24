package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements IMoveStrategy {
    @Override
    public void move(Grid grid) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the coordinates: ");
            int row;
            int column;

            try {

                row = scanner.nextInt();
                column = scanner.nextInt();
                row--;
                column--;
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
                continue;
            }

            if (row > 2 || column > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (!grid.isEmpty(row, column)) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                grid.updateCell(row, column, grid.getCurrentPlayerSign());
                break;
            }

        }
    }
}
