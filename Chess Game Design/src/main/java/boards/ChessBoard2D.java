package boards;

import pieces.Piece;

public abstract class ChessBoard2D implements ChessBoard
{
    int rows;
    int columns;
    Piece[][] board;
    
    public ChessBoard2D(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        board = new Piece[rows][columns];
    }
    
    public int getRows()
    {
        return rows;
    }
    
    public int getColumns()
    {
        return columns;
    }
    
    public int getBoardSize()
    {
        return rows;
    }
    
    public Piece getPiece(int x , int y)
    {
        return board[x][y];
    }
    
    abstract public void move(int x1 , int y1 , int x2 , int y2);
    
    public void removePiece(int x , int y)
    {
        //remove a piece from the board
        board[x][y] = null;
    }
}
