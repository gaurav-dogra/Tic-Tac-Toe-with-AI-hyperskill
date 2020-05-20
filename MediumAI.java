package tictactoe;

public class MediumAI implements IMoveStrategy {

    @Override
    public void move(Grid grid) {
        System.out.println("Making move level \"medium\"");
        char player = grid.getCurrentPlayerSign();
        if (singleMoveToWin(grid, true)) {
            return; // current player has done the winning move
        } else if (singleMoveToWin(grid, false)) {
            return; // current player has blocked opponent's win
        }

        // otherwise insert at random
        while (true) {
            int row = (int) (Math.random() * 3);
            int column = (int) (Math.random() * 3);
            if (grid.isEmpty(row, column)) {
                grid.updateCell(row, column, player);
                break;
            }
        }

    }

    private boolean singleMoveToWin(Grid grid, boolean currentPlayer) {
        // insert 'X' / 'O' in all empty cells
        // and see if that results in a win
        char currentPlayerSign = grid.getCurrentPlayerSign();
        char checkingFor;
        if (currentPlayer) {
            checkingFor = grid.getCurrentPlayerSign();
        } else {
            checkingFor = grid.getCurrentPlayerSign() == 'X' ? 'O' : 'X';
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (grid.isEmpty(i, j)) {
                    grid.updateCell(i, j, checkingFor);
                    if (grid.winOf(checkingFor)) {
                        grid.updateCell(i, j, currentPlayerSign);
                        return true;
                    } else {
                        grid.updateCell(i, j, ' ');
                    }
                }
            }
        }
        return false;
    }

}