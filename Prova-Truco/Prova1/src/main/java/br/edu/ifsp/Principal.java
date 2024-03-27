package br.edu.ifsp;

import br.edu.ifsp.game.Game;
import br.edu.ifsp.game.Player;

public class Principal {
    public static void main(String[] args) {
        Player player1 = new Player("Tiago");
        Player player2 = new Player("Diego");
        Game game = new Game(player1, player2);

        while (game.getWinner() == null) {
            game.play();
        }
        System.out.println("Game winner: " + game.getWinner().getName());
    }
}
