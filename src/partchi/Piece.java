package partchi;

import java.awt.BasicStroke;
import java.awt.Color;
// import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Piece implements Tools {

	private int OriginePositionX;
	private int OriginePositionY;
	private double firstPositionX;
	private double firstPositionY;
	private double firstPositionX2;
	private double firstPositionY2;
	private double positionX;
	private double positionY;
	private Color color;
	private int rayon = 30;
	private int id;
	private int pos;
	// private static int o=0;
	private int cb;

	public Piece(int a) {

		if (a >= 0 && a < 4) {
			this.id = 1;
			this.color = Colors[0];
			this.firstPositionX = firstpos[0];
			this.firstPositionY = firstpos[1];
			this.firstPositionX2 = firstpos2[0];
			this.firstPositionY2 = firstpos2[1];
		}
		if (a >= 4 && a < 8) {
			this.id = 2;
			this.color = Colors[1];
			this.firstPositionX = firstpos[2];
			this.firstPositionY = firstpos[3];
			this.firstPositionX2 = firstpos2[2];
			this.firstPositionY2 = firstpos2[3];
		}
		if (a >= 8 && a < 12) {
			this.id = 3;
			this.color = Colors[2];
			this.firstPositionX = firstpos[4];
			this.firstPositionY = firstpos[5];
			this.firstPositionX2 = firstpos2[4];
			this.firstPositionY2 = firstpos2[5];
		}
		if (a >= 12 && a < 16) {
			this.id = 4;
			this.color = Colors[3];
			this.firstPositionX = firstpos[6];
			this.firstPositionY = firstpos[7];
			this.firstPositionX2 = firstpos2[6];
			this.firstPositionY2 = firstpos2[7];
		}
		this.OriginePositionX = OrigineBlocksX[a];
		this.OriginePositionY = OrigineBlocksY[a];
		this.positionX = this.OriginePositionX;
		this.positionY = this.OriginePositionY;
		this.pos = 0;

	}

	public int getcBpos() {
		if (this.id == 1)
			return pos + 22;
		if (this.id == 2)
			return pos + 56;
		if (this.id == 3)
			return pos + 39;
		if (this.id == 4)
			return pos + 5;
		else
			return 0;
	}

	public int getBpos() {

		if (pos < 64) {
			if (this.getcBpos() > 67)
				return this.getcBpos() - 68;
			else
				return this.getcBpos();
		} else {
			if (this.id == 1)
				return this.pos + 28;
			if (this.id == 2)
				return this.pos + 12;
			if (this.id == 3)
				return this.pos + 20;
			if (this.id == 4)
				return this.pos + 4;

		}
		return 0;
	}

	public int getPos() {
		return pos;
	}

	public int getId() {
		return this.id;
	}

	public int getX() {
		return (int) positionX;
	}

	public int getY() {
		return (int) positionY;
	}

	public void move() {
		// Board.cell[this.getBpos()].delP(this);
		if (Board.cell[this.getBpos() + 1].isEmpty()) {

			this.positionX = Board.cell[this.getBpos()].getPosX();
			this.positionY = Board.cell[this.getBpos()].getPosY();
		} else if (!(Board.cell[this.getBpos() + 1].isEmpty() || Board.cell[this.getBpos() + 1].isBlocked())) {
			this.positionX = Board.cell[this.getBpos()].getPosX2();
			this.positionY = Board.cell[this.getBpos()].getPosY2();
		}

		this.pos++;
		// if(pos>1)Board.cell[this.getBpos()-1].delP();
		if (pos < 72)
			Board.cell[this.getBpos()].addP(this);

		this.verify();
	}

	public void move1() {
		if (this.getPos() > 0)
			Board.cell[this.getBpos()].delP();

		if (this.getPos() == 71) {
			this.positionX = Board.cell[this.getBpos()].getPosX();
			this.positionY = Board.cell[this.getBpos()].getPosY();
			Board.cell[this.getBpos() - 1].delP();
			Board.cell[this.getBpos()].addP(this);
			pos++;
			return;
		}
		if (this.getPos() == 0) {
			if (Board.cell[this.getBpos()].isEmpty())
				this.firstmove();
			else
				this.firstmove2();
			Board.cell[this.getBpos() - 1].addP(this);
			return;
		}
		if (Board.cell[this.getBpos()].isEmpty()) {

			this.positionX = Board.cell[this.getBpos()].getPosX();
			this.positionY = Board.cell[this.getBpos()].getPosY();

		} else {
			this.positionX = Board.cell[this.getBpos()].getPosX2();
			this.positionY = Board.cell[this.getBpos()].getPosY2();

		}

		this.pos++;

		Board.cell[this.getBpos()].addP(this);
		this.verify();
	}

	public void move2() {

		if (pos > 0)
			Board.cell[cb].delP();
		this.cb = this.getBpos();
		if (Board.cell[this.getBpos()].isEmpty()) {

			this.positionX = Board.cell[this.getBpos()].getPosX();
			this.positionY = Board.cell[this.getBpos()].getPosY();
		} else if (!(Board.cell[this.getBpos()].isEmpty() || Board.cell[this.getBpos()].isBlocked())) {
			this.positionX = Board.cell[this.getBpos()].getPosX2();
			this.positionY = Board.cell[this.getBpos()].getPosY2();
		}
		Board.cell[this.getBpos()].addP(this);

		this.pos++;
		// verify1();
	}

	public void verify() {
		if (!Board.cell[this.cb].isSafe() && Board.cell[this.cb].isBlocked()
				&& Board.cell[this.cb].cp[0].getColor() != Board.cell[this.cb].cp[1].getColor()) {
			Board.cell[this.cb].cp[0].goBack();
			Board.cell[this.cb].addP(this);
			this.positionX = Board.cell[this.cb].getPosX();
			this.positionY = Board.cell[this.cb].getPosY();
		}
		if (this.getPos() == 72)
			main.s = 20;
	}

	public void verify1() {
		if (!Board.cell[this.cb].isSafe() && Board.cell[this.cb].isBlocked()
				&& Board.cell[this.cb].cp[0].getColor() != Board.cell[this.cb].cp[1].getColor()) {
			Board.cell[this.cb].cp[0].goBack();
			main.s = 10;
			Board.cell[this.cb].cp[0] = Board.cell[this.cb].cp[1];
			Board.cell[this.cb].cp[1] = null;
			Board.cell[this.cb].addP(this);
			this.positionX = Board.cell[this.cb].getPosX();
			this.positionY = Board.cell[this.cb].getPosY();
			Board.cell[this.cb].n = 1;
		}
		if (this.getPos() == 72)
			main.s = 20;
	}

	// public void move(int i)
	// {
	// int a=i;
	// int l=pos;
	// if(this.id==1)a= i+22;l=pos+22;
	// if(this.id==2)a= i+56;l=pos+56;
	// if(this.id==3)a= i+39;l=pos+39;
	// if(this.id==4)a= i+5;l=pos+5;
	//
	//
	// if(pos<65)
	// {
	// if(a>=68)
	// {
	// Board.cell[l].delP(this);
	// this.positionX=Board.cell[a-68].getPosX();
	// this.positionY=Board.cell[a-68].getPosY();
	// Board.cell[a-68].addP(this);
	// pos++;
	// }
	// else
	// {
	//// Board.cell[a-1].zero();
	// this.positionX=Board.cell[a].getPosX();
	// this.positionY=Board.cell[a].getPosY();
	// pos++;
	// }
	// }
	// else
	// {
	// if(id==1)
	// {
	//// Board.cell[a-68].zero();
	// this.positionX=Board.cell[92+o].getPosX();
	// this.positionY=Board.cell[92+o].getPosY();
	// }
	// if(id==2)
	// {
	// this.positionX=Board.cell[76+o].getPosX();
	// this.positionY=Board.cell[76+o].getPosY();
	// }
	// if(id==3)
	// {
	// this.positionX=Board.cell[84+o].getPosX();
	// this.positionY=Board.cell[84+o].getPosY();
	// }
	// if(id==4)
	// {
	// this.positionX=Board.cell[68+o].getPosX();
	// this.positionY=Board.cell[68+o].getPosY();
	// }
	// o++;
	// pos++;
	// }
	//
	//
	// }

	public void firstmove() {
		this.positionX = this.firstPositionX;
		this.positionY = this.firstPositionY;
		this.pos = 1;
		if (id == 1)
			main.i.bMovePiece[0].setEnabled(true);
		if (id == 2)
			main.i.bMovePiece[1].setEnabled(true);
		if (id == 3)
			main.i.bMovePiece[2].setEnabled(true);
		if (id == 4)
			main.i.bMovePiece[3].setEnabled(true);

	}

	public void firstmove2() {
		this.positionX = this.firstPositionX2;
		this.positionY = this.firstPositionY2;
		this.pos = 1;
		if (id == 1)
			main.i.bMovePiece[0].setEnabled(true);
		if (id == 2)
			main.i.bMovePiece[1].setEnabled(true);
		if (id == 3)
			main.i.bMovePiece[2].setEnabled(true);
		if (id == 4)
			main.i.bMovePiece[3].setEnabled(true);
	}

	public void goBack() {
		this.positionX = this.OriginePositionX;
		this.positionY = this.OriginePositionY;
		this.pos = 0;

	}

	public Color getColor() {
		return this.color;
	}

	public void paint(Graphics2D g) {

		// g.setColor(color);
		// g.fillOval(getX(), getY(), rayon, rayon);
		// g.setColor(Color.black);
		// g.drawOval(getX(), getY(), rayon-1, rayon-1);

		Ellipse2D cercle = new Ellipse2D.Double(this.getX(), this.getY(), rayon, rayon);
		g.setColor(this.color);
		g.fill(cercle);
		g.setStroke(new BasicStroke(2));
		g.setColor(Color.BLACK);
		g.draw(cercle);

	}

}