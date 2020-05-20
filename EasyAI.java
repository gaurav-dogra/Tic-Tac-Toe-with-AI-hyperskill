package tictactoe;

public class EasyAI implements IMoveStrategy {
    @Override
    public void move(Grid grid) {
        System.out.println("Making move level \"easy\"");
        while (true) {
            int row = (int) (Math.random() * 3);
            int column = (int) (Math.random() * 3);
            if (grid.isEmpty(row, column)) {
                grid.updateCell(row, column, grid.getCurrentPlayerSign());
                break;
            }
        }
    }
}
