package ija2.xromang00;

public class Pawn extends Piece {

    public Pawn(int x, int y, boolean isWhite, ChessBoard board) {
        super(x, y, isWhite, board);
    }

    public boolean canEat(ChessBoard board) {
        return (board.getPieceAt(this.position[0] + 1, this.position[1] + 1) != null && board.getPieceAt(this.position[0] + 1, this.position[1] + 1).isWhite() != this.isWhite()) ||
               (board.getPieceAt(this.position[0] - 1, this.position[1] + 1) != null && board.getPieceAt(this.position[0] - 1, this.position[1] + 1).isWhite() != this.isWhite());
    }

    @Override
    public boolean isLegalMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        if (startX == endX && Math.abs(startY - endY) <= 2)
            return board.getPieceAt(endX, endY) == null;
        else if (Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 1) {
            Piece destinationPiece = board.getPieceAt(endX, endY);
            return destinationPiece != null && destinationPiece.isWhite() != this.isWhite();
        }
        return false;
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
        return isWhite() ? "PW" : "PB";
    }
}
