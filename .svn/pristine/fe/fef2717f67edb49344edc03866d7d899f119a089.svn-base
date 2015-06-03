/*
 * TCSS 305 Jun 4, 2013 
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 *
 * @author Casey Morrison
 * @version Jun 4, 2013
 */
@SuppressWarnings("serial")
public class BufferPanel extends JPanel {
  
  /** The x value for drawing the background. */
  private static final int THE_X = -3;
  
  /** The y value for drawing the background. */
  private static final int THE_Y = -4;
  
  /** The color of the background. */
  private static final Color DARKER_RED = new Color(205, 0, 0);

  /** {@inheritDoc} 
   * Draws the background of the instruction panel.
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
      g2d.drawImage(img, null, THE_X, THE_Y);
    } catch (final IOException e) {
      setBackground(DARKER_RED);
    }
  }
}
