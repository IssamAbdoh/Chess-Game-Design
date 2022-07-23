package pieces;

import boards.ChessBoard8x8;
import colours.Colour;

public abstract class Piece
{
    Colour colour;
    PieceType type;
    
    public Piece(Colour colour)
    {
        this.colour = colour;
    }
    
    public PieceType getType()
    {
        return type;
    }
    
    public void setType(PieceType type)
    {
        this.type = type;
    }
    
    public Colour getColour()
    {
        return colour;
    }
    
    public abstract boolean isAbleToMove(int x1 , int y1 , int x2 , int y2 , ChessBoard8x8 board);
}
