package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import stratergy.PlayerStrat;

import static view.ReversiGUI.listenList;

/**
 * class to handle mouse clicks.
 */
public class ButtonListener implements ActionListener {
  private final int row;
  private final int rowSlot;
  private JButton lastSelectedButton = null;
  private final Color selectedColor = Color.GREEN;
  private final Color defaultColor = Color.GRAY;
  private boolean cellSelected = false;

  /**
   * constructor for ButtonListener.
   */
  public ButtonListener(int row, int rowSlot) {
    this.row = row;
    this.rowSlot = rowSlot;
  }

  /**
   * Retrieves the row of the button that this Button Listener listens for.
   *
   * @return the row of the button that this Button Listener listens for.
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Retrieves the row of the button that this Button Listener listens for.
   *
   * @return the row of the button that this Button Listener listens for.
   */
  public int getRowSlot() {
    return this.rowSlot;
  }

  /**
   * Retrieves the last selected button.
   *
   * @return the last selected button.
   */
  public JButton getLastSelectedButton() {
    return this.lastSelectedButton;
  }

  /**
   * Retrieves the default color of a button.
   *
   * @return the default color of a button.
   */
  public Color getDefaultColor() {
    return this.defaultColor;
  }

  /**
   * Retrieves the selected color of a button.
   *
   * @return the selected color of a button.
   */
  public Color getSelectedColor() {
    return this.selectedColor;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("Cell clicked: " + row + ", " + rowSlot);
    JButton button = (JButton) e.getSource();

    if (button == lastSelectedButton) {
      deselectButton(button);
    } else {
      if (lastSelectedButton != null) {
        deselectButton(lastSelectedButton);
      }
      selectButton(button);
    }

    for (int i = 0; i < listenList.size(); i++) {
      PlayerStrat currentListener = listenList.get(i);
      ArrayList<Integer> coordinateList = new ArrayList<>();
      coordinateList.add(row);
      coordinateList.add(rowSlot);
      currentListener.getCell(coordinateList);
      System.out.println("get cell called");

    }
  }

  /**
   * action for what happens when a hexagon is selected.
   */
  private void selectButton(JButton button) {
    button.setBackground(selectedColor);
    lastSelectedButton = button;
    cellSelected = true;
    System.out.println("button clicked");
  }

  /**
   * Action for what happens when a hexagon is deselected.
   */
  private void deselectButton(JButton button) {
    button.setBackground(defaultColor);
    lastSelectedButton = null;
    cellSelected = false;
    System.out.println("button unclicked");
  }
}
