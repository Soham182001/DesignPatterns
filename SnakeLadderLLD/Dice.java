package SnakeLadderLLD;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    int min = 1;
    int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int total = 0;
        for (int i = 0; i < diceCount; i++) {
            int roll = ThreadLocalRandom.current().nextInt(min, max+1);
            total += roll;
        }
        return total;
    }
}
