import java.util.Random;

public class Craps {
    public enum GameStatus {CONTINUE, WON, LOST}

    public static int rollDice() {
        Random rand = new Random();
        int die1 = rand.nextInt(6) + 1;
        int die2 = rand.nextInt(6) + 1;
        System.out.println("Rolled: " + die1 + " + " + die2 + " = " + (die1 + die2));
        return die1 + die2;
    }

    public static void main(String[] args) {
        int sum = rollDice();
        GameStatus status;

        switch (sum) {
            case 7, 11 -> status = GameStatus.WON;
            case 2, 3, 12 -> status = GameStatus.LOST;
            default -> {
                int point = sum;
                System.out.println("Point is: " + point);
                do {
                    sum = rollDice();
                } while (sum != point && sum != 7);
                status = (sum == point) ? GameStatus.WON : GameStatus.LOST;
            }
        }
        System.out.println((status == GameStatus.WON) ? "You win!" : "You lose.");
    }
}
