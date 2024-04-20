package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.ReversiModel;


/**
 * class to handle key events.
 */
class MyKeyListener implements KeyListener {

  ReversiModel model;

  /**
   * Constructs a MyKeyListener.
   * @param model the Reversi model.
   */
  MyKeyListener(ReversiModel model) {
    this.model = model;
  }

  @Override
  public void keyTyped(KeyEvent e) {
    //stub
  }

  @Override
  public void keyPressed(KeyEvent e) {
    char keyChar = e.getKeyChar();

    // Handle the 'm' key
    if (keyChar == 'm') {
      if (model.getPlayerATurn()) {
        System.out.println("Black can make a move now");
      } else {
        System.out.println("White can make a move now");
      }

    }
    // Handle the 'p' key
    else if (keyChar == 'p') {
      if (model.getPlayerATurn()) {
        System.out.println("Black has passed. It is now White's turn!");
        model.pass();
      } else {
        System.out.println("White has passed. It is now Black's turn!");
        model.pass();
      }

    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    //stub
  }
}