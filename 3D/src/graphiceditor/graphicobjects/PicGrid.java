package graphiceditor.graphicobjects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PicGrid extends JFrame {

  private static final long serialVersionUID = 1L;

  private final JPanel panel;

  private final JLabel[][] labels;

  private ImageIcon icon;

  private final BufferedImage bi;

  private final int cols;

  private final int rows;

  public PicGrid() {
    bi = loadImage();
    rows = bi.getHeight();
    cols = bi.getWidth();
    panel = new JPanel();
    panel.setLayout( new GridLayout( rows, cols ) );
    labels = new JLabel[rows][cols];
    for ( int i = 0; i < labels.length; i++ ) {
      for ( int j = 0; j < labels[i].length; j++ ) {
        labels[i][j] = new JLabel();
        panel.add( labels[i][j], BorderLayout.CENTER );
      }
    }

    this.add( panel, BorderLayout.CENTER );
    this.setSize( bi.getWidth(), bi.getHeight() );
    this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    this.setLocationRelativeTo( null );
    // Bild erst nach der Definition der Größe importieren
    setImage();
    this.setVisible( true );
  }

  private BufferedImage loadImage() {
    // Create a file chooser
    final JFileChooser fc = new JFileChooser();
    fc.showOpenDialog( new JFrame() );
    File imgFile = fc.getSelectedFile();
    BufferedImage buff = null;
    try {
      buff = ImageIO.read( imgFile );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
    return buff;
  }

  private void setImage() {
    Image newImg;
    for ( int i = 0; i < rows; i++ ) {
      for ( int j = 0; j < cols; j++ ) {
        newImg = bi.getSubimage( j, i, 1, 1 );
        System.out.println( new Color( bi.getRGB( j, i ) ) );
        icon = new ImageIcon( newImg );
        System.out.println( i + "x" + j );
        labels[i][j].setIcon( icon );
      }
    }
  }

  public static void main( String[] args ) {
    new PicGrid();
  }
}