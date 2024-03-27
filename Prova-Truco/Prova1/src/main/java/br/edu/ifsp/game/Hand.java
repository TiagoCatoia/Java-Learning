package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;
import br.edu.ifsp.deck.Deck;

public class Hand {
    private final Card vira;
    private final Player player1;
    private final Player player2;
    private final Round[] rounds;
    private int countRounds;

    public Hand(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        rounds = new Round[3];
        Deck deck = new Deck();
        deck.shuffle();
        vira = deck.takeOne();
        player1.setCards(deck.take(3));
        player2.setCards(deck.take(3));
    }

    public void playRound() {
        Round round = new Round(player1, player1.chooseCard(), player2, player2.chooseCard(), vira);
        if (round.getWinner() == null) {
            System.out.println("Round tied\n");
        } else {
            System.out.println("Roud winner: " + round.getWinner() + "\n");
        }
        rounds[countRounds++] = round;
    }

    public boolean isDone() {
        if (countRounds < 2) return false;
        if (countRounds == 3) return true;
        if (rounds[0].getWinner() == null && rounds[1].getWinner() == null) return false;
        if (rounds[0].getWinner() == null && rounds[1].getWinner() != null) return true;
        if (rounds[0].getWinner() != null && rounds[1].getWinner() == null) return true;
        return rounds[0].getWinner().equals(rounds[1].getWinner());
    }

    public String getWinner() {
        if (!isDone()) return null;
        if (rounds[0].getWinner() == null && rounds[1].getWinner() != null) return rounds[1].getWinner();
        if (rounds[0].getWinner() != null && rounds[1].getWinner() == null) return rounds[0].getWinner();
        if (rounds[0].getWinner() == null && rounds[1].getWinner() == null && rounds[2].getWinner() == null) return null;
        if (rounds[0].getWinner() == null && rounds[1].getWinner() == null && rounds[2].getWinner() != null) return rounds[2].getWinner();
        if (rounds[0].getWinner().equals(rounds[1].getWinner())) return rounds[0].getWinner();
        if (rounds[0].getWinner() != null && rounds[1].getWinner() != null && rounds[2].getWinner() == null) return rounds[0].getWinner();
        if (rounds[0].getWinner() != null && rounds[1].getWinner() != null && rounds[0].getWinner().equals(rounds[2].getWinner())) return rounds[0].getWinner();
        return rounds[1].getWinner();
    }
}
