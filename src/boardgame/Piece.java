package boardgame;

public class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null; //The position value of new pieces is null. That means that the piece is not into the board yet.

    }

    protected Board getBoard() {
        return board;
    }

}
