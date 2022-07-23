package boards;

import colours.Colour;

public interface ChessBoard
{
    void setBoard();
    void printBoard();
    boolean isCheckMate(Colour c);
    boolean isKingAlive(Colour c);
}
