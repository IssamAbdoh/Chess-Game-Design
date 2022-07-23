package pieces;

import boards.ChessBoard8x8;
import colours.Colour;

public class Queen extends Piece
{
    public Queen(Colour colour)
    {
        super( colour );
        this.type= PieceType.QUEEN;
    }
    
    @Override
    public boolean isAbleToMove(int x1 , int y1 , int x2 , int y2 , ChessBoard8x8 board)
    {
        return true;
    }
}
