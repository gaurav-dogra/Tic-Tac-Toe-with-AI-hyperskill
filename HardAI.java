package tictactoe;

public class HardAI implements IMoveStrategy {

    @Override
    public void move(Grid grid) {
        System.out.println("Making move level \"hard\"");
        boolean isMaximizer = grid.getCurrentPlayerSign() == 'X';
        int finalRow = -1;
        int finalColumn = -1;
        int score = isMaximizer ? -1000 : 1000;

        if (isMaximizer) {
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    if (grid.isEmpty(row, column)) {
                        grid.updateCell(row, column, 'X');
                        int cellScore = minimax(grid, false);
                        grid.updateCell(row, column, ' ');
                        if (cellScore > score) {
                            score = cellScore;
                            finalRow = row;
                            finalColumn = column;
                        }
                    }
                }
            }
        } else {
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    if (grid.isEmpty(row, column)) {
                        grid.updateCell(row, column, 'O');
                        int cellScore = minimax(grid, true);
                        grid.updateCell(row, column, ' ');
                        if (cellScore < score) {
                            score = cellScore;
                            finalRow = row;
                            finalColumn = column;
                        }
                    }
                }
            }

        }
        grid.updateCell(finalRow, finalColumn, grid.getCurrentPlayerSign());
    }

    private int minimax(Grid grid, boolean isMaximizer) {
        if (grid.getStatus() == ResultStrings.X_WINS) {
            return 1;
        } else if (grid.getStatus() == ResultStrings.O_WINS) {
            return -1;
        } else if (grid.getStatus() == ResultStrings.DRAW) {
            return 0;
        }
        int score = isMaximizer ? -1000 : 1000;

        if (isMaximizer) {

            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    if (grid.isEmpty(row, column)) {
                        grid.updateCell(row, column, grid.getCurrentPlayerSign());
                        int cellScore = minimax(grid, false);
                        score = Math.max(score, cellScore);
                        grid.updateCell(row, column, ' ');
                    }
                }
            }
            return score;
        } else {
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    if (grid.isEmpty(row, column)) {
                        grid.updateCell(row, column, grid.getCurrentPlayerSign());
                        int cellScore = minimax(grid, true);
                        score = Math.min(score, cellScore);
                        grid.updateCell(row, column, ' ');
                    }
                }
            }
        }
        return score;
    }
}
