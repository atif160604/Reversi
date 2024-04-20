package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.*;

import model.GamePieces;
import model.ReversiModel;
import model.ReversiPiece;
import stratergy.PlayerStrat;

/**
 * This class represents a Graphical User Interface (GUI) for a Reversi Game. It shows a graphical
 * representation of the board and what happens to the board when players make moves.
 */
public class ReversiGUI implements RevView {

  private JFrame frame;
  private List<HexagonButton> hexList;
  private final ReversiModel model;
  private JPanel boardPanel;
  private ImageIcon blackCircle;
  private ImageIcon finalimg;

  private KeyListener keyListener;

  private KeyListener buttonListener;

  private ActionListener placePieceListener;

  static final ArrayList<PlayerStrat> listenList = new ArrayList<>();

  private List<List<JButton>> boardButtonList;


  /**
   * Constructs a ReversiGUI.
   *
   * @param model the model of the Reversi Game which keeps track of the game state.
   */
  public ReversiGUI(ReversiModel model) {
    this.model = model;
    createAndShowGUI();


  }


  private void createAndShowGUI() {
    frame = new JFrame("Reversi Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 1000);
    frame.setLocationRelativeTo(null);
    frame.setBackground(Color.black);

    boardPanel = new JPanel();
    boardPanel.setLayout(null);
    initializeBoard();
    setStartingPieces();

    JPanel containerPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    containerPanel.add(boardPanel, gbc);

    frame.add(containerPanel, BorderLayout.CENTER);

    frame.addKeyListener(new MyKeyListener(this.model));
    frame.setFocusable(true);


  }


  @Override
  public void setVisible() {
    frame.setVisible(true);
  }

  @Override
  public void initializeBoard() {
    hexList = new ArrayList<>();
    int sideLength = model.getBoardSize();
    int radius = 50;

    int horizontalDistance = (int) (radius * 1.69);
    int verticalDistance = (int) (Math.sqrt(3) * radius * 0.88);

    int maxBoardWidth = 2 * (sideLength - 1) * horizontalDistance + radius + 200;
    int yOff = 0;
    for (int i = 0; i < 2 * sideLength - 1; i++) {

      int hexagonsInThisRow = sideLength + Math.min(i, 2 * (sideLength - 1) - i);
      int xOff = (maxBoardWidth - hexagonsInThisRow * horizontalDistance) / 2 + (radius / 2);

      for (int j = 0; j < hexagonsInThisRow; j++) {

        HexagonButton hexButton = new HexagonButton("");
        hexButton.setBounds(xOff + (j * horizontalDistance), yOff,
                radius * 2, radius * 2);
        hexButton.addActionListener(new ButtonListener(i, j));
        hexButton.row = i;
        hexButton.rowSlot = j;
        hexList.add(hexButton);
        boardPanel.add(hexButton);
      }

      yOff += verticalDistance;

      boardPanel.setPreferredSize(new Dimension(maxBoardWidth, yOff + verticalDistance));
      boardPanel.revalidate();
    }
  }


  @Override
  public void setPiece(int row, int rowSlot, ReversiPiece.Color color) {
    int circleDiameter = 30;
    int hexagonRadius = 50;
    for (HexagonButton bt : hexList) {
      if (bt.row == row && bt.rowSlot == rowSlot) {
        int centerX = (hexagonRadius * 2 - circleDiameter) / 2;
        int centerY = (hexagonRadius * 2 - circleDiameter) / 2;

        // Remove existing CirclePanel if any
        Component[] components = bt.getComponents();
        for (Component component : components) {
          if (component instanceof CirclePanel) {
            bt.remove(component);
            break;
          }
        }

        CirclePanel circlePanel = null;
        if (color == ReversiPiece.Color.BLACK) {
          circlePanel = new CirclePanel(Color.BLACK);
        } else if (color == ReversiPiece.Color.WHITE) {
          circlePanel = new CirclePanel(Color.WHITE);
        }

        if (circlePanel != null) {
          circlePanel.setBounds(centerX, centerY, circleDiameter, circleDiameter);
          bt.add(circlePanel);
          bt.revalidate();
          bt.repaint();
        }
        break;
      }
    }
  }


  @Override
  public void setStartingPieces() {
    int sideLength = model.getBoardSize();
    this.setPiece(sideLength - 2, sideLength - 2, ReversiPiece.Color.BLACK);
    this.setPiece(sideLength - 2, sideLength - 1, ReversiPiece.Color.WHITE);
    this.setPiece(sideLength - 1, sideLength - 2, ReversiPiece.Color.WHITE);
    this.setPiece(sideLength - 1, sideLength, ReversiPiece.Color.BLACK);
    this.setPiece(sideLength, sideLength - 2, ReversiPiece.Color.BLACK);
    this.setPiece(sideLength, sideLength - 1, ReversiPiece.Color.WHITE);
  }


  @Override
  public void addListener(PlayerStrat ps) {
    listenList.add(Objects.requireNonNull(ps));
  }


  @Override
  public void updateBoard() {
    List<List<GamePieces>> modelBoard = model.getBoard();
    System.out.println(new ReversiTextualView(model));
    for (int row = 0; row < modelBoard.size(); row++) {
      List<GamePieces> currentRow = modelBoard.get(row);
      for (int rowSlot = 0; rowSlot < currentRow.size(); rowSlot++) {
        GamePieces currentPiece = model.getCellContent(row, rowSlot);
        this.setPiece(row, rowSlot, currentPiece.getColor());
      }
    }
    frame.repaint();
  }

}

