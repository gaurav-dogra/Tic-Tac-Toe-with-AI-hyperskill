package tictactoe;

public class Grid {
    private final Character[][] grid = new Character[3][3];

    public Grid(String input) {
        input = input.replaceAll("_", " ");
        int index = 0;
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j <= 2; j++) {
                grid[j][i] = input.charAt(index);
                index++;
            }
        }
    }

    public void print() {
        System.out.println("---------"); // top border
        for (int i = 2; i >= 0; i--) {
            System.out.print("| ");
            for (int j = 0; j <= 2; j++) {
                System.out.print(grid[j][i] + " ");
            }
            System.out.print(" |\n");

        }
        System.out.println("----------");
    }

    public boolean isEmpty(int coordinateOne, int coordinateTwo) {
        coordinateOne--;
        coordinateTwo--;
        return grid[coordinateOne][coordinateTwo] == ' ';
    }

    public void changeCell(int coordinateOne, int coordinateTwo) {
        coordinateOne--;
        coordinateTwo--;
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
        if (grid[0][2] == x && grid[1][2] == x && grid[2][2] == x) {
            return true;
        }
        if (grid[0][1] == x && grid[1][1] == x && grid[2][1] == x) {
            return true;
        }
        if (grid[0][0] == x && grid[1][0] == x && grid[2][0] == x) {
            return true;
        }
        if (grid[0][2] == x && grid[0][1] == x && grid[0][0] == x) {
            return true;
        }
        if (grid[1][2] == x && grid[1][1] == x && grid[1][0] == x) {
            return true;
        }
        if (grid[2][2] == x && grid[2][1] == x && grid[2][0] == x) {
            return true;
        }
        if (grid[0][2] == x && grid[1][1] == x && grid[2][0] == x) {
            return true;
        }
        if (grid[0][0] == x && grid[1][1] == x && grid[2][2] == x) {
            return true;
        }
        return false;
    }
}
