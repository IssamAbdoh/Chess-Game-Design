package rules;

import boards.ChessBoardSquare;
import colours.Colour;
import pieces.PieceType;

import java.util.Scanner;

public final class ClassicSpecialMoves implements SpecialMoves
{
    private static final Scanner input = new Scanner( System.in );
    
    @Override
    public boolean isSpecialMove(ChessBoardSquare board , int x1 , int y1 , int x2 , int y2)
    {
        return isCastling( board , x1 , y1 , x2 , y2 ) || isEnPassant( board , x1 , y1 , x2 , y2 ) || isPromotion( board , x1 , y1 , x2 , y2 );
    }
    
    @Override
    public void performSpecialMove(ChessBoardSquare board , int x1 , int y1 , int x2 , int y2)
    {
        if(isCastling( board , x1 , y1 , x2 , y2 ))
        {
            castling( board , x1 , y1 , x2 , y2 );
        }
        else if(isEnPassant( board , x1 , y1 , x2 , y2 ))
        {
            enPassant( board , x1 , y1 , x2 , y2 );
        }
        else if(isPromotion( board , x1 , y1 , x2 , y2 ))
        {
            promote( board , x1 , y1 , x2 , y2 );
        }
    }
    
    private static boolean isEnPassant(ChessBoardSquare board , int x1 , int y1 , int x2 , int y2)
    {
        //check if the move is en passant
        if(board.getPiece( x1 , y1 ).getType() == PieceType.PAWN)
        {
            if(board.getPiece( x1 , y1 ).getColour() == Colour.WHITE)
            {
                if(x1 + 1 == x2 && (y1 - 1 == y2 || y1 + 1 == y2))
                {
                    if(y1 - 1 == y2)
                    {
                        if(y1 - 1 >= 0)
                        {
                            if(board.getPiece( x1 , y1 - 1 ).getType() == PieceType.PAWN)
                            {
                                System.out.println( "En passant !" );
                                return true;
                            }
                        }
                    }
                    else if(y1 + 1 == y2)
                    {
                        if(y1 + 1 <= 7)
                        {
                            if(board.getPiece( x1 , y1 + 1 ).getType() == PieceType.PAWN)
                            {
                                System.out.println( "En passant !" );
                                return true;
                            }
                        }
                    }
                }
            }
            else if(board.getPiece( x1 , y1 ).getColour() == Colour.BLACK)
            {
                if(x1 - 1 == x2 && (y1 - 1 == y2 || y1 + 1 == y2))
                {
                    if(y1 - 1 == y2)
                    {
                        if(y1 - 1 >= 0)
                        {
                            if(board.getPiece( x1 , y1 - 1 ).getType() == PieceType.PAWN)
                            {
                                System.out.println( "En passant !" );
                                return true;
                            }
                        }
                    }
                    else if(y1 + 1 == y2)
                    {
                        if(y1 + 1 <= 7)
                        {
                            if(board.getPiece( x1 , y1 + 1 ).getType() == PieceType.PAWN)
                            {
                                System.out.println( "En passant !" );
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static boolean isCastling(ChessBoardSquare board , int x1 , int y1 , int x2 , int y2)
    {
        //check if the move is a castling
        if(x1 != x2)
        {
            return false;
        }
        if(board.getPiece( x1 , y1 ).getType() == PieceType.KING)
        {
            if(board.getPiece( x1 , y1 ).getColour() == Colour.WHITE)
            {
                if(x1 == 0)
                {
                    if(y1 == 4)
                    {
                        if(y2 == 6)
                        {
                            if(board.getPiece( x2 , y2 ) == null && board.getPiece( x2 , y2 - 1 ) == null)
                            {
                                if(board.getPiece( x2 , y2 + 1 ).getType() == PieceType.ROOK)
                                {
                                    if(board.getPiece( x2 , y2 + 1 ).getColour() == Colour.WHITE)
                                    {
                                        System.out.println( "Castling !" );
                                        return true;
                                    }
                                }
                            }
                        }
                        else if(y2 == 2)
                        {
                            if(board.getPiece( x2 , y2 - 1 ) == null && board.getPiece( x2 , y1 ) == null && board.getPiece( x2 , y2 + 1 ) == null)
                            {
                                if(board.getPiece( x2 , y2 - 2 ).getType() == PieceType.ROOK)
                                {
                                    if(board.getPiece( x2 , y2 - 2 ).getColour() == Colour.WHITE)
                                    {
                                        System.out.println( "Castling !" );
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if(board.getPiece( x1 , y1 ).getColour() == Colour.BLACK)
            {
                if(x1 == 7)
                {
                    if(y1 == 4)
                    {
                        if(y2 == 6)
                        {
                            if(board.getPiece( x2 , y2 - 1 ) == null && board.getPiece( x2 , y2 ) == null)
                            {
                                if(board.getPiece( x2 , y2 + 1 ).getType() == PieceType.ROOK)
                                {
                                    if(board.getPiece( x2 , y2 + 1 ).getColour() == Colour.BLACK)
                                    {
                                        System.out.println( "Castling !" );
                                        return true;
                                    }
                                }
                            }
                        }
                        else if(y2 == 2)
                        {
                            if(board.getPiece( x2 , y2 - 1 ) == null && board.getPiece( x2 , y2 ) == null && board.getPiece( x2 , y2 + 1 ) == null)
                            {
                                if(board.getPiece( x2 , y2 - 2 ).getType() == PieceType.ROOK)
                                {
                                    if(board.getPiece( x2 , y2 - 2 ).getColour() == Colour.BLACK)
                                    {
                                        System.out.println( "Castling !" );
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private static boolean isPromotion(ChessBoardSquare board , int x1 , int y1 , int x2 , int y2)
    {
        //check if the move is a promotion
        if(board.getPiece( x1 , y1 ).getType() == PieceType.PAWN)
        {
            if(board.getPiece( x1 , y1 ).getColour() == Colour.WHITE)
            {
                return x2 == 7;
            }
            else
            {
                return x2 == 0;
            }
        }
        return false;
    }
    
    private static void enPassant(ChessBoardSquare board , int x1 , int y1 , int x2 , int y2)
    {
        if(!isEnPassant( board , x1 , y1 , x2 , y2 ))
        {
            System.out.println( "Not an en passant move !" );
            return;
        }
        
        //check if the move is en passant
        if(board.getPiece( x1 , y1 ).getType() == PieceType.PAWN)
        {
            if(board.getPiece( x1 , y1 ).getColour() == Colour.WHITE)
            {
                if(x1 + 1 == x2 && (y1 - 1 == y2 || y1 + 1 == y2))
                {
                    if(y1 - 1 == y2)
                    {
                        if(y1 - 1 >= 0)
                        {
                            if(board.getPiece( x1 , y1 - 1 ).getType() == PieceType.PAWN)
                            {
                                System.out.println( "En passant move has been done !" );
                                board.removePiece( x1 , y1 - 1 );
                                board.move( x1 , y1 , x2 , y2 );
                            }
                        }
                    }
                    else if(y1 + 1 == y2)
                    {
                        if(y1 + 1 <= 7)
                        {
                            if(board.getPiece( x1 , y1 + 1 ).getType() == PieceType.PAWN)
                            {
                                System.out.println( "En passant move has been done !" );
                                board.removePiece( x1 , y1 + 1 );
                                board.move( x1 , y1 , x2 , y2 );
                            }
                        }
                    }
                }
            }
            else if(board.getPiece( x1 , y1 ).getColour() == Colour.BLACK)
            {
                if(x1 - 1 == x2 && (y1 - 1 == y2 || y1 + 1 == y2))
                {
                    if(y1 - 1 == y2)
                    {
                        if(y1 - 1 >= 0)
                        {
                            if(board.getPiece( x1 , y1 - 1 ).getType() == PieceType.PAWN)
                            {
                                System.out.println( "En passant move has been done !" );
                                board.removePiece( x1 , y1 - 1 );
                                board.move( x1 , y1 , x2 , y2 );
                            }
                        }
                    }
                    else if(y1 + 1 == y2)
                    {
                        if(y1 + 1 <= 7)
                        {
                            if(board.getPiece( x1 , y1 + 1 ).getType() == PieceType.PAWN)
                            {
                                System.out.println( "En passant move has been done !" );
                                board.removePiece( x1 , y1 + 1 );
                                board.move( x1 , y1 , x2 , y2 );
                            }
                        }
                    }
                }
            }
        }
        return;
    }
    
    private static void castling(ChessBoardSquare board , int x1 , int y1 , int x2 , int y2)
    {
        //check if the move is a castling
        if(!isCastling( board , x1 , y1 , x2 , y2 ))
        {
            System.out.println( "Not a castling move !" );
            return;
        }
        if(board.getPiece( x1 , y1 ).getColour() == Colour.WHITE)
        {
            if(x1 == 0)
            {
                if(y1 == 4)
                {
                    if(y2 == 6)
                    {
                        if(board.getPiece( x2 , y2 ) == null && board.getPiece( x2 , y2 - 1 ) == null)
                        {
                            if(board.getPiece( x2 , y2 + 1 ).getType() == PieceType.ROOK)
                            {
                                if(board.getPiece( x2 , y2 + 1 ).getColour() == Colour.WHITE)
                                {
                                    board.move( x1 , y1 , x2 , y2 );
                                    board.move( x2 , y2 + 1 , x2 , y2 - 1 );
                                    System.out.println( "Castling !" );
                                }
                            }
                        }
                    }
                    else if(y2 == 2)
                    {
                        if(board.getPiece( x2 , y2 - 1 ) == null && board.getPiece( x2 , y1 ) == null && board.getPiece( x2 , y2 + 1 ) == null)
                        {
                            if(board.getPiece( x2 , y2 - 2 ).getType() == PieceType.ROOK)
                            {
                                if(board.getPiece( x2 , y2 - 2 ).getColour() == Colour.WHITE)
                                {
                                    board.move( x1 , y1 , x2 , y2 );
                                    board.move( x2 , y2 - 2 , x2 , y2 + 1 );
                                    System.out.println( "Castling !" );
                                }
                            }
                        }
                    }
                }
            }
        }
        else if(board.getPiece( x1 , y1 ).getColour() == Colour.BLACK)
        {
            if(x1 == 7)
            {
                if(y1 == 4)
                {
                    if(y2 == 6)
                    {
                        if(board.getPiece( x2 , y2 - 1 ) == null && board.getPiece( x2 , y2 ) == null)
                        {
                            if(board.getPiece( x2 , y2 + 1 ).getType() == PieceType.ROOK)
                            {
                                if(board.getPiece( x2 , y2 + 1 ).getColour() == Colour.BLACK)
                                {
                                    board.move( x1 , y1 , x2 , y2 );
                                    board.move( x2 , y2 + 1 , x2 , y2 - 1 );
                                    System.out.println( "Castling !" );
                                }
                            }
                        }
                    }
                    else if(y2 == 2)
                    {
                        if(board.getPiece( x2 , y2 - 1 ) == null && board.getPiece( x2 , y2 ) == null && board.getPiece( x2 , y2 + 1 ) == null)
                        {
                            if(board.getPiece( x2 , y2 - 2 ).getType() == PieceType.ROOK)
                            {
                                if(board.getPiece( x2 , y2 - 2 ).getColour() == Colour.BLACK)
                                {
                                    board.move( x1 , y1 , x2 , y2 );
                                    board.move( x2 , y2 - 2 , x2 , y2 + 1 );
                                    System.out.println( "Castling !" );
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private static void promote(ChessBoardSquare board , int x1 , int y1 , int x2 , int y2)
    {
        //check if the move is a promotion
        if(!isPromotion( board , x1 , y1 , x2 , y2 ))
        {
            System.out.println( "Not a promotion !" );
            return;
        }
        
        if(board.getPiece( x1 , y1 ).getType() == PieceType.PAWN && (x2 == 0 || x2 == 7))
        {
            //promotion move
            //take input from the user to determine the promotion
            while(true)
            {
                System.out.println( "Enter the piece you want to promote to: " );
                System.out.println( "1. Queen" );
                System.out.println( "2. Rook" );
                System.out.println( "3. Bishop" );
                System.out.println( "4. Knight" );
                int choice = input.nextInt();
                switch(choice)
                {
                    case 1 -> board.getPiece( x1 , y1 ).setType( PieceType.QUEEN );
                    case 2 -> board.getPiece( x1 , y1 ).setType( PieceType.ROOK );
                    case 3 -> board.getPiece( x1 , y1 ).setType( PieceType.BISHOP );
                    case 4 -> board.getPiece( x1 , y1 ).setType( PieceType.KNIGHT );
                    default -> System.out.println( "Invalid input !" );
                }
                if(choice >= 1 && choice <= 4)
                {
                    board.move( x1 , y1 , x2 , y2 );
                    System.out.println( "Promotion !" );
                    return;
                }
                System.out.println( "Invalid input !" );
            }
        }
        return;
    }
}
