package tictactoe;

public class Context {
    final IMoveStrategy strategy;

    public Context(IMoveStrategy strategy) {
        this.strategy = strategy;
    }

    public void move(Grid grid) {
        strategy.move(grid);
    }
}
