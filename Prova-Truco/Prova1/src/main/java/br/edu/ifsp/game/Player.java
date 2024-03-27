package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;

public class Player {
    private final String name;
    private int score;
    private Card[] cards;
    private int countCards;

    public Player(String name) {
        this.name = name;
        cards = new Card[3];
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
        countCards = 3;
    }

    public Card chooseCard() {
        return cards[--countCards];
    }

    public String getName() {
        return name;
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
