package partchi;

// import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
// import javax.swing.JToggleButton;

// import com.sun.tools.javac.Main;

public class Input extends JPanel implements ActionListener {

	JPanel pChoseDice, pChosePiece, pResults;
	JPanel spDices, spThrow;

	JButton bThrow, tbDice1, tbDice2, tbExtramove;
	// JToggleButton tbDice1,tbDice2,tbExtramove;
	RButton[] bMovePiece;
	JLabel lResults;
	// private ImageIcon[] img;

	public Input() {

		// this.setBounds(700, 0, 300 ,700);
		// this.setBackground(Color.orange);
		this.setLayout(new GridLayout(3, 1));

		pChoseDice = new JPanel(new GridLayout(2, 1));
		pChosePiece = new JPanel(new GridLayout(2, 2));
		pResults = new JPanel();

		this.add(pChoseDice);
		this.add(pChosePiece);
		this.add(pResults);

		spDices = new JPanel(new GridLayout(1, 2));
		spThrow = new JPanel(new GridLayout(2, 1));
		// img = new ImageIcon[6];
		// for(int i=0;i<6;i++) {
		// img[i] = new ImageIcon("dices/"+(i+1)+".png");
		// }

		// tbDice1.setIcon(new ImageIcon("/src/dices/hi.png"));
		// tbDice2.setIcon(img[2]);

		pChoseDice.add(spDices);
		pChoseDice.add(spThrow);

		/* dice toggle button */

		// tbDice1 = new JToggleButton("dice1");
		// tbDice2 = new JToggleButton("dice2");
		// tbExtramove = new JToggleButton("Extra moves");
		tbDice1 = new JButton("dice1");
		tbDice2 = new JButton("dice2");
		tbExtramove = new JButton("Extra moves");
		bThrow = new JButton("throw dices");

		spDices.add(tbDice1);
		spDices.add(tbDice2);

		spThrow.add(tbExtramove);
		spThrow.add(bThrow);

		/* top button */
		bMovePiece = new RButton[4];
		for (int i = 0; i < 4; i++) {
			bMovePiece[i] = new RButton("" + (i + 1) + "");
			pChosePiece.add(bMovePiece[i]);
		}

		bThrow.addActionListener(this);
		tbDice1.addActionListener(this);
		tbDice2.addActionListener(this);
		tbExtramove.addActionListener(this);
		for (int i = 0; i < 4; i++) {
			bMovePiece[i].addActionListener(this);
			bMovePiece[i].setEnabled(false);
		}
		/* result */
		lResults = new JLabel("resultats");

		pResults.add(lResults);
	}

	public void RandomValuedice1() {
		double R = Math.random();
		int b = 0;
		if (R <= 0.166) {
			b = 1;
		}
		if (R > 0.166 && R <= 0.332) {
			b = 2;
		}
		if (R > 0.332 && R <= 0.498) {
			b = 3;
		}
		if (R > 0.498 && R <= 0.664) {
			b = 4;
		}
		if (R > 0.664 && R <= 0.83) {
			b = 5;
		}
		if (R > 0.83) {
			b = 6;
		}
		main.dice1 = b;
	}

	public void RandomValuedice2() {
		double R = Math.random();
		int b = 0;
		if (R <= 0.166) {
			b = 1;
		}
		if (R > 0.166 && R <= 0.332) {
			b = 2;
		}
		if (R > 0.332 && R <= 0.498) {
			b = 3;
		}
		if (R > 0.498 && R <= 0.664) {
			b = 4;
		}
		if (R > 0.664 && R <= 0.83) {
			b = 5;
		}
		if (R > 0.83) {
			b = 6;
		}
		main.dice2 = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == bThrow) {
			synchronized (main.t[0]) {
				RandomValuedice1();
				RandomValuedice2();
				main.t[0].notify();
				bThrow.setEnabled(false);
			}
		}
		if (e.getSource() == tbDice1) {

			synchronized (main.t[2]) {
				if (tbDice1.isSelected()) {
					if (main.dice1 == 5) {
						if (main.homeIsEmpty(main.k)) {
							main.a = main.dice1;
						} else {
							main.a = 1;
						}
					} else
						main.a = main.dice1;
				} else
					main.a = 0;
				try {
					main.mv(main.b, main.x + main.k, main.a);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				main.t[2].notify();
			}
			tbDice1.setEnabled(false);
		}

		if (e.getSource() == tbDice2) {

			synchronized (main.t[2]) {
				if (tbDice2.isSelected())
					if (main.dice1 == 5) {
						if (main.homeIsEmpty(main.k)) {
							main.a = main.dice2;
						} else {
							main.a = 1;
						}
					} else
						main.a = main.dice2;
				else
					main.a = 0;
				try {
					main.mv(main.b, main.x + main.k, main.a);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				main.t[2].notify();
			}
			tbDice2.setEnabled(false);
		}

		if (e.getSource() == tbExtramove) {
			synchronized (main.t[2]) {
				if (tbExtramove.isSelected())
					main.a = main.s;
				else
					main.a = 0;
				main.t[2].notify();
			}
			tbExtramove.setEnabled(false);
		}
		if (e.getSource() == bMovePiece[0]) {
			synchronized (main.t[1]) {
				main.x = 0;

				main.t[1].notify();
			}

		}
		if (e.getSource() == bMovePiece[1]) {
			synchronized (main.t[1]) {
				main.x = 1;

				main.t[1].notify();
			}
		}
		if (e.getSource() == bMovePiece[2]) {
			synchronized (main.t[1]) {
				main.x = 2;

				main.t[1].notify();
			}
		}
		if (e.getSource() == bMovePiece[3]) {

			synchronized (main.t[1]) {
				main.x = 3;

				main.t[1].notify();
			}
		}
	}

}
