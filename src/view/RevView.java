package view;

import model.ReversiPiece;
import stratergy.PlayerStrat;

/**
 * This is the primary interface for the Reversi GUIs.
 */
public interface RevView {


  /**
   * Makes the GUI frame visible on the screen.
   */

  public void setVisible();

  /**
   * Sets up a board of hexagon buttons.
   */
  public void initializeBoard();

  /**
   * sets the given color piece to a desired location.
   */
  public void setPiece(int row, int rowSlot, ReversiPiece.Color color);

  /**
   * sets the starting pieces of the game onto the .
   */
  public void setStartingPieces();


  /**
   * Adds a player as a listener to this Reversi GUI.
   * @param ps the player to be assigned as a listener to this GUI.
   */
  public void addListener(PlayerStrat ps);

  /**
   * Updates the GUI board based on the state of the model board, then repaints.
   */
  public void updateBoard();

}
