package TicTacToe.Model;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }


    public boolean addPiece(int row, int col, PlayingPiece piece){
        if(board[row][col] != null){
            return false;
        }
        board[row][col] = piece;
        return true;
    }

    public List<SimpleEntry<Integer, Integer>> getFreeCells(){
        List<SimpleEntry<Integer, Integer>> freeCells = new ArrayList<>();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] == null){
                    freeCells.add(new SimpleEntry<>(i, j));
                }
            }
        }
        return freeCells;
    }

    public void printBoard(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] == null){
                    System.out.print("_ ");
                } else {
                    System.out.print(board[i][j].pieceType + " ");
                }
            }
            System.out.println();
        }
    }
}
