package model;

import java.util.List;

import controller.ReversiController;

/**
 * The primary read-only interface for Reversi Models.
 * It only allows you to observe a model. You cannot change anything in the model
 * with this interface.
 */

public interface ReadonlyReversiModel {

  /**
   * Gets the current state of the board.
   *
   * @return The current state of the board.
   */
  List<List<GamePieces>> getBoard();

  /**
   * Retrieves the number of times players have passed.
   *
   * @return the current pass count.
   */
  int getPassCount();

  /**
   * Retrieves whether it is player A's turn or not.
   *
   * @return the current status of player A's turn.
   */
  boolean getPlayerATurn();

  /**
   * Retrieves the directions that a move captures in.
   *
   * @return the model's list of capture directions.
   */
  List<String> getCaptureDirections();


  /**
   * Makes a copy of a Reversi game board.
   *
   * @return a new board copy
   */

  List<List<GamePieces>> makeBoardCopy();

  /**
   * Retrieves the number of rows on the board.
   *
   * @return the board size.
   */
  int getBoardSize();

  /**
   * Signal if the game is over or not.  A game is over if two passes have been made consecutively.
   *
   * @return true if game is over, false otherwise.
   * @throws IllegalStateException if the game hasn't been started yet.
   */
  boolean isGameOver();


  /**
   * Checks whether the piece placed by the user is a legal move or not.
   *
   * @param row         which row the piece has been placed.
   * @param rowSlot     which slot within the row the piece has been placed.
   * @param playerColor indicates which player has placed the piece.
   * @return true if the piece placed is a legal move, false otherwise.
   * @throws IllegalStateException if the game hasn't been started yet
   */
  boolean isLegal(int row, int rowSlot, ReversiPiece.Color playerColor);


  /**
   * Retrieves the content of a particular cell.
   *
   * @param row     the row index of a particular cell.
   * @param rowSlot the row slot index of a particular cell.
   * @return the content of a cell, whether it is a BLACK piece, WHITE piece, or BLANK.
   */
  GamePieces getCellContent(int row, int rowSlot);


  /**
   * Retrieves the current score of the Reversi game.
   *
   * @param playerColor the color of the player that you want to get the score of.
   * @return the content of a cell, whether it is a BLACK piece, WHITE piece, or BLANK.
   */
  int getCurrentScore(ReversiPiece.Color playerColor);


  /**
   * Determines whether there are any legal moves left in the Reversi game by checking
   * every slot on the board.
   *
   * @param playerColor the color of the player for whom
   *                    you want to check if there are any moves.
   * @return whether there are any legal moves on the board for
   * the given color player
   */
  boolean anyLegalMoves(ReversiPiece.Color playerColor);

  /**
   * Retrieves the player turn of this model.
   *
   * @return the player turn of this model.
   */
  public boolean getTurn();

  /**
   * Retrieves the color of the current player whose turn it is to play in this model.
   *
   * @return the color of the current play of this model.
   */
  public ReversiPiece.Color getCurrentColor();

  /**
   * Adds a controller as a listener to this model.
   *
   * @param controller the specific controller that is
   *                   to be assigned as a listener.
   */
  void addController(ReversiController controller);


}
