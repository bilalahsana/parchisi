package partchi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Board extends JPanel implements Tools {

	static public Piece[] p = { new Piece(0), new Piece(1), new Piece(2), new Piece(3), new Piece(4), new Piece(5),
			new Piece(6), new Piece(7), new Piece(8), new Piece(9), new Piece(10), new Piece(11), new Piece(12),
			new Piece(13), new Piece(14), new Piece(15) };

	private static final long serialVersionUID = 1L;

	private int[][] table = {
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 1, 1, 1, 1, 1, 1, 1, 0, 0, 9, 9, 0, 0, 2, 2, 2, 2, 2, 2, 2, 5 },
			{ 5, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 2, 2, 2, 2, 2, 2, 2, 5 },
			{ 5, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 2, 2, 2, 2, 2, 2, 2, 5 },
			{ 5, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 2, 2, 2, 2, 2, 2, 2, 5 },
			{ 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 9, 2, 2, 2, 2, 2, 2, 2, 5 },
			{ 5, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 2, 2, 2, 2, 2, 2, 2, 5 },
			{ 5, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 2, 2, 2, 2, 2, 2, 2, 5 },
			{ 5, 0, 0, 0, 0, 9, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 5 },
			{ 5, 0, 0, 0, 0, 9, 0, 0, 0, 6, 1, 1, 6, 0, 0, 0, 2, 0, 0, 0, 0, 5 },
			{ 5, 9, 4, 4, 4, 4, 4, 4, 4, 4, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 9, 5 },
			{ 5, 9, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 2, 2, 2, 2, 2, 2, 2, 2, 9, 5 },
			{ 5, 0, 0, 0, 0, 4, 0, 0, 0, 6, 3, 3, 6, 0, 0, 0, 9, 0, 0, 0, 0, 5 },
			{ 5, 0, 0, 0, 0, 4, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 9, 0, 0, 0, 0, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 0, 0, 3, 3, 0, 0, 3, 3, 3, 3, 3, 3, 3, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 0, 0, 3, 3, 0, 0, 3, 3, 3, 3, 3, 3, 3, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 9, 9, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 0, 0, 3, 3, 0, 0, 3, 3, 3, 3, 3, 3, 3, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 0, 0, 3, 3, 0, 0, 3, 3, 3, 3, 3, 3, 3, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 0, 0, 3, 3, 0, 0, 3, 3, 3, 3, 3, 3, 3, 5 },
			{ 5, 4, 4, 4, 4, 4, 4, 4, 0, 0, 9, 9, 0, 0, 3, 3, 3, 3, 3, 3, 3, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }
	};

	static public int numberOfPlayers = 4;

	// private static boolean begin = true;

	public static final int Box = 30;
	public static final int Shift = 0;
	public static final int GroupeShift = Box * 11;

	/* Block */
	public static Block[] cell = new Block[100];

	public Board() {
		createCell(cell);

	}

	public static void createCell(Block[] c) {
		for (int i = 0, j = 0; i < 100 && j < 32; i++) {
			if (i < 68) {
				c[i] = new Block(i, pathX[i], pathY[i], path2X[i], path2Y[i]);
				continue;
			} else
				c[i] = new Block(i, safePathX[j], safePathY[j], safePath2X[j], safePath2Y[j]);
			j++;
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		g2.setRenderingHints(rh);

		for (int i = 0; i < this.table.length; i++) {

			for (int j = 0; j < this.table.length; j++) {

				if (this.table[i][j] == 0) {

					g.setColor(Color.WHITE);
					g.fillRect(Shift + j * Box, Shift + i * Box,
							Box, Box);
				}

				// Mur.
				else if (this.table[i][j] == 1)

				{
					g.setColor(Color.BLUE);
					g.fillRect(Shift + j * Box, Shift + i * Box,
							Box, Box);
				} else if (this.table[i][j] == 2)

				{
					g.setColor(Color.red);
					g.fillRect(Shift + j * Box, Shift + i * Box,
							Box, Box);
				} else if (this.table[i][j] == 3)

				{
					g.setColor(Color.yellow);
					g.fillRect(Shift + j * Box, Shift + i * Box,
							Box, Box);
				} else if (this.table[i][j] == 4)

				{
					g.setColor(Color.green);
					g.fillRect(Shift + j * Box, Shift + i * Box,
							Box, Box);
				} else if (this.table[i][j] == 9)

				{
					g.setColor(Color.gray);
					g.fillRect(Shift + j * Box, Shift + i * Box,
							Box, Box);
				} else if (this.table[i][j] == 5)

				{
					g.setColor(Color.black);
					g.fillRect(Shift + j * Box, Shift + i * Box,
							Box, Box);
				}
			}
		}

		for (int k = 1, t = 2; k < 3 && t > 0; k++, t--) {
			for (int i = 1; i < 15; i += 13) {
				for (int j = 8; j < 13; j += 2) {
					for (int m = 0; m < 7; m++)
						if (k == 2)
							g.drawRect(Shift + j * Box, Shift + (m + i) * Box, Box * k, Box * t);
						else
							g.drawRect(Shift + (m + i) * Box, Shift + j * Box, Box * k, Box * t);
				}
			}
		}

		g.drawLine(Shift + 8 * Box, Shift + 8 * Box, Shift + 9 * Box, Shift + 9 * Box);
		g.drawLine(Shift + 13 * Box, Shift + 9 * Box, Shift + 14 * Box, Shift + 8 * Box);
		g.drawLine(Shift + 8 * Box, Shift + 14 * Box, Shift + 9 * Box, Shift + 13 * Box);
		g.drawLine(Shift + 13 * Box, Shift + 13 * Box, Shift + 14 * Box, Shift + 14 * Box);
		g.setColor(Color.GREEN);
		g.fillPolygon(new int[] { Shift + 9 * Box, Shift + 11 * Box, Shift + 9 * Box },
				new int[] { Shift + 9 * Box, Shift + 11 * Box, Shift + 13 * Box }, 3);
		g.setColor(Color.BLUE);
		g.fillPolygon(new int[] { Shift + 9 * Box, Shift + 11 * Box, Shift + 13 * Box },
				new int[] { Shift + 9 * Box, Shift + 11 * Box, Shift + 9 * Box }, 3);
		g.setColor(Color.RED);
		g.fillPolygon(new int[] { Shift + 13 * Box, Shift + 11 * Box, Shift + 13 * Box },
				new int[] { Shift + 9 * Box, Shift + 11 * Box, Shift + 13 * Box }, 3);
		g.setColor(Color.YELLOW);
		g.fillPolygon(new int[] { Shift + 9 * Box, Shift + 11 * Box, Shift + 13 * Box },
				new int[] { Shift + 13 * Box, Shift + 11 * Box, Shift + 13 * Box }, 3);
		g.setColor(Color.BLACK);
		g.drawRect(Shift + 9 * Box, Shift + 9 * Box, 4 * Box, 4 * Box);
		g.drawRect(Shift + 8 * Box, Shift + 10 * Box, Box, 2 * Box);
		g.drawRect(Shift + 13 * Box, Shift + 10 * Box, Box, 2 * Box);
		g.drawRect(Shift + 10 * Box, Shift + 8 * Box, 2 * Box, Box);
		g.drawRect(Shift + 10 * Box, Shift + 13 * Box, 2 * Box, Box);

		// if(begin)
		// {
		for (int i = 0; i < numberOfPlayers * 4; i++) {
			// p[i] = new Piece(i);
			p[i].paint(g2);
			// begin=false;
		}
		// }
	}

	public void repaint(Graphics g) {
		// this.paint(g);
		super.repaint();
		// for(int i=0;i<numberOfPlayers*4;i++)
		// {
		//
		// p[i].paint(g);
		// }
	}

}