package stratergy;

import java.util.ArrayList;

import controller.ReversiController;
import model.GamePieces;


/**
 * The common interface for players in reversi.
 */
public interface PlayerStrat {

  /**
   * Notifies that the turn has been played.
   *
   * @return the piece of the turn.
   * @throws InterruptedException when error.
   */
  GamePieces nextTurn() throws InterruptedException;

  /**
   * Gets the cell of the piece.
   * @param coordinates coordinates of the cell to be retrieved.
   */
  void getCell(ArrayList<Integer> coordinates);

  /**
   * The player makes a move in the Reversi game.
   */
  void move();

  /**
   * Adds a controller to the player as a listener.
   *
   * @param controller the controller that you want as a listener for this player.
   */
  void addController(ReversiController controller);
}
