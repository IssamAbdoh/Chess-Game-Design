package game;

public interface IChessGame
{
    boolean isDone();
    boolean isWhiteTurn();
    boolean isBlackTurn();
    void playWhite(String move);
    void playBlack(String move);
    void printWinnerName();
}
