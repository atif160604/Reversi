package stratergy;

import java.util.ArrayList;
import java.util.List;

import controller.ReversiController;
import model.CaptureMax;
import model.GamePieces;
import model.ReadonlyReversiModel;
import view.ReversiTextualView;


/**
 * The class for a machine player of Reversi which automatically picks a move.
 */
public class Machine implements PlayerStrat {

  private final ReadonlyReversiModel model;

  private ReversiController controller;


  /**
   * Constructs a machine player for Reversi.
   *
   * @param model The Reversi model that this machine player takes.
   */
  public Machine(ReadonlyReversiModel model) {
    this.model = model;
  }


  @Override
  public void addController(ReversiController controller) {
    this.controller = controller;
  }

  @Override
  public GamePieces nextTurn() throws InterruptedException {
    return null;
  }

  @Override
  public void getCell(ArrayList<Integer> coordinates) {
    //stub
  }

  @Override
  public void move() {
    System.out.println("move called");
    List<Integer> bestMoves = new CaptureMax().chooseMove(model, controller.getColor());
    if (bestMoves.size() != 0) {
      System.out.println("passed if statement");
      controller.placePiece(bestMoves.get(0), bestMoves.get(1));
      System.out.println("passed piece statement");
      System.out.println(new ReversiTextualView(model).toString());
    } else {
      controller.pass();
    }
  }
}
