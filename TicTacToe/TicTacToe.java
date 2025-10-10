package TicTacToe;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

import TicTacToe.Model.*;


public class TicTacToe {
    Deque<Player> players;
    Board board;

    public TicTacToe(){
        initializeGame();
    }

    public void initializeGame(){
        players = new LinkedList<>();
        PieceX playerx = new PieceX();
        Player p1 = new Player(playerx, "Player 1");

        PieceO playero = new PieceO();
        Player p2 = new Player(playero, "Player 2");

        players.add(p1);
        players.add(p2);

        board = new Board(3);
    }

    public String startGame(){
        
        boolean noWinner = true;

        while (noWinner) {
            Player playerTurn = players.removeFirst();

            board.printBoard(); 
            List<SimpleEntry<Integer, Integer>> freeSpace = board.getFreeCells();
            

            if(freeSpace.isEmpty()){
                noWinner = false;
                continue;
            }

            System.out.println("Player: "+  playerTurn.getName() + " Enter row, col to place piece: ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[] values = s.split(",");

            int inputRow = Integer.valueOf(values[0]);
            int inputCol = Integer.valueOf(values[1]);

            boolean pieceAddedSuccessfully = board.addPiece(inputRow, inputCol, playerTurn.playingPiece);
            if(!pieceAddedSuccessfully){
                System.out.println("Invalid position, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean isWinner = isThereWinner(inputRow, inputCol, playerTurn.playingPiece.pieceType);
            if(isWinner){
                return playerTurn.name;
            }

        }
        return "Tie";
    }

    public boolean isThereWinner(int row, int col, PieceType pieceType){
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for(int i=0; i<board.size; i++){
            if(board.board[row][i] == null || board.board[row][i].pieceType != pieceType){
                rowMatch = false;
            }
            if(board.board[i][col] == null || board.board[i][col].pieceType != pieceType){
                colMatch = false;
            }
            if(board.board[i][i] == null || board.board[i][i].pieceType != pieceType){
                diagonalMatch = false;
            }
            if(board.board[i][board.size - i - 1] == null || board.board[i][board.size - i - 1].pieceType != pieceType){
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch; 
    }

}
