package gm;

import javax.swing.SwingUtilities;
import domain.Piece;
import domain.Worm;
import gui.UserInterface;
import game.WormGame;

public class Main {

    public static void main(String[] args) {
        WormGame game = new WormGame(20, 20);

        UserInterface ui = new UserInterface(game, 20);
        SwingUtilities.invokeLater(ui);

        while (ui.getUpdatable() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("The drawing board hasn't been created yet.");
            }
        }

        game.setUpdatable(ui.getUpdatable());
        game.start();
    }
}