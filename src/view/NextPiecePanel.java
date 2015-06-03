/*
 * TCSS 305 June 1, 2013 
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.Board;

/**
 * This panel draws the next piece up for the Tetris game.
 *
 * @author Casey Morrison
 * @version June 1, 2013
 */
@SuppressWarnings("serial")
public class NextPiecePanel extends JPanel {
  
  /** The default size for this JPanel. */
  private static final Dimension WINDOW_SIZE = new Dimension(150, 150);
  
  /** The color of the background. */
  private static final Color DARKER_RED = new Color(205, 0, 0);
  
  /** The color of the next block. */
  private static final Color PURPLE2 = new Color(138, 43, 226);
  
//  /** The color of the border. */
//  private static final Color DARKER_GRAY = new Color(32, 32, 32);
  
  /** The default border, a black line. */
  private static final Border BLACK_LINE = BorderFactory.createLineBorder(Color.BLACK, 3);
  
  /** The default X or Y coordinate. */
  private static final int FIFTEEN = 15;
  
  /** The default X or Y coordinate. */
  private static final int FIFTY_FIVE = 55;
  
  /** The default Width and Height of the outside black box. */
  private static final int BLACK_WIDTH_HEIGHT = 29;
  
  /** The default Width and Height of the inside colored box. */
  private static final int INNER_WIDTH_HEIGHT = 25;
  
  /** The default X or Y coordinate. */
  private static final int FOURTY_FIVE = 45;
  
  /** The default X or Y coordinate. */
  private static final int SEVENTY_FIVE = 75;
  
  /** The default X or Y coordinate. */
  private static final int ONE_O_FIVE = 105;
  
  /** The default X or Y coordinate. */
  private static final int TWENTY_EIGHT = 28;
  
  /** The default X or Y coordinate. */
  private static final int SEVENTY = 70;
  
  /** The default X or Y coordinate. */
  private static final int FIFTY_EIGHT = 58;
  
  /** The default X or Y coordinate. */
  private static final int EIGHTY_EIGHT = 88;
  
  /** The default X or Y coordinate. */
  private static final int FORTY = 40;
  
  /** The default X or Y coordinate. */
  private static final int FORTY_THREE = 43;
  
  /** The default X or Y coordinate. */
  private static final int SEVENTY_THREE = 73;
  
  /** The titled border. */
  private static TitledBorder my_title_border;
  
  /** The Board used to move pieces. */
  private final Board my_board;
  
  /** The board panel used for getting the started state. */
  private final BoardPanel my_panel;

  /**
   * Constructs a new board panel.
   * @param the_board - the board used to move pieces.
   * @param the_panel - the BoardPanel used to get the started state.
   */
  public NextPiecePanel(final Board the_board, final BoardPanel the_panel) {
    super();
    my_panel = the_panel;
    my_board = the_board;
    setupNextBlock();
  }
  
  /**
   * Sets up the panel that displays the next block.
   */
  private void setupNextBlock() {
    setPreferredSize(WINDOW_SIZE);
//    setBackground(DARKER_RED);
    
    my_title_border = BorderFactory.createTitledBorder(BLACK_LINE, "Next Block");
    my_title_border.setTitlePosition(TitledBorder.BOTTOM);
    setBorder(my_title_border);
  }
  
  /** {@inheritDoc} 
   * Draws the next piece that is up for play.
   */
  @Override
  public void paintComponent(final Graphics the_graphics) {
    super.paintComponent(the_graphics);
    final Graphics2D g2d = (Graphics2D) the_graphics;
    
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    final File file = new File("red_diag.jpg");
//    final File file = new File("background1.jpg");
    BufferedImage img;
    try {
      img = ImageIO.read(file);
      g2d.drawImage(img, null, 0, 0);
    } catch (final IOException e) {
      setBackground(DARKER_RED);
    }
    
    g2d.setPaint(Color.BLACK);
    g2d.setStroke(new BasicStroke(2));
    
    if (!my_board.gameIsOver() && my_panel.isStartState()) {
      choosePieces(g2d);
    }
  }
  
  /**
   * Chooses which block is to be drawn.
   * @param the_g2d - the graphic used for drawing.
   */
  private void choosePieces(final Graphics2D the_g2d) {
    if ("IPiece".equals(my_board.getNextPiece().getClass().getSimpleName())) {
      drawI(the_g2d);
    } else if ("LPiece".equals(my_board.getNextPiece().getClass().getSimpleName())) {
      drawL(the_g2d);
    } else if ("JPiece".equals(my_board.getNextPiece().getClass().getSimpleName())) {
      drawJ(the_g2d);
    } else if ("OPiece".equals(my_board.getNextPiece().getClass().getSimpleName())) {
      drawO(the_g2d);
    } else if ("SPiece".equals(my_board.getNextPiece().getClass().getSimpleName())) {
      drawS(the_g2d);
    } else if ("TPiece".equals(my_board.getNextPiece().getClass().getSimpleName())) {
      drawT(the_g2d);
    } else if ("ZPiece".equals(my_board.getNextPiece().getClass().getSimpleName())) {
      drawZ(the_g2d);
    }
  }
  
