import controller.ReversiController;
import model.BasicReversi;
import model.ReversiPiece;
import stratergy.Human;
import stratergy.PlayerStrat;
import view.ReversiGUI;

/**
 * The final Reversi class that connects the model, view, and controller
 * to run a full playable game of Reversi.
 */
public final class Reversi {
  /**
   * The final Reversi class that connects the model, view, and controller
   * to run a full playable game of Reversi.
   */
  public static void main(String[] args) throws InterruptedException {
    BasicReversi model = new BasicReversi(4);
    ReversiGUI viewPlayer1 = new ReversiGUI(model);
    ReversiGUI viewPlayer2 = new ReversiGUI(model);
    PlayerStrat player1 = new Human(model);
    PlayerStrat player2 = new Human(model);
    ReversiController controller1 = new ReversiController(model, player1, viewPlayer1,
            ReversiPiece.Color.BLACK);
    ReversiController controller2 = new ReversiController(model, player2, viewPlayer2,
            ReversiPiece.Color.WHITE);
    viewPlayer1.setVisible();
    viewPlayer2.setVisible();
    model.startGame();
  }
}