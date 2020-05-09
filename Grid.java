package tictactoe;

public class Grid {
    private final Character[][] grid = new Character[3][3];

    public Grid() {
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j <= 2; j++) {
                grid[j][i] = ' ';
            }
        }
    }

    public void print() {
        System.out.println("---------"); // top border
        for (int i = 2; i >= 0; i--) {
            System.out.print("| "); // left border
            for (int j = 0; j <= 2; j++) {
                System.out.print(grid[j][i] + " ");
            }
            System.out.print("|\n"); // right border

        }
        System.out.println("---------"); // bottom border
    }

    public boolean isEmpty(int coordinateOne, int coordinateTwo) {
        return grid[coordinateOne][coordinateTwo] == ' ';
    }

    public void changeCell(int coordinateOne, int coordinateTwo) {
        char ch = count('X') == count('O') ? 'X' : 'O';

        grid[coordinateOne][coordinateTwo] = ch;
    }

    private int count(char ch) {
        int count = 0;
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j <= 2; j++) {
                if (grid[j][i] == ch) {
                    count++;
                }
            }
        }
        return count;
    }

    public ResultStrings getStatus() {
        if (winOf('X')) {
            return ResultStrings.X_WINS;
        } else if (winOf('O')) {
            return ResultStrings.O_WINS;
        } else if (count('X') == 5 && count('O') == 4) {
            return ResultStrings.DRAW;
        } else {
            return ResultStrings.GAME_NOT_FINISHED;
        }
    }

    private boolean winOf(char x) {
        if (grid[0][2] == x && grid[1][2] == x && grid[2][2] == x) { // first row
            return true;
        }
        if (grid[0][1] == x && grid[1][1] == x && grid[2][1] == x) { // second row
            return true;
        }
        if (grid[0][0] == x && grid[1][0] == x && grid[2][0] == x) { // third row
            return true;
        }
        if (grid[0][2] == x && grid[0][1] == x && grid[0][0] == x) { // first column
            return true;
        }
        if (grid[1][2] == x && grid[1][1] == x && grid[1][0] == x) { // second column
            return true;
        }
        if (grid[2][2] == x && grid[2][1] == x && grid[2][0] == x) { // third column
            return true;
        }
        if (grid[0][2] == x && grid[1][1] == x && grid[2][0] == x) { // left -> right diagonal
            return true;
        }
        if (grid[0][0] == x && grid[1][1] == x && grid[2][2] == x) { // right -> left diagonal
            return true;
        }
        return false;
    }
}
