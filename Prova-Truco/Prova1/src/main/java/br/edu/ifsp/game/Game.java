package br.edu.ifsp.game;

public class Game {
    private final Player player1;
    private final Player player2;
    private final Hand[] hands;
    private int countHands;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        hands = new Hand[30];
        Hand firstHand = new Hand(player1, player2);
        hands[countHands++] = firstHand;
    }

    public void play() {
        Hand currentHand = hands[countHands - 1];
        if (currentHand.isDone()) {
            String handWinner = currentHand.getWinner();
            if (handWinner == null) {
                System.out.println("Match tied\n");
            } else if (handWinner.equals(player1.getName())) {
                player1.incrementScore();
                System.out.println("Winner hand: " + handWinner + "\n");
            } else {
                player2.incrementScore();
                System.out.println("Winner hand: " + handWinner + "\n");
            }
            if (!isDone()) {
                hands[countHands] = new Hand(player1, player2);
                hands[countHands++].playRound();
            }
        } else {
            currentHand.playRound();
        }
    }

    public boolean isDone() {
        return player1.getScore() == 12 || player2.getScore() == 12;
    }

    public Player getWinner() {
        if (!isDone()) return null;
        if (player1.getScore() == 12) return player1;
        else return player2;
    }
}
