package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Reversi Strategy of choosing a move that captures the most pieces.
 */
public class CaptureMax implements ReversiStrategy {

  /**
   * Helper method to set the new best move coordinates and directions.
   */
  private void setNewTempBestMove(List<String> tempCD, List<Integer> tempCoord,
                                  List<String> cDToCopy, List<Integer> coordToCopy) {
    tempCD.clear();
    tempCoord.clear();
    tempCD.addAll(cDToCopy);
    tempCoord.addAll(coordToCopy);
  }


  @Override
  public List<Integer> chooseMove(ReadonlyReversiModel model, ReversiPiece.Color forWhom) {
    if (model == null) {
      throw new IllegalArgumentException("Cannot choose best move from null game model.");
    }
    if (forWhom == ReversiPiece.Color.BLANK) {
      throw new IllegalArgumentException("There is no BLANK player. Only BLACK and WHITE.");
    }


    List<String> tempBestMoveCaptureDirections = new ArrayList<>();
    List<Integer> tempBestMoveCoordinates = new ArrayList<>();

    for (int row = 0; row < model.getBoard().size(); row++) {
      for (int rowSlot = 0; rowSlot < model.getBoard().get(row).size(); rowSlot++) {
        System.out.println(row + " " + rowSlot);
        String rowString = Integer.toString(row);
        String rowSlotString = Integer.toString(rowSlot);

        if (model.isLegal(row, rowSlot, forWhom)) {
          List<String> currentMoveCaptureDirections = new ArrayList<>();
          List<Integer> currentMoveCoordinates = new ArrayList<>();
          currentMoveCoordinates.add(row);
          currentMoveCoordinates.add(rowSlot);
          currentMoveCaptureDirections = model.getCaptureDirections();

          if (currentMoveCaptureDirections.size() > tempBestMoveCaptureDirections.size()) {
            this.setNewTempBestMove(tempBestMoveCaptureDirections, tempBestMoveCoordinates,
                    currentMoveCaptureDirections, currentMoveCoordinates);

          }

        }
      }
    }

    return tempBestMoveCoordinates;
  }

}
