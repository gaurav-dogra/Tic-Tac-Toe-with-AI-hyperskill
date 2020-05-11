package tictactoe;

public class MediumAI implements IMoveStrategy {

    @Override
    public void move(Grid grid) {
        System.out.println("Making move level \"medium\"");

        if (singleMoveToWin(grid)) {
            // if a win is possible with one move; do the move
        } else if (blockOtherPlayerWin(grid)) {
            // if opponent is winning in the next move, block it
        } else {
            // otherwise insert a char at random
            while (true) {
                int row = (int) (Math.random() * 3);
                int column = (int) (Math.random() * 3);
                if (grid.isEmpty(row, column)) {
                    grid.changeCell(row, column, grid.getCurrentPlayerSign());
                    break;
                }
            }
        }
    }

    private boolean blockOtherPlayerWin(Grid grid) {
        char ch = grid.getCurrentPlayerSign();
        ch = ch == 'X' ? 'O' : 'X';
        return winPossible(ch, grid);
    }

    private boolean winPossible(char ch, Grid grid) {
        // insert 'X' / 'O' in all empty cells
        // and see if that results in a win
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j <= 2; j++) {
                if (grid.getCellVal(j,i) == ' ') {
                    grid.changeCell(j,i, ch);
                    if (grid.winOf(ch)) {
                        grid.changeCell(j,i,grid.getCurrentPlayerSign());
                        return true;
                    } else {
                        grid.changeCell(j,i, ' ');
                    }
                }
            }
        }
        return false;
    }

    private boolean singleMoveToWin(Grid grid) {
        char ch = grid.getCurrentPlayerSign();
        return winPossible(ch, grid);
    }
}