  /**
   * Draws the I shape.
   * @param the_g2d - the graphic used to draw.
   */
  private void drawI(final Graphics2D the_g2d) {
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(FIFTEEN, FIFTY_FIVE, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(FIFTEEN + 2, FIFTY_FIVE + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
    
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(FOURTY_FIVE, FIFTY_FIVE, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(FOURTY_FIVE + 2, FIFTY_FIVE + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
    
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(SEVENTY_FIVE, FIFTY_FIVE, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(SEVENTY_FIVE + 2, FIFTY_FIVE + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
    
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(ONE_O_FIVE, FIFTY_FIVE, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(ONE_O_FIVE + 2, FIFTY_FIVE + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
  }
  
  /**
   * Draws the L shape.
   * @param the_g2d - the graphic used to draw.
   */
  private void drawL(final Graphics2D the_g2d) {
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(TWENTY_EIGHT, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(TWENTY_EIGHT + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);  
    
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(FIFTY_EIGHT, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(FIFTY_EIGHT + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
      
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(EIGHTY_EIGHT, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(EIGHTY_EIGHT + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
      
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(EIGHTY_EIGHT, FORTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(EIGHTY_EIGHT + 2, FORTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
  }
  
  /**
   * Draws the J shape.
   * @param the_g2d - the graphic used to draw.
   */
  private void drawJ(final Graphics2D the_g2d) {
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(TWENTY_EIGHT, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(TWENTY_EIGHT + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
      
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(FIFTY_EIGHT, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(FIFTY_EIGHT + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
      
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(EIGHTY_EIGHT, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(EIGHTY_EIGHT + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
    
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(TWENTY_EIGHT, FORTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(TWENTY_EIGHT + 2, FORTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT); 
  }
  
  /**
   * Draws the O shape.
   * @param the_g2d - the graphic used to draw.
   */
  private void drawO(final Graphics2D the_g2d) {
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(FORTY_THREE, FORTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(FORTY_THREE + 2, FORTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
      
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(FORTY_THREE, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(FORTY_THREE + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
      
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(SEVENTY_THREE, FORTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(SEVENTY_THREE + 2, FORTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
      
    the_g2d.setPaint(Color.BLACK);   
    the_g2d.fillRect(SEVENTY_THREE, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(SEVENTY_THREE + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
  }
  
  /**
   * Draws the S shape.
   * @param the_g2d - the graphic used to draw.
   */
  private void drawS(final Graphics2D the_g2d) {
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(TWENTY_EIGHT, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(TWENTY_EIGHT + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
      
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(FIFTY_EIGHT, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(FIFTY_EIGHT + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
    
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(FIFTY_EIGHT, FORTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(FIFTY_EIGHT + 2, FORTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
      
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(EIGHTY_EIGHT, FORTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(EIGHTY_EIGHT + 2, FORTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
  }
  
  /**
   * Draws the T shape.
   * @param the_g2d - the graphic used to draw.
   */
  private void drawT(final Graphics2D the_g2d) {
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(TWENTY_EIGHT, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(TWENTY_EIGHT + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
      
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(FIFTY_EIGHT, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(FIFTY_EIGHT + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
      
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(EIGHTY_EIGHT, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(EIGHTY_EIGHT + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
    
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(FIFTY_EIGHT, FORTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(FIFTY_EIGHT + 2, FORTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);  
  }
  
  /**
   * Draws the Z shape.
   * @param the_g2d - the graphic used to draw.
   */
  private void drawZ(final Graphics2D the_g2d) {
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(FIFTY_EIGHT, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(FIFTY_EIGHT + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
      
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(EIGHTY_EIGHT, SEVENTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(EIGHTY_EIGHT + 2, SEVENTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);
    
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(TWENTY_EIGHT, FORTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(TWENTY_EIGHT + 2, FORTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT); 
    
    the_g2d.setPaint(Color.BLACK);
    the_g2d.fillRect(FIFTY_EIGHT, FORTY, BLACK_WIDTH_HEIGHT, BLACK_WIDTH_HEIGHT);
    the_g2d.setPaint(PURPLE2);
    the_g2d.fillRect(FIFTY_EIGHT + 2, FORTY + 2, INNER_WIDTH_HEIGHT, INNER_WIDTH_HEIGHT);  
  }
}
