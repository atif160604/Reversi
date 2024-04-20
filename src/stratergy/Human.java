package stratergy;

import java.util.ArrayList;

import controller.ReversiController;
import model.GamePieces;
import model.ReadonlyReversiModel;

/**
 * The class for a real Human Player of Reversi who manually interacts with the Reversi GUI.
 */
public class Human implements PlayerStrat {


  private GamePieces cellPiece;
  private ReversiController controller;


  private final ReadonlyReversiModel model;
  private boolean movePlayed = false;

  /**
   * Constructs a human player of Reversi.
   *
   * @param model the Reversi game.
   */
  public Human(ReadonlyReversiModel model) {
    this.model = model;
  }


  @Override
  public void addController(ReversiController controller) {
    this.controller = controller;
  }

  @Override
  public GamePieces nextTurn() {
    System.out.println("next turn called");
    movePlayed = false;
    return cellPiece;
  }

  @Override
  public void getCell(ArrayList<Integer> coordinates) {
    int row = coordinates.get(0);
    int rowSlot = coordinates.get(1);
    System.out.println(row + " " + rowSlot);

    cellPiece = model.getCellContent(row, rowSlot);
    movePlayed = true;

    controller.placePiece(row, rowSlot);
  }

  @Override
  public void move() {
     //stub
  }

}
