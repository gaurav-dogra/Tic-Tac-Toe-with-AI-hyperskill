package tictactoe;

public enum ResultStrings {
    X_WINS("X wins"), O_WINS("O wins"), DRAW("Draw"),
    GAME_NOT_FINISHED("Game not finished");

    private final String stringValue;

    ResultStrings(final String s) {
        stringValue = s;
    }

    public String toString() {
        return stringValue;
    }
}

