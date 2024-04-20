package model;

import java.util.Objects;

import javax.swing.*;

/**
 * Represents the model class for a player piece.
 */
public class ReversiPiece implements GamePieces {

  private final int row;

  private final int rowSlot;
  private Color color;
  private JButton button;

  /**
   * Constructs a ReversiPiece.
   *
   * @param color the Color of the ReversiPiece.
   */
  public ReversiPiece(Color color, int row, int rowSlot) {
    this.color = color;
    this.row = row;
    this.rowSlot = rowSlot;
  }

  /**
   * Represents the different player pieces.
   */
  public enum Color {

    BLACK("X"),

    WHITE("O"),

    BLANK("-");

    private final String symbol;

    /**
     * Constructs the color of a ReversiPiece.
     *
     * @param symbol the String symbol representation of the color.
     */
    Color(String symbol) {
      this.symbol = symbol;
    }

    /**
     * Converts a Color to its String symbol representation.
     *
     * @return the String symbol representation of the color.
     */
    public String toString() {
      return symbol;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ReversiPiece piece = (ReversiPiece) obj;
    return color == piece.color;
  }

  @Override
  public int hashCode() {
    return Objects.hash(color);
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public int getRow() {
    return this.row;
  }

  @Override
  public int getRowSlot() {
    return this.rowSlot;
  }

  @Override
  public void setColor(Color color) {
    this.color = color;

  }
}

