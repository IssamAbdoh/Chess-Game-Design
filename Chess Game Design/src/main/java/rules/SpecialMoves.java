package rules;

import boards.ChessBoardSquare;

public interface SpecialMoves
{
    void performSpecialMove(ChessBoardSquare board , int x1 , int y1 , int x2 , int y2);
    boolean isSpecialMove(ChessBoardSquare board , int x1 , int y1 , int x2 , int y2);
}
