package view;

import java.awt.Shape;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.Color;
import java.awt.RenderingHints;

import javax.swing.JButton;

/**
 * This class represents a button for a hex slot on the Reversi Board on the GUI.
 */

public class HexagonButton extends JButton {
  private Shape hexagon;
  private final int radius = 50;
  int row;
  int rowSlot;

  /**
   * Constructs a HexagonButton with a specified label.
   *
   * @param label The text or label to be displayed on the button.
   */
  public HexagonButton(String label) {
    super(label);
    setContentAreaFilled(false);
    setFocusPainted(false);
    setBackground(Color.GRAY);
    initHexagon();
    this.row = 0;
    this.rowSlot = 0;
  }

  /**
   * initialise the hexagon.
   */
  private void initHexagon() {
    hexagon = createHexagon();
  }


  /**
   * creates the shape of the hexagon.
   */
  private Shape createHexagon() {
    Path2D.Float p = new Path2D.Float();
    double startAngle = -Math.PI / 2;
    for (int i = 0; i < 6; i++) {
      double angle = startAngle + i * 2 * Math.PI / 6;
      double x = radius + radius * Math.cos(angle);
      double y = radius + radius * Math.sin(angle);

      if (i == 0) {
        p.moveTo(x, y);
      } else {
        p.lineTo(x, y);
      }
    }
    p.closePath();
    return p;
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setColor(getBackground());
    g2.fill(hexagon);
    g2.setColor(getForeground());
    g2.draw(hexagon);
    g2.dispose();
  }

  @Override
  public Dimension getPreferredSize() {
    int height = (int) (Math.sqrt(3) * radius);
    return new Dimension(2 * radius, height);
  }

  @Override
  public boolean contains(int x, int y) {
    return hexagon.contains(x, y);
  }

}
