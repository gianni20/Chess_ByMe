package ija2.xromang00;


public class ChessBoard {
    private final int dim;

    Bishop bb0 = new Bishop(3, 8, false, this);
    Bishop bb1 = new Bishop(6, 8, false, this);
    Bishop wb0 = new Bishop(3, 1, true, this);
    Bishop wb1 = new Bishop(6, 1, true, this);

    Queen wq = new Queen(4, 1, true, this);
    Queen bq = new Queen(4, 8, false, this);

    Rook wr0 = new Rook(1, 1, true, this);
    Rook wr1 = new Rook(8, 1, true, this);
    Rook br0 = new Rook(1, 8, false, this);
    Rook br1 = new Rook(8, 8, false, this);

    King wk = new King(5, 1, true, this);
    King bk = new King(5, 8, false, this);

    Horse wh0 = new Horse(2, 1, true, this);
    Horse wh1 = new Horse(7, 1, true, this);
    Horse bh0 = new Horse(2, 8, false, this);
    Horse bh1 = new Horse(7, 8, false, this);

    Pawn wp1 = new Pawn(1, 2, true, this);
    Pawn wp2 = new Pawn(2, 2, true, this);
    Pawn wp3 = new Pawn(3, 2, true, this);
    Pawn wp4 = new Pawn(4, 2, true, this);
    Pawn wp5 = new Pawn(5, 2, true, this);
    Pawn wp6 = new Pawn(6, 2, true, this);
    Pawn wp7 = new Pawn(7, 2, true, this);
    Pawn wp8 = new Pawn(8, 2, true, this);
    Pawn bp1 = new Pawn(1, 7, false, this);
    Pawn bp2 = new Pawn(2, 7, false, this);
    Pawn bp3 = new Pawn(3, 7, false, this);
    Pawn bp4 = new Pawn(4, 7, false, this);
    Pawn bp5 = new Pawn(5, 7, false, this);
    Pawn bp6 = new Pawn(6, 7, false, this);
    Pawn bp7 = new Pawn(7, 7, false, this);
    Pawn bp8 = new Pawn(8, 7, false, this);

    
    Piece[] pieces = {bb0, bb1, wb0, wb1, wq, bq, wr0, wr1, br0, br1, wk, bk, wh0, wh1, bh0, bh1, 
        wp1, wp2, wp3, wp4, wp5, wp6, wp7, wp8, bp1, bp2, bp3, bp4, bp5, bp6, bp7, bp8};

    public ChessBoard(int dim) {
        this.dim = dim;
    }

    public void print(){
        for (int r = dim; r >= 1; r--){
            for (int c = 1; c <= dim; c++){
                Piece piece = getPieceAt(c, r);
                if(piece != null) System.out.print(piece.toString() + " ");
                else System.out.print(" . ");
            }
            System.out.print('\n');
        }
    }


    public Piece getPieceAt(int x, int y){
        for (Piece piece : pieces) {
            int[] tmp = piece.getPosition();
            if(tmp[0] == x && tmp[1] == y) return piece;
        }
        return null;
    }


    public void Move(String move){
        String[] tmpStr = move.split("");
        int[] tmp = new int[4];
        
        for (int i = 0; i < tmpStr.length; i++) {
            switch (tmpStr[i]) {
                case "a":
                    tmp[i] = 1;
                    break;
                case "b":
                    tmp[i] = 2;
                    break;
                case "c":
                    tmp[i] = 3;
                    break;
                case "d":
                    tmp[i] = 4;
                    break;
                case "e":  
                    tmp[i] = 5;
                    break;
                case "f":
                    tmp[i] = 6;
                    break;
                case "g":
                    tmp[i] = 7;
                    break;
                case "h":
                    tmp[i] = 8;
                    break;
                default:
                    try {
                        tmp[i] = Integer.parseInt(tmpStr[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                        return;
                    }
                    break;
            }
        }
    
        int[] from = {tmp[0], tmp[1]};
        int[] to = {tmp[2], tmp[3]};
        /*System.out.println("From: " + from[0] + " " + from[1]);
        System.out.println("To: " + to[0] + " " + to[1]);*/
        if (getPieceAt(from[0], from[1]) != null && getPieceAt(from[0], from[1]).MoveTo(from[0], from[1], to[0], to[1], this))
            System.out.println("Ok");
        else{
            System.out.println("FAILED");
            System.out.println("Invalid move");
        }
        print();
    }

    public void removePiece(Piece piece){
        if(piece != null){
            piece.position[0] = -1;
            piece.position[1] = -1;
        }
    }
}
