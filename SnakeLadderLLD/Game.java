package SnakeLadderLLD;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playersList = new LinkedList<>();
    Player winner;

    public Game(){
        initializeGame();
    }

    private void initializeGame(){
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }
    
    private void addPlayers(){
        Player player1 = new Player("1", "Soham", 0);
        Player player2 = new Player("2", "Ganesh", 0);
        playersList.add(player1);
        playersList.add(player2);
    }

    public void startGame(){
        while(winner == null){
            Player playerTurn = findPlayerTurn();
            System.out.println("Player turn: " + playerTurn.getName()+ " Current Position: " + playerTurn.getCurrentPosition());

            // Roll Dice
            int diceNumbers = dice.rollDice();

            // get the new position
            int playerNewPosition = playerTurn.getCurrentPosition() + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition, diceNumbers);
            playerTurn.setCurrentPosition(playerNewPosition);
            System.out.println("Player: " + playerTurn.getName()+ " New Position: "+ playerTurn.getCurrentPosition());
            if(playerTurn.getCurrentPosition() == board.cells.length * board.cells.length - 1) {
                winner = playerTurn;
                System.out.println("Winner is: " + winner.getName());
            }
            System.out.println("--------------------------------------------------");

        }
    }

    private Player findPlayerTurn() {
        Player player = playersList.pollFirst();
        playersList.addLast(player);
        return player;
    }

    private int jumpCheck(int playerNewPosition, int diceNumbers) {
        if(playerNewPosition > board.cells.length * board.cells.length - 1) {
            return playerNewPosition - diceNumbers;
        }
        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition){
            String jumpBy = (cell.jump.start < cell.jump.end) ? "LADDER" : "SNAKE";
            System.out.println("Jumped by " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }
}
