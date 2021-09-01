package boardgame;

public abstract class Piece {

    protected Position position; //This position is only for internal logic. It is a matrix position.
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null; //The position value of new pieces is null. That means that the piece is not into the board yet.

    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove(){
        boolean[][] mat = possibleMoves();
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat.length; j++){
                if(mat[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

}
