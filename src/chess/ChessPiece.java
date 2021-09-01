package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public ChessPosition getChessPosition (){
        return ChessPosition.fromPosition(position); //That converts a simple matrix position (that is only for internal logic)
                                                    // into readble normal Chess Positions
    }

    public Color getColor() {
        return color;
    }

    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
}
