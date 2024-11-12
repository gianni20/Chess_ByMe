package ija2.xromang00;


public class Horse extends Piece{
        
    public Horse(int x, int y, boolean isWhite, ChessBoard board) {
        super(x, y, isWhite, board);
    }


    @Override
    public boolean isLegalMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        return Math.abs(endX - startX) == 2 && Math.abs(endY - startY) == 1 || Math.abs(endX - startX) == 1 && Math.abs(endY - startY) == 2;
    }
    

    @Override
    public boolean MoveTo(int startX, int startY, int endX, int endY, ChessBoard board) {
        if (isLegalMove(startX, startY, endX, endY, board)) {
            Piece destinationPiece = board.getPieceAt(endX, endY);
            if (destinationPiece != null && destinationPiece.isWhite() != this.isWhite()) {
                board.removePiece(destinationPiece);
            }
            this.position[0] = endX;
            this.position[1] = endY;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return isWhite() ? "NW" : "NB";
    }

}
