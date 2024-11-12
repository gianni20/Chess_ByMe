
package ija2.xromang00;

public class Rook extends Piece {

    public Rook(int x, int y, boolean isWhite, ChessBoard board) {
        super(x, y, isWhite, board);
    }

    @Override
    public boolean isLegalMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        if (startX != endX && startY != endY)
            return false;
        
        Piece destinationPiece = board.getPieceAt(endX, endY);
        if (destinationPiece != null && destinationPiece.isWhite() == this.isWhite())
            return false;
        
        int directionX = Integer.signum(endX - startX);
        int directionY = Integer.signum(endY - startY);
        int x = startX + directionX;
        int y = startY + directionY;
        while (x != endX || y != endY) {
            if (board.getPieceAt(x, y) != null)
                return false;

            x += directionX;
            y += directionY;
        }
        
        return true;
    }
    

    @Override
    public boolean MoveTo(int startX, int startY, int endX, int endY, ChessBoard board) {
        if (isLegalMove(startX, startY, endX, endY, board)) {
            Piece destinationPiece = board.getPieceAt(endX, endY);
            if (destinationPiece != null && destinationPiece.isWhite() != this.isWhite())
                board.removePiece(destinationPiece);
            
            this.position[0] = endX;
            this.position[1] = endY;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return isWhite() ? "RW" : "RB";
    }

}
