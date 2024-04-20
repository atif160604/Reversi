package view;

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

/**
 * class to represent a black or white circle.
 */
public class CirclePanel extends JPanel {
  private Color color;

  /**
   * Constructs a CirclePanel.
   * @param color the color of the Circle.
   */
  public CirclePanel(Color color) {
    this.color = color;
    setOpaque(false);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(color);
    g.fillOval(25, 25, 40, 40);
  }
}
