import game.ChessGame;

import java.util.Scanner;

public class ChessGameTest
{
    public static void main(String[] args)
    {
        ChessGame game = new ChessGame( "Fahed" , "Essam" );
        
        while(!game.isDone())
        {
            String move = read_move_from_console();//"move A1 H8"
            if(game.isWhiteTurn())
            {
                game.playWhite( move );
            }
            else
            {
                game.playBlack( move );
            }
        }
        game.printWinnerName();
    }
    
    private static String read_move_from_console()
    {
        Scanner scanner = new Scanner( System.in );
        String move;
        do
        {
            System.out.println( "Enter move : " );
            move = scanner.nextLine();
            
            if(!isValidMove( move ))
            {
                System.out.println( "Invalid move format ! , the format should be \"move A1 B2\"" );
            }
            else
            {
                break;
            }
        }
        while(true);
        return move;
    }
    
    private static boolean isValidMove(String move)
    {
        //check if the move in the format of "move A1 B2"
        String[] parts = move.split( " " );
        if(parts.length != 3)
        {
            return false;
        }
        if(!parts[0].equalsIgnoreCase( "move" ))
        {
            return false;
        }
        if(!isValidPosition( parts[1] ))
        {
            return false;
        }
        if(!isValidPosition( parts[2] ))
        {
            return false;
        }
        return true;
    }
    
    private static boolean isValidPosition(String position)
    {
        if(position.length() != 2)
        {
            return false;
        }
        if(!Character.isLetter( position.charAt( 0 ) ))
        {
            return false;
        }
        if(!Character.isDigit( position.charAt( 1 ) ))
        {
            return false;
        }
        
        //check if the position is in the board
        if(position.toUpperCase().charAt( 0 ) < 'A' || position.toUpperCase().charAt( 0 ) > 'H')
        {
            return false;
        }
        if(position.charAt( 1 ) < '1' || position.charAt( 1 ) > '8')
        {
            return false;
        }
        
        return true;
    }
}
