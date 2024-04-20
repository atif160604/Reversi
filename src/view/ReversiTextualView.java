package view;

import java.util.List;

import model.GamePieces;
import model.ReadonlyReversiModel;

/**
 * Represents the primary view class for displaying a game of reversi.
 */
public class ReversiTextualView implements TextualView {

  private final ReadonlyReversiModel model;

  /**
   * Constructs the Reversi Textual View.
   * @param model the model corresponding to this textual view.
   */
  public ReversiTextualView(ReadonlyReversiModel model) {
    this.model = model;
  }

  /**
   * displays the game of reversi.
   */
  public String toString() {
    StringBuilder result = new StringBuilder();
    List<List<GamePieces>> gameBoard = model.getBoard();
    int boardSideLength = gameBoard.get(0).size();
    int firstHalfSpaceCount = boardSideLength - 1;
    for (int rowIndex = 0; rowIndex < boardSideLength; rowIndex++) {
      result.append(" ".repeat(firstHalfSpaceCount));
      List<GamePieces> currentRow = gameBoard.get(rowIndex);
      for (int slotIndex = 0; slotIndex < currentRow.size(); slotIndex++) {
        GamePieces currentPiece = currentRow.get(slotIndex);
        result.append(currentPiece.getColor().toString());
        result.append(" ");
      }
      result.append("\n");
      firstHalfSpaceCount--;
    }
    int secondHalfSpaceCount = 1;
    for (int rowIndex = boardSideLength; rowIndex < gameBoard.size(); rowIndex++) {
      result.append(" ".repeat(secondHalfSpaceCount));
      List<GamePieces> currentRow = gameBoard.get(rowIndex);
      for (int slotIndex = 0; slotIndex < currentRow.size(); slotIndex++) {
        GamePieces currentPiece = currentRow.get(slotIndex);
        result.append(currentPiece.getColor().toString());
        result.append(" ");
      }
      secondHalfSpaceCount++;
      result.append("\n");
    }
    return result.toString();

  }
}