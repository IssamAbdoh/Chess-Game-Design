package game;

import boards.ChessBoard8x8;
import colours.Colour;
import player.ChessPlayer;
import rules.ClassicSpecialMoves;

public class ChessGame implements IChessGame
{
    ChessPlayer player1;
    ChessPlayer player2;
    ChessBoard8x8 board;
    Colour next_turn;
    ClassicSpecialMoves classicSpecialMoves = new ClassicSpecialMoves();
    
    public ChessGame(String white_player_name , String black_player_name)
    {
        player1 = new ChessPlayer( Colour.WHITE , white_player_name );
        player2 = new ChessPlayer( Colour.BLACK , black_player_name );
        board = new ChessBoard8x8( 8 );
        nextTurn();
    }
    
    @Override
    public boolean isDone()
    {
        return !board.isKingAlive( Colour.WHITE ) || !board.isKingAlive( Colour.BLACK );
    }
    
    @Override
    public boolean isWhiteTurn()
    {
        return next_turn == Colour.WHITE;
    }
    
    @Override
    public boolean isBlackTurn()
    {
        return next_turn == Colour.BLACK;
    }
    
    @Override
    public void playWhite(String move)
    {
        //check if the white has a checkmate
        if(board.isCheckMate( Colour.WHITE ))
        {
            System.out.println( "White has a checkmate !" );
            return;
        }
        int[] move_coordinates = parseMove( move );
        if(!isLegalMove( move_coordinates , Colour.WHITE ))
        {
            return;
        }
        move( move_coordinates[0] , move_coordinates[1] , move_coordinates[2] , move_coordinates[3] );
    }
    
    @Override
    public void playBlack(String move)
    {
        //check if the black has a checkmate
        if(board.isCheckMate( Colour.BLACK ))
        {
            System.out.println( "Black has a checkmate !" );
            return;
        }
        int[] move_coordinates = parseMove( move );
        if(!isLegalMove( move_coordinates , Colour.BLACK ))
        {
            return;
        }
        move( move_coordinates[0] , move_coordinates[1] , move_coordinates[2] , move_coordinates[3] );
    }
    
    @Override
    public void printWinnerName()
    {
        if(!board.isKingAlive( Colour.WHITE ))
        {
            System.out.println( "Black wins !" );
            System.out.println( "Congratulation " + player2.getName() + " !" );
        }
        else if(!board.isKingAlive( Colour.BLACK ))
        {
            System.out.println( "White wins !" );
            System.out.println( "Congratulation " + player1.getName() + " !" );
        }
    }
    
    private int[] parseMove(String move)
    {
        int[] result = new int[4];
        String[] move_coordinates = move.split( " " );
        result[0] = move_coordinates[1].charAt( 1 ) - '1';
        result[1] = move_coordinates[1].toUpperCase().charAt( 0 ) - 'A';
        result[2] = move_coordinates[2].charAt( 1 ) - '1';
        result[3] = move_coordinates[2].toUpperCase().charAt( 0 ) - 'A';
        
        return result;
    }
    
    private boolean isLegalMove(int[] move , Colour colour)
    {
        //check if there is a piece at the start position
        if(board.getPiece( move[0] , move[1] ) == null)
        {
            System.out.println( "No piece at start position !" );
            return false;
        }
        
        //check if the piece is white
        Colour x = board.getPiece( move[0] , move[1] ).getColour();
        if(x != colour)
        {
            System.out.println( board.getPiece( move[0] , move[1] ).getColour() );
            System.out.println( "Not " + colour + " piece !" );
            return false;
        }
        
        //check if the destination is not the same colour
        if(board.getPiece( move[2] , move[3] ) != null && board.getPiece( move[2] , move[3] ).getColour() == colour)
        {
            System.out.println( "You cannot kill a comrade !" );
            return false;
        }
        
        //check if the destination is the same as the start position
        if(move[0] == move[2] && move[1] == move[3])
        {
            System.out.println( "You cannot move to the same position !" );
            return false;
        }
        
        //check if the piece can move to the end position
        return isAbleToBeMoved( move );
    }
    
    private boolean isAbleToBeMoved(int[] move)
    {
        if(!board.getPiece( move[0] , move[1] ).isAbleToMove( move[0] , move[1] , move[2] , move[3] , board ))
        {
            System.out.println( board.getPiece( move[0] , move[1] ).getType() + " can't move to end position !" );
            return false;
        }
        
        return true;
    }
    
    private void move(int x1 , int y1 , int x2 , int y2)
    {
        //check if the move is a special move
        if(classicSpecialMoves.isSpecialMove( board , x1 , y1 , x2 , y2 ))
        {
            classicSpecialMoves.performSpecialMove( board , x1 , y1 , x2 , y2 );
        }
        else
        {
            board.move( x1 , y1 , x2 , y2 );
        }
        nextTurn();
    }
    
    private void nextTurn()
    {
        board.printBoard();
        if(next_turn == null || next_turn == Colour.BLACK)
        {
            next_turn = Colour.WHITE;
        }
        else
        {
            next_turn = Colour.BLACK;
        }
        System.out.println( "Now is " + next_turn + " turn " );
    }
}
