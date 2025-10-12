package SnakeLadderLLD;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    Board(int boardSize, int noOfSnakes, int noOfLadders) {
        inititializeBoard(boardSize);
        addSnakesLadders(cells, noOfSnakes, noOfLadders);
    }

    Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardColumn = (playerPosition % cells.length);
        return cells[boardRow][boardColumn];
    }

    private void addSnakesLadders(Cell[][] cells2, int noOfSnakes, int noOfLadders) {
        while (noOfSnakes > 0){
            int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(snakeTail >= snakeHead) {
                continue;
            }

            Jump snakeJump = new Jump(snakeHead, snakeTail);

            Cell cell = getCell(snakeHead);
            cell.jump = snakeJump;

            noOfSnakes--;
        }
        while (noOfLadders > 0) {
            
            int ladderStart = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(ladderStart >= ladderEnd) {
                continue;
            }
            Jump ladderJump = new Jump(ladderStart, ladderEnd);

            Cell cell = getCell(ladderStart);
            cell.jump = ladderJump;
            noOfLadders--;
        }
    }

    private void inititializeBoard(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        
        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                cells[i][j] = new Cell();
            }
        }
    }
}
