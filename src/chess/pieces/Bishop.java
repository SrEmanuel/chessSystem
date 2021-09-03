package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "B";
    }

    private void checkLastPositionMark(boolean[][] mat, Position p){
        /* if the upper condition was false, it'll go out of the while and test if that last position exists and if there is an opponent piece
        if that condition is true it'll mark the position free to go as well */
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p =  new Position(0,0);

        /* nw - it is verifying first if the position above exists and if there isn't a piece there.
           if the condition is true, it ll mark that position as true (free to go) */
        p.setValues(position.getRow() - 1 , position.getColumn() - 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()-1, p.getColumn()-1);
        }

        checkLastPositionMark(mat, p);

        // ne
        p.setValues(position.getRow() -1, position.getColumn() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()-1, p.getColumn()+1);
        }

        checkLastPositionMark(mat, p);


        // se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()+1, p.getColumn()+1);
        }

        checkLastPositionMark(mat, p);

        // sw
        p.setValues(position.getRow() + 1 , position.getColumn() -2);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()+1, p.getColumn()-1);
        }
        checkLastPositionMark(mat, p);

        return mat;
    }
}
