package tictactoe;

public class HardAI implements IMoveStrategy {

    private int row = -1;
    private int column = -1;

    @Override
    public void move(Grid grid) {
        //System.out.println("HardAI.move");
        boolean isMaximizer = grid.getCurrentPlayerSign() == 'X';
        int depth = 1;
        minmax(grid, depth, isMaximizer);
        grid.updateCell(row, column, grid.getCurrentPlayerSign());

    }

    private int minmax(Grid grid, int depth, boolean isMaximizer) {
        //grid.print();
        //System.out.println("isMaximizer = " + isMaximizer);
        if(grid.winOf('X')) {
            return 1;
        } else if (grid.winOf('O')) {
            return -1;
        } else if (grid.count('X') == 5) { // Tie
            return 0;
        }
        int minScore = Integer.MAX_VALUE;
        int maxScore = Integer.MIN_VALUE;
        int score = isMaximizer ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.isEmpty(i, j)) {
                    grid.updateCell(i, j, grid.getCurrentPlayerSign());
                    score = minmax(grid, depth + 1, !isMaximizer);
                    //System.out.println("score = " + score);
                    if (isMaximizer) {
                        score = Math.max(score, maxScore);
                        row = i;
                        column = j;
                    } else {
                        score = Math.min(score, minScore);
                        row = i;
                        column = j;
                    }

                    grid.updateCell(i, j, ' ');
                }
            }
        }
        //System.out.println("returning score = " + score);
        //grid.print();
        return score;
    }

}
