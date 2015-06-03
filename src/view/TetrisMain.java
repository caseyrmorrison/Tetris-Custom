/*
 * TCSS 305 May 28, 2013 
 */
package view;

//import javax.swing.JOptionPane;
//import javax.swing.UIManager;
//import javax.swing.UIManager.LookAndFeelInfo;
//import javax.swing.UnsupportedLookAndFeelException;

/**
 * Runs Tetris by instantiating and starting the TetrisGUI.
 * 
 * ***************************************************************************************
 * Comment in the imports and the code to change the look-and-feel to make a cleaner look!
 * Although the color button can't change color.
 * ***************************************************************************************
 * 
 * @author Casey Morrison
 * @version Spring 2013
 */
public final class TetrisMain {

  /**
   * Private constructor, to prevent instantiation of this class.
   */
  private TetrisMain() {
    // Doesn't allow instantiation.
    throw new IllegalStateException();
  }

  /**
   * The main method, invokes the PowerPaint GUI. Command line arguments are
   * ignored.
   * 
   * @param the_args Command line arguments.
   * @throws IllegalAccessException 
   * @throws InstantiationException 
   * @throws ClassNotFoundException 
   */
  public static void main(final String[] the_args) throws ClassNotFoundException,
                                                          InstantiationException,
                                                          IllegalAccessException {
    //code to change the look-and-feel to nimbus
    //************************************************************************************
//    try {
//      for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//        if ("Nimbus".equals(info.getName())) {
//          UIManager.setLookAndFeel(info.getClassName());
//          break;
//        }
//      }
//    } catch (final UnsupportedLookAndFeelException e) {
//      // If Nimbus is not available, you can set the GUI to another look and feel.
//      // Later change this to choose another option.
//      JOptionPane.showMessageDialog(null, "Invalid Look and Feel.", 
//                                    "Error", JOptionPane.ERROR_MESSAGE);
//    }
    //************************************************************************************
    final TetrisGUI gui = new TetrisGUI();
    gui.start();
  }
}