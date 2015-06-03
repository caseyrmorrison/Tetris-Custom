/*
 * TCSS 305 May 29, 2013 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import model.Board;

/**
 * The MenuBar is an object that creates a menu bar at the top of the frame.
 * The MenuBar consists of a file menu and a help menu.
 *
 * @author Casey Morrison
 * @version May 29, 2013
 */
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar implements Observer {
  
  /** The easy delay time. */
  private static final int DELAY1 = 2000;
  
  /** The kind of easy delay time. */
  private static final int DELAY2 = 1600;
  
  /** The average delay time. */
  private static final int DELAY3 = 800;
  
  /** The kind of hard delay time. */
  private static final int DELAY4 = 400;
  
  /** The hard delay time. */
  private static final int DELAY5 = 200;
  
  /** The really hard file drop down menu. */
  private final JMenu my_filemenu = new JMenu("File");
  
  /** The options drop down menu. */
  private final JMenu my_optionsmenu = new JMenu("Options");
  
  /** The help drop down menu. */
  private final JMenu my_helpmenu = new JMenu("Help");
  
  /** The quit button. */
  private final JMenuItem my_quit_button = new JMenuItem("Quit", 'q');
  
  /** The new game button. */
  private final JMenuItem my_new_game_button = new JMenuItem("New Game", 'N');
  
  /** The pause button. */
  private final JMenuItem my_pause_button = new JMenuItem("Pause", 'p');
  
  /** The pause button. */
  private final JMenuItem my_end_button = new JMenuItem("End Game", 'E');
  
  /** The instructions button. */
  private final JMenuItem my_instructions = new JMenuItem("Instructions", 'I');
  
  /** The menu item for setting the difficulty menu. */
  private JMenu my_difficultymenu;
  
  /** A button group for the difficulty radio buttons. */
  private final ButtonGroup my_difficulty_group = new ButtonGroup();
  
  /** The board panel used to draw the game and restart the game. */
  private final BoardPanel my_board_panel;

  /** The board used for restarting the game when you click new game in the file menu. */
  private final Board my_board;

  /**
   * Sets up the Menu bar.
   * @param the_frame - the frame this bar is attached to.
   * @param the_board_panel - draws the game to play Tetris.
   * @param the_board - the board used to restart the game in this menu.
   */
  public MenuBar(final JFrame the_frame, final BoardPanel the_board_panel,
                 final Board the_board) {
    super();
    my_board = the_board;
    my_board_panel = the_board_panel;
    my_quit_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent the_event) {
        the_frame.dispose();
      }
    });
    setupFileMenu();
    setupOptionsMenu();
    setupHelpMenu();
    
    add(my_filemenu);
    add(my_optionsmenu);
    add(my_helpmenu);
  }

  /** 
   * Sets up the file menu.
   * The new game button resets the game.
   * The pause button pauses the game.
   * The exit button exits the program.
   */
  private void setupFileMenu() {
    my_filemenu.setMnemonic(KeyEvent.VK_F);
    
    my_new_game_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent the_event) {
        my_board.newGame(my_board.getWidth(), my_board.getHeight(), null);
        my_difficultymenu.setEnabled(true);
        my_board_panel.reset();
      }
    });
    my_filemenu.add(my_new_game_button);
    
    my_pause_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent the_event) {
        my_board_panel.pause();
      }
    });
    
    setupEndGame();
    
    my_filemenu.add(my_pause_button);
    my_filemenu.add(my_end_button);
    my_filemenu.addSeparator();
    my_filemenu.add(my_quit_button);
  }
  
  /**
   * Sets up the end game button which suspends the game.
   */
  private void setupEndGame() {
    my_end_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent the_event) {
        my_board_panel.endGame();
      }
    });
  }
  
  /** 
   * Sets up the options menu.
   * The grid button sets the grid visible or not visible.
   * The reverse button turn the game play upside down.
   * The reverse and grid buttons are set to last through new game play.
   * That way if a player sets it on and likes it their new game has 
   * the same features already on. 
   */
  private void setupOptionsMenu() {
    my_optionsmenu.setMnemonic(KeyEvent.VK_O);
    my_board.addObserver(this);
    
    setupGrid();
    setupReverse();
    setupMirror();
    setupDifficulty();
  }
  
  /**
   * Sets up the grid button.
   * If the game is ended by the player, don't display.
   */
  private void setupGrid() {
    final JCheckBoxMenuItem grid = new JCheckBoxMenuItem("Grid");
    grid.setMnemonic(KeyEvent.VK_G);
    grid.setToolTipText("Turn the grid on for easier game play");
    grid.addActionListener(new ActionListener() { 
      public void actionPerformed(final ActionEvent the_event) {
        if (grid.getState()) {
          my_board_panel.setGrid(true);
          if (!my_board_panel.isEndGame()) {
            my_board_panel.repaint();
          }
        } else {
          my_board_panel.setGrid(false);
          if (!my_board_panel.isEndGame()) {
            my_board_panel.repaint();
          }
        }
      }
    });
    my_optionsmenu.add(grid);
  }
  
  /**
   * Sets up the reverse button.
   * If the game is ended by the player, don't display.
   */
  private void setupReverse() {
    final JCheckBoxMenuItem upsidedown = new JCheckBoxMenuItem("Reverse");
    upsidedown.setMnemonic(KeyEvent.VK_R);
    upsidedown.setToolTipText("Play the game upside down, the blocks flow up!");
    upsidedown.addActionListener(new ActionListener() { 
      public void actionPerformed(final ActionEvent the_event) {
        if (upsidedown.getState()) {
          my_board_panel.setUpsideDown(true);
          if (!my_board_panel.isEndGame()) {
            my_board_panel.repaint();
          }
        } else {
          my_board_panel.setUpsideDown(false);
          if (!my_board_panel.isEndGame()) {
            my_board_panel.repaint();
          }
        }
      }
    });
    my_optionsmenu.add(upsidedown);
  }
  
  /**
   * Sets up the mirror button.
   */
  private void setupMirror() {
    final JCheckBoxMenuItem mirror = new JCheckBoxMenuItem("Mirror Keys");
    mirror.setMnemonic(KeyEvent.VK_M);
    mirror.setToolTipText("Left is right, Right is left... Good Luck!");
    mirror.addActionListener(new ActionListener() { 
      public void actionPerformed(final ActionEvent the_event) {
        if (mirror.getState()) {
          my_board_panel.setMirror(true);
          my_board_panel.pause();
          final String str = new String("*Mirror keys is on:\nMove Left: D\nMove Right: A");
          JOptionPane.showMessageDialog(null, str, "How to play with Mirror Keys: ",
                                        JOptionPane.INFORMATION_MESSAGE);
          my_board_panel.pause();
        } else {
          my_board_panel.setMirror(false);
        }
        
      }
    });
    my_optionsmenu.add(mirror);
  }
  
  /**
   * Sets up the difficulty buttons in the options menu.
   */
  private void setupDifficulty() {
    my_difficultymenu = new JMenu("How Tough Are You?");
    my_difficultymenu.setToolTipText("Set Difficulty");
    my_difficultymenu.setMnemonic(KeyEvent.VK_H);
    
    final JRadioButtonMenuItem easy = new JRadioButtonMenuItem("I'm a Pu**y");
    easy.setMnemonic(KeyEvent.VK_P);
    easy.setToolTipText("Easy");
    easy.addActionListener(new ActionListener() { 
      public void actionPerformed(final ActionEvent the_event) {
        my_board_panel.setDelay(DELAY1);
      }
    });
    
    final JRadioButtonMenuItem easymedium = new JRadioButtonMenuItem("Don't hurt me");
    easymedium.setMnemonic(KeyEvent.VK_D);
    easymedium.setToolTipText("Semi-Easy");
    easymedium.addActionListener(new ActionListener() { 
      public void actionPerformed(final ActionEvent the_event) {
        my_board_panel.setDelay(DELAY2);
      }
    });
    
    final JRadioButtonMenuItem medium = new JRadioButtonMenuItem("Bring em' on!", true);
    medium.setMnemonic(KeyEvent.VK_B);
    medium.setToolTipText("Medium");
    medium.addActionListener(new ActionListener() { 
      public void actionPerformed(final ActionEvent the_event) {
        my_board_panel.setDelay(DELAY3);
      }
    });
    
    final JRadioButtonMenuItem mediumhard = new JRadioButtonMenuItem("Let's kick A**!!");
    mediumhard.setMnemonic(KeyEvent.VK_A);
    mediumhard.setToolTipText("Medium-Hard");
    mediumhard.addActionListener(new ActionListener() { 
      public void actionPerformed(final ActionEvent the_event) {
        my_board_panel.setDelay(DELAY4);
      }
    });
    
    final JRadioButtonMenuItem hard = new JRadioButtonMenuItem("I'm insane!!!");
    hard.setMnemonic(KeyEvent.VK_I);
    hard.setToolTipText("Hard");
    hard.addActionListener(new ActionListener() { 
      public void actionPerformed(final ActionEvent the_event) {
        my_board_panel.setDelay(DELAY5);
      }
    });
    
    final JRadioButtonMenuItem hardest = new JRadioButtonMenuItem("Impossible...");
    hardest.setMnemonic(KeyEvent.VK_M);
    hardest.setToolTipText("Very Hard");
    hardest.addActionListener(new ActionListener() { 
      public void actionPerformed(final ActionEvent the_event) {
        my_board_panel.setDelay(0);
      }
    });
    
    my_difficulty_group.add(easy);
    my_difficulty_group.add(easymedium);
    my_difficulty_group.add(medium);
    my_difficulty_group.add(mediumhard);
    my_difficulty_group.add(hard);
    my_difficulty_group.add(hardest);
    my_difficultymenu.add(easy);
    my_difficultymenu.add(easymedium);
    my_difficultymenu.add(medium);
    my_difficultymenu.add(mediumhard);
    my_difficultymenu.add(hard);
    my_difficultymenu.add(hardest);
    
    if (my_board_panel.isStartState()) {
      my_difficultymenu.setEnabled(false);
      repaint();
    }
    
    my_optionsmenu.addSeparator();
    my_optionsmenu.add(my_difficultymenu);
  }
  
  /** 
   * Sets up the help menu.
   * The about button has a short description about the making of the game.
   * The instructions button tells you how to play the game.
   */
  private void setupHelpMenu() {
    my_helpmenu.setMnemonic(KeyEvent.VK_H);

    final JMenuItem about = new JMenuItem("About...", 'A');
    about.addActionListener(new ActionListener() { 
      public void actionPerformed(final ActionEvent the_event) {
        my_board_panel.pause();
        JOptionPane.showMessageDialog(null, "Implemented by:\n\n Casey Morrison, 5/29/2013.", 
                                      "About", JOptionPane.INFORMATION_MESSAGE);
        my_board_panel.pause();
      }
    });
    setupInstructions();
    my_helpmenu.add(my_instructions);
    my_helpmenu.addSeparator();
    my_helpmenu.add(about);
  }
  
  /**
   * Sets up the instructions in the help menu.
   * Tells you how to play the game.
   */
  private void setupInstructions() {
    my_instructions.addActionListener(new ActionListener() { 
      public void actionPerformed(final ActionEvent the_event) {
        my_board_panel.pause();
        final String str = new String("Move Left: A\nMove Right: D\nMove Down: S\n"
            + "Rotate: W\nDrop: Space Bar\nPause: P\n\n* If mirror keys is on:" 
            + "\nMove Left: D\nMove Right: A");
        JOptionPane.showMessageDialog(null, str, "How to play: ",
                                      JOptionPane.INFORMATION_MESSAGE);
        my_board_panel.pause();
      }
    });
  }

  @Override
  public void update(final Observable the_arg0, final Object the_arg1) {
    if (my_board_panel.isStartState()) {
      my_difficultymenu.setEnabled(false);
    } else {
      my_difficultymenu.setEnabled(true);
    }
    if (my_board_panel.isEndGame()) {
      my_difficultymenu.setEnabled(true);
    }
    if (my_board.gameIsOver()) {
      my_difficultymenu.setEnabled(true);
    }
  }
}
