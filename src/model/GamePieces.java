package model;

import model.ReversiPiece.Color;

/**
 * Represents the primary model class for playing a game of reversi.
 */
public interface GamePieces {


  /**
   * Renders a game piece with one of the following symbols {X, O, -},
   * X: Black piece.
   * O: white piece.
   * -: empty space.
   *
   * @return the formatted piece.
   */
  String toString();

  /**
   * Gets the color of the piece.
   *
   * @return the color of the piece.
   */
  Color getColor();

  /**
   * Sets the Color of a piece.
   */
  void setColor(Color color);


  /**
   * Retrieves the row of this Reversi Game Piece.
   */
  int getRow();


  /**
   * Retrieves the row slot of this Reversi Game Piece.
   */
  int getRowSlot();

}
