package pieces;

import boards.ChessBoard8x8;
import colours.Colour;

public class King extends Piece
{
    public King(Colour colour)
    {
        super( colour );
        this.type = PieceType.KING;
    }
    
    @Override
    public boolean isAbleToMove(int x1 , int y1 , int x2 , int y2 , ChessBoard8x8 board)
    {
        return true;
    }
}
