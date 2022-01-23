package partchi;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;

public class RButton extends JButton {
  private static final long serialVersionUID = 1L;
  private int r = 100;
  private int x = 24;
  private int y = 8;

  public RButton(String label) {
    super(label);
    Dimension size = new Dimension(65, 65);
    size.width = size.height = Math.max(size.width, size.height);
    setPreferredSize(size);
    this.setFont(new Font("Arial", Font.PLAIN, 40));
    setContentAreaFilled(false);
  }

  protected void paintComponent(Graphics g) {

    Graphics2D g2 = (Graphics2D) g;
    RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    rh.put(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);

    g2.setRenderingHints(rh);
    if (getModel().isArmed()) {
      g2.setColor(Color.orange);
    } else {
      g2.setColor(Color.gray);
    }
    Ellipse2D cercle = new Ellipse2D.Double(x, y, r, r);
    g2.fill(cercle);
    g2.setStroke(new BasicStroke(3));
    super.paintComponent(g2);
  }

  protected void paintBorder(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    rh.put(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);

    g2.setRenderingHints(rh);
    Ellipse2D cercle = new Ellipse2D.Double(x, y, r, r);
    g2.setColor(Color.black);
    g2.draw(cercle);
    super.paintComponent(g2);
  }

}
