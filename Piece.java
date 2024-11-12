package ija2.xromang00;


public abstract class Piece {
    protected final int[] position;
    protected final boolean isWhite;
    protected final ChessBoard board;

    public Piece(int x, int y, boolean isWhite, ChessBoard board) {
        this.position = new int[]{x, y};
        this.isWhite = isWhite;
        this.board = board;
    }

    public int[] getPosition() {
        return position;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public abstract boolean isLegalMove(int startX, int startY, int endX, int endY, ChessBoard board);
    
    public abstract boolean MoveTo(int startX, int startY, int endX, int endY, ChessBoard board);

    @Override
    public abstract String toString();
}
