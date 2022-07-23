package pieces;

import boards.ChessBoard8x8;
import colours.Colour;

public class Bishop extends Piece
{
    public Bishop(Colour colour)
    {
        super( colour );
        this.type = PieceType.BISHOP;
    }
    
    @Override
    public boolean isAbleToMove(int x1 , int y1 , int x2 , int y2 , ChessBoard8x8 board)
    {
        //check if the piece is able to move
        //check if the end move is inside the board
        //check if the end move is empty
        //A LOT OF CHECKS
        return true;
    }
}
