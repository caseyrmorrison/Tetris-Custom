/*
 * TCSS 305 May 28, 2013 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Board;

/**
 * The side panel holds panels that show the:
 * Next piece to be played with, the Score and Level, and the Instructions of how to play.
 *
 * @author Casey Morrison
 * @version May 28, 2013
 */
@SuppressWarnings("serial")
public class SidePanel extends JPanel {

  /** The color to paint with. */
  public static final Color FOREGROUND_COLOR = Color.BLACK;
  
  /** The default size for this JPanel. */
  private static final Dimension DEFUALT_SIZE = new Dimension(200, 600);
  
  /** The default font for the labels. */
  private static final String ARIAL = "Arial";
  
  /** The font of the panel to display the game over. */
  private static final Font FONT = new Font(ARIAL, Font.BOLD, 28);
  
//  /** The color of the border. */
//  private static final Color DARKER_GRAY = new Color(32, 32, 32);
  
  /** The default black line border. */
  private static final Border BLACK_LINE = BorderFactory.createLineBorder(Color.BLACK, 3);
  
//  /** The JPanel holding all the other JPanels. */
//  private final JPanel my_holder = new JPanel();
  
  /** The JPanel holding all the other JPanels. */
  private final HolderPanel my_holder = new HolderPanel();
  
  /** The Board that gets movement of blocks. */
  private final Board my_board;
  
  /** The JPanel object that displays the next piece. */
  private NextPiecePanel my_nextpiece;
  
  /** The board panel used for checking if the game has started. */
  private final BoardPanel my_board_panel;

  /**
   * Constructs a new board panel.
   * @param the_board - the board used to move the shapes.
   * @param the_board_panel - the board panel used for game starting.
   */
  public SidePanel(final Board the_board, final BoardPanel the_board_panel) {
    super();
    my_board_panel = the_board_panel;
    my_board = the_board;
    setupPanel();
    setFont(FONT);
  }

  /**
   * Sets up the side panel.
   */
  private void setupPanel() {
    setPreferredSize(DEFUALT_SIZE);
    setLayout(new BorderLayout());
    setBorder(BLACK_LINE);
    add(my_holder, BorderLayout.CENTER);
    final BufferPanel westbuffer = new BufferPanel();
    final BufferPanel eastbuffer = new BufferPanel();
    add(westbuffer, BorderLayout.EAST);
    add(eastbuffer, BorderLayout.WEST);
    
    setupNextBlock();
    final ScoreBlockPanel score = new ScoreBlockPanel(my_board);
    my_holder.add(score, BorderLayout.CENTER);
    setupInstructionsBox();
  }
  
  /**
   * Sets up the panel that displays the next block.
   */
  private void setupNextBlock() {
    my_nextpiece = new NextPiecePanel(my_board, my_board_panel);
    my_holder.add(my_nextpiece, BorderLayout.NORTH);
  }
  
  /**
  * Sets up the panel that displays the instructions.
  */
  private void setupInstructionsBox() {
    final InstructionPanel instruct = new InstructionPanel();
    my_holder.add(instruct, BorderLayout.SOUTH);
  }
  
  /** {@inheritDoc} */
  @Override
  public void paintComponent(final Graphics the_graphics) {
    super.paintComponent(the_graphics);  
    my_nextpiece.repaint();
  }
}
