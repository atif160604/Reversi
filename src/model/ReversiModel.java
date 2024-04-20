package model;

/**
 * Represents the primary model interface for playing a game of reversi.
 */
public interface ReversiModel extends ReadonlyReversiModel {

  /**
   * Starts a new game of reversi.
   * This method sets up all the initial pieces on the board.
   * This method first verifies that the game hasn't already been set up.
   * If it hasn't then it starts setting up the board with the desired number of slots required for
   * that row.
   *
   * @throws IllegalStateException if the game has already been set up.
   */
  void startGame();

  /**
   * Changes the players turn from black to white or vice versa after each piece is placed.
   *
   * @throws IllegalStateException if the game hasn't been started yet
   */
  void nextTurn();

  /**
   * Changes the players turn from black to white or vice versa without affceting the board.
   *
   * @throws IllegalStateException if the game hasn't been started yet
   */
  void pass();


  /**
   * Checks whether the piece placed by the user is a legal move or not.
   *
   * @param targetRow     which row the user intends to place the piece in.
   * @param targetRowSlot which slot within the row  the user intends to place the piece.
   * @throws IllegalStateException if the game hasn't been started yet
   */
  void placePiece(int targetRow, int targetRowSlot);


}

