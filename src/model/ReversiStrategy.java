package model;

import java.util.List;

/**
 * This is the main interface for all Reversi game play strategies.
 */
public interface ReversiStrategy {


  /**
   * Finds the best legal move based on the specific Reversi game strategy.
   *
   * @param model   The model of the Reversi game which keeps track of the game state.
   * @param forWhom The player for whom the method is finding the best move for.
   * @return a List of Integer coordinates of the best move.
   */
  List<Integer> chooseMove(ReadonlyReversiModel model, ReversiPiece.Color forWhom);
}
