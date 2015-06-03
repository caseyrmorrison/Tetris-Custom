/*
 * TCSS 305 May 28, 2013 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Board;

/**
 *  The GUI that displays the entire game.
 *  It has a menu bar with two drop down menus, file and help.
 *  
 *  A playing panel that displays the interaction of the game.
 *  
 *  A side panel that has the next piece, the score, and instructions.
 *
 * @author Casey Morrison
 * @version May 28, 2013
 */
@SuppressWarnings("serial")
public class TetrisGUI extends JFrame implements Observer {
  
//  /** The color of the border. */
//  private static final Color DARKER_GRAY = new Color(32, 32, 32);
  
  /** The board used to create and move the blocks. */
  private final Board my_board;
  
  /** The board panel that displays the game. */
  private final BoardPanel my_board_panel;
  
  /** The side panel that holds the score, instructions, and the next piece. */
  private SidePanel my_side_panel;
  
  /**
   * Uninstantiable constructor.
   */
  public TetrisGUI() {
    super("*Tetris*");
    my_board = new Board();
    my_board.addObserver(this);
    my_board_panel = new BoardPanel(my_board);
    final MenuBar menu_bar = new MenuBar(this, my_board_panel, my_board);
    setJMenuBar(menu_bar);
  }

  /**
   * Sets up and displays the GUI for this application.
   */
  public void start() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setLocationByPlatform(true);
    setResizable(false);
    setupLook();  
    setupTitle();
    setVisible(true);
    pack();
  }
  
  /** 
   * Sets up the panels to complete the GUI.
   */
  private void setupLook() {
    my_side_panel = new SidePanel(my_board, my_board_panel);
    add(my_board_panel);
    add(my_side_panel, BorderLayout.EAST);
  }
  
  /**
   * Sets up the title above the game that shows a picture.
   */
  private void setupTitle() {
    final JPanel top = new JPanel();
    top.setBackground(Color.WHITE);
    final Border blackline = BorderFactory.createLineBorder(Color.BLACK, 3);
    top.setBorder(blackline);
    final ImageIcon icon = new ImageIcon("tetris_2.png");
    final JLabel labelholder = new JLabel(icon);
    top.add(labelholder);
    add(top, BorderLayout.NORTH);
  }

  /** {@inheritDoc} */
  @Override
  public void update(final Observable the_arg0, final Object the_arg1) {
    my_board_panel.repaint();
//    my_side_panel.setScore(my_board.getScore());
    my_side_panel.repaint();   
  }
}
