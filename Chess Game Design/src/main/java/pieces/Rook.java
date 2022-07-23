package pieces;

import boards.ChessBoard8x8;
import colours.Colour;

public class Rook extends Piece
{
    public Rook(Colour colour)
    {
        super( colour );
        this.type = PieceType.ROOK;
    }
    
    @Override
    public boolean isAbleToMove(int x1 , int y1 , int x2 , int y2 , ChessBoard8x8 board)
    {
        return true;
    }
}
