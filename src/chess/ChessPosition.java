package chess;

import boardgame.Position;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if(column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("Error instantiating ChessPosition. valid values are from a1 to h8");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    //That method below receives a normal chess position (ex b, 6)
    // and converts it into a Matrix position (ex: 2, 1) to place a piece into the board.
    protected Position toPosition(){
        return new Position(8 - row, column - 'a'); //Column - 'a' is to get de distance between the column letter informed and the initial letter a with unicode subtraction.
                                                                //ex: column = 'b' -> ('b' - 'a') -> 1
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString(){
        return "" + column + row; //That "" is to force the concatenation of strings



    }

}
