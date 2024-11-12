package ija2.xromang00;


public class Queen extends Piece {

    public Queen(int x, int y, boolean isWhite, ChessBoard board) {
        super(x, y, isWhite, board);
    }

    @Override
    public boolean isLegalMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        Piece destinationPiece = board.getPieceAt(endX, endY);
        if (destinationPiece != null && destinationPiece.isWhite() == this.isWhite()) {
            return false;
        }
        if (Math.abs(endX - startX) == Math.abs(endY - startY) || startX == endX || startY == endY) {
            return isPathClear(startX, startY, endX, endY, board);
        }
        return false;
    }

    private boolean isPathClear(int startX, int startY, int endX, int endY, ChessBoard board) {
        int xDirection = Integer.signum(endX - startX);
        int yDirection = Integer.signum(endY - startY);

        int x = startX + xDirection;
        int y = startY + yDirection;

        while (x != endX || y != endY) {
            if (board.getPieceAt(x, y) != null)
                return false;
                
            x += xDirection;
            y += yDirection;
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
        return isWhite() ? "QW" : "QB";
    }

}
