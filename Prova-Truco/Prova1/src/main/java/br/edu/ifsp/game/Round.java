package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;

public class Round {
    private String winner;

    public Round(Player player1, Card card1, Player player2, Card card2, Card vira) {
        int result = card1.compareValueTo(card2, vira);
        if (result > 0) {
            winner = player1.getName();
        } else if (result < 0) {
            winner = player2.getName();
        }
    }

    public String getWinner() {
        return winner;
    }
}
