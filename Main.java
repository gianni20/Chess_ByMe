package ija2.xromang00;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessBoard chessBoard = new ChessBoard(8);
        chessBoard.print();

        System.out.print("Your next move: ");
        String move = scanner.nextLine();

        while(!"quit".equalsIgnoreCase(move)){
            if (move.length() != 4)
                System.out.println("Invalid format");
            else
                chessBoard.Move(move);
            System.out.print("Your next move: ");
            move = scanner.nextLine();
        }
        scanner.close();        
    }
}
