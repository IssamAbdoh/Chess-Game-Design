package boards;

import colours.Colour;
import pieces.*;

import java.util.Objects;

public class ChessBoard8x8 extends ChessBoardSquare
{
    public ChessBoard8x8(int board_size)
    {
        super( board_size , board_size );
        setBoard();
    }
    
    @Override
    public void setBoard()
    {
        for(int i = 0 ; i < rows ; i++)
        {
            for(int j = 0 ; j < columns ; j++)
            {
                board[i][j] = null;
            }
        }
        
        board[0][0] = new Rook( Colour.WHITE );
        board[0][1] = new Knight( Colour.WHITE );
        board[0][2] = new Bishop( Colour.WHITE );
        board[0][3] = new Queen( Colour.WHITE );
        board[0][4] = new King( Colour.WHITE );
        board[0][5] = new Bishop( Colour.WHITE );
        board[0][6] = new Knight( Colour.WHITE );
        board[0][7] = new Rook( Colour.WHITE );
        
        for(int i = 0 ; i < columns ; i++)
        {
            board[1][i] = new Pawn( Colour.WHITE );
        }
        
        for(int i = 0 ; i < columns ; i++)
        {
            board[6][i] = new Pawn( Colour.BLACK );
        }
        
        board[7][0] = new Rook( Colour.BLACK );
        board[7][1] = new Knight( Colour.BLACK );
        board[7][2] = new Bishop( Colour.BLACK );
        board[7][3] = new Queen( Colour.BLACK );
        board[7][4] = new King( Colour.BLACK );
        board[7][5] = new Bishop( Colour.BLACK );
        board[7][6] = new Knight( Colour.BLACK );
        board[7][7] = new Rook( Colour.BLACK );
    }
    
    public void move(int x1 , int y1 , int x2 , int y2)
    {
        Piece p = board[x1][y1];
        board[x2][y2] = p;
        board[x1][y1] = null;
    }
    
    @Override
    public void printBoard()
    {
        //print the board with letters and numbers
        System.out.println( "\n" );
        for(int i = rows - 1 ; i >= 0 ; i--)
        {
            System.out.print( i + 1 + " " );
            for(int j = 0 ; j < columns ; j++)
            {
                if(board[i][j] == null)
                {
                    System.out.print( "---- " );
                    
                }
                else
                {
                    //print only four characters from the piece name
                    System.out.print( board[i][j].getType().toString().substring( 0 , 4 ) + " " );
                }
            }
            System.out.println( "\n" );
        }
        
        //print the letters
        System.out.print( "  " );
        for(int i = 1 ; i <= columns ; i++)
        {
            System.out.print( "  " + (char) (i + 64) + "  " );
            
        }
        System.out.println( "\n" );
    }
    
    @Override
    public boolean isCheckMate(Colour c)
    {
        return false;
    }
    
    @Override
    public boolean isKingAlive(Colour c)
    {
        //check if the king is alive
        for(int i = 0 ; i < rows ; i++)
        {
            for(int j = 0 ; j < columns ; j++)
            {
                if(board[i][j] != null)
                {
                    if(Objects.equals( board[i][j].getType() , PieceType.KING ) && board[i][j].getColour() == c)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
