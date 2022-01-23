package partchi;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class main implements Tools
{
	
	public static int endOfGamev=0;
	public static Scanner n;
	public static Input i;
	public static int k;
	public static int s=0,a=0,x=0;
	public static int dice1=0,dice2=0;
	public static Board b;
	public static Thread[] t =new Thread[3];
	
	public main() {
		for(int i=0;i<3;i++) {
			t[i] = new Thread();
		}
	}

	public synchronized static void main(String[] args) throws InterruptedException 
	{
		new main();
		ActionListener l = null ;
		JFrame f =new JFrame();
		frameConfig(f);
		b = new Board();
		i = new Input();
		b.setBounds(0, 0, 700, 700);
		i.setBounds(700, 0, 300,700);
		i.setBackground(Color.orange);
		f.add(i);
		f.add(b);
		n = new Scanner(System.in);
	
//		while(!endOfGame()) 
//		{
//			i.bThrow.setEnabled(true);
			
//			for(k=0;k<16;k+=4) {
				mv(b,0,72);
				mv(b,4,72);
				mv(b,8,72);
				mv(b,12,72);
//			}
	
//		}
		

		
	}

	public static void frameConfig(JFrame f)
	{
		f.setLayout(null);
		f.setVisible(true);
		f.setTitle("parchisi");
		f.setSize(1000, 700);
		f.setResizable(false);
		f.setAlwaysOnTop(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void mv(Board b,int x,int n) throws InterruptedException
	{
//		Thread.sleep(2000);
//		b.p[4].firstmove();
//		b.repaint(b.getGraphics());
//		int n=7;
		
			
		if(canmv(b,x,n)) {
		for(int a=b.p[x].getPos(),c=b.p[x].getPos();a<n+c;a++)
		{
			
		b.p[x].move2();
		b.repaint(b.getGraphics());
		Thread.sleep(100);
//		System.out.println("cell:"+b.cell[b.p[x].getBpos()].cp[0].getId()+":"+b.cell[b.p[x].getBpos()].cp[1].getId());
		
		}
		b.p[x].verify1();
		b.repaint(b.getGraphics());
		Thread.sleep(100);
//		ver();
			}
		

	}

	public static void ver() {
		for(int i=0;i<4;i++) {
			System.out.println("------"+(i+1)+"--------");
			for(int j=0;j<17;j++)
			System.out.println("["+(i*17+j)+"]"+Board.cell[i*17+j].n+"    ("+Board.cell[i*17+j].isSafe()+")");
			
		}
		
	}
	
	
	public static boolean endOfGame() {
		if(endOfGamev!=3)return false;
		else return true;
	}
	
	public static boolean homeIsEmpty(int k) {
		for(int i=0;i<4;i++) {
			if(b.p[i+k].getPos()==0)return false;
		}
		return true;
	}
	
	public static boolean allPiecesAtHome(int k) {
		for(int i=0;i<4;i++) {
			if(b.p[i+k].getPos()!=0)return false;
		}
		return true;
	}
	
	public static void ab(int k) {
		for(int j=0;j<4;j++) {
			if(b.p[j+k].getPos()==0) i.bMovePiece[j].setEnabled(false);
			else i.bMovePiece[j].setEnabled(true);
		}
		ad(k);
	}
	
	public static void ad(int k) {
		
			if(dice1==0) i.tbDice1.setEnabled(false);
			else i.tbDice1.setEnabled(true);
			if(dice2==0) i.tbDice2.setEnabled(false);
			else i.tbDice2.setEnabled(true);
			if(s==0) i.tbExtramove.setEnabled(false);
			else i.tbExtramove.setEnabled(true);

	}
	
	public static boolean canmv(Board b,int x,int n) {
		int a;
		int c;
		int e;
		for(a=b.p[x].getPos(),e=b.p[x].getBpos(),c=b.p[x].getPos();a<n+c+1;a++,e++) {
			if(Board.cell[e].isBlocked() )return false;
		}
		if(Board.cell[e-2].isSafe() && !Board.cell[e-2].isEmpty() && b.p[x].getColor()!=b.cell[e-2].cp[0].getColor())return false;
			return true;
	}
	
	public static  Piece maxPP(Board b,int k) {
		int max=0;
		for(int i=0;i<4;i++)
		/*for(int j=3;j>i;j--)*/{
			/*max = (b.p[k+i].getPos() > b.p[k+j].getPos()) ? k+i : k+j;*/
			max= (b.p[k+i].getPos()>=max)?k+i:max;
		}
		return b.p[max];
	}
	
	public static void extra(int k) throws InterruptedException {
		if(s!=0) {
			synchronized(t[1]) {
				t[1].wait();
				mv(b,k+x,s);
				s=0;
				ad(k);
			}
		}
	}
	
	public static void action(int k,Board b) throws InterruptedException {
		


			if(dice1==5 || dice2 ==5) {
				
				if(dice1==5 && dice2==5) { 
					for(int j1=0;j1<2;j1++) {
						if(!homeIsEmpty(k)) {
	
							for(int j=0;j<4;j++) {
								
								if(b.p[k+j].getPos()==0) {
										mv(b,k+j,1);
										ab(k);
										break;
									}
								}
							extra(k);
							
						}
						else {
							synchronized(t[1]) {
								t[1].wait();
								synchronized(t[2]) {
									t[2].wait();
								mv(b,x+k,a);
								ab(k);
								}
							}
							extra(k);
						}
					}
				}
				else {
					synchronized(t[1]) {
						t[1].wait();
						synchronized(t[2]) {
							t[2].wait();
							mv(b,x+k,a);
							ab(k);
						}
					}
					extra(k);
				}
				}
				else {
					while(i.tbDice1.isEnabled() && i.tbDice2.isEnabled() && i.tbExtramove.isEnabled()) {
						synchronized(t[1]) {
							t[1].wait();
							synchronized(t[2]) {
								t[2].wait();
							mv(b,x+k,a);
							ab(k);
							}
						}
						extra(k);}
					}
				
	
//			alse {
//				synchronized(t[1]) {
//					t[1].wait();
//					synchronized(t[2]) {
//						t[2].wait();
//						mv(b,k+x,a);
//					}
//					a=(a==dice1)?dice2:dice1;
//					t[1].wait();
//					mv(b,k+x,a);
//				}
//				extra(k);
//			}
//			
		
		
		
	}
	public static void action1() throws InterruptedException {
	
		dataPrint();
		
	while(i.tbDice1.isEnabled() && i.tbDice1.isEnabled()) {
		//first case
		if(allPiecesAtHome(k)) {
			if(dice1==5 || dice2==5) {
				if(dice1==dice2) {
					for(int j=0,c=0;j<4 && c<2;j++,c++) {
						if(b.p[j+k].getPos()==0) {
							mv(b,j+k,1);
							ab(k);
							if(c==1)break;
						}
					}
					i.tbDice1.setEnabled(false);
					i.tbDice2.setEnabled(false);
				}
				else {
					a=(dice1==5)?1+dice2:1+dice1;
					for(int j=0;j<4;j++) {
						if(b.p[j+k].getPos()==0) {
							mv(b,j+k,a);
							ab(k);
							a=0;
							break;
						}
					}
					i.tbDice1.setEnabled(false);
					i.tbDice2.setEnabled(false);
				}
			}
		}
		else {
			if(homeIsEmpty(k)) {
				organize();
				synchronized(t[1]) {
					t[1].wait();
					synchronized(t[2]) {
						t[2].wait();
						mv(b,x+k,a);
						ab(k);
					}
				}
			}
			else {
				organize();
				if(dice1==5 || dice2==5) {
					if(dice1==dice2) {
						for(int j=0;j<4 ;j++) {
							if(b.p[j+k].getPos()==0) {
								mv(b,j+k,1);
								ab(k);
								break;
							}
						}
						i.tbDice1.setEnabled(false);

						if(!homeIsEmpty(k)) {
							for(int j=0;j<4 ;j++) {
								if(b.p[j+k].getPos()==0) {
									mv(b,j+k,1);
									ab(k);
									break;
								}
							}
							i.tbDice2.setEnabled(false);

						}
						else {
							organize();
							synchronized(t[1]) {
								t[1].wait();
								synchronized(t[2]) {
									t[2].wait();
									mv(b,x+k,a);
									ab(k);
								}
						}
					}
					}
					else {
						organize();
						if(!homeIsEmpty(k)) {
							for(int j=0;j<4 ;j++) {
								if(b.p[j+k].getPos()==0) {
									mv(b,j+k,1);
									ab(k);
									break;
								}
							}
						if(dice1==5)i.tbDice1.setEnabled(false);else i.tbDice2.setEnabled(false);

						}
						organize();
						synchronized(t[1]) {
							t[1].wait();
							synchronized(t[2]) {
								t[2].wait();
								mv(b,x+k,a);
								ab(k);
							}
					}
					}
				}
				else {
					organize();
					synchronized(t[1]) {
						t[1].wait();
						synchronized(t[2]) {
							t[2].wait();
							mv(b,x+k,a);
							ab(k);
						}
					}
				}
			}
		}
	}
	
	
	
	
	
	}
	public static void action2() throws InterruptedException {
		
		action1();
		
		if(dice1==dice2) {
			
			action1();
			
			if(dice1==dice2) {
				
				maxPP(b,k).goBack();
			}
		}
	}
	
	public static void organize() {
		
		desactivateallbtn();
		
		for(int j=0;j<4;j++) {
			if(canmv(b,k+j,dice1))i.bMovePiece[j].setEnabled(true);i.tbDice1.setEnabled(true);
			if(canmv(b,k+j,dice2))i.bMovePiece[j].setEnabled(true);i.tbDice2.setEnabled(true);
			if(canmv(b,k+j,dice1))i.bMovePiece[j].setEnabled(true);i.tbDice1.setEnabled(true);

		}
	}
	
	
	public static void desactivateallbtn() {
		i.tbDice1.setEnabled(false);
		i.tbDice2.setEnabled(false);
		i.tbExtramove.setEnabled(false);
		for(int j=0;j<4;j++) {
			i.bMovePiece[j].setEnabled(false);
		}
	}
	
	public static void dataPrint() {
		System.out.println("Player:"+b.p[k].getId());
		
		System.out.println("dice1:");
		dice1=n.nextInt();
		System.out.println("dice2:");
		dice2=n.nextInt();
		
		System.out.println("Player:"+b.p[k].getId());
		
		System.out.println("dice1:"+dice1);
	
		System.out.println("dice2:"+dice2);
	}

//	@Override
//	public synchronized void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//		if(e.getSource()==bThrow) {
//			Tools.RandomValuedice1();
//			Tools.RandomValuedice2();
////			myThreads[0].notify();
//		}
//		if(e.getSource()==tbDice1) {
//
//		if(tbDice1.isSelected())main.a=main.dice1;
//		else main.a=0;
//		}
//
//		if(e.getSource()==tbDice2) {
//			
//			if(tbDice2.isSelected())main.a=main.dice2;
//			else main.a=0;
//		}
//		
//		if(e.getSource()==tbExtramove) {
//			
//			if(tbExtramove.isSelected())main.a=main.s;
//			else main.a=0;
//		}
//		if(e.getSource()==bMovePiece[0]) {
//			main.x=0;}
//			
////			mv(main.b,k+main.x,main.a);
//		
//		if(e.getSource()==bMovePiece[1]) {
//			main.x=1;
//			
////			mv(main.b,k+main.x,main.a);
//		}
//		if(e.getSource()==bMovePiece[2]) {
//			main.x=2;
//			
////			mv(main.b,k+main.x,main.a);
//		}
//		if(e.getSource()==bMovePiece[3]) {
//			main.x=3;
//			
////			mv(main.b,k+main.x,main.a);
//		}   
//	}

//	public static void createControlPanel(JPanel i/*,ActionListener l*/) {
//		pChoseDice = new JPanel(new GridLayout(2,1));
//		pChosePiece = new JPanel(new GridLayout(2,2));
//		pResults = new JPanel();
//		
//		i.add(pChoseDice);
//		i.add(pChosePiece);
//		i.add(pResults);
//		
//		spDices =new JPanel(new GridLayout(1,2));
//		spThrow = new JPanel(new GridLayout(2,1));
////		img = new ImageIcon[6];
////		for(int i=0;i<6;i++) {
////			 img[i] = new ImageIcon("dices/"+(i+1)+".png");
////
////		}
////		
//		
//		pChoseDice.add(spDices);
//		pChoseDice.add(spThrow);
//		
//		
//		
//		
//		
//		/* dice toggle button*/
//		
//		tbDice1 = new JToggleButton("dice1");
//		tbDice2 = new JToggleButton("dice2");
//		tbExtramove = new JToggleButton("Extra moves");
//		bThrow = new JButton("throw dices");
//	
//		spDices.add(tbDice1);
//		spDices.add(tbDice2);
//		
//		spThrow.add(tbExtramove);
//		spThrow.add(bThrow);
//		
//		
//		/* top button*/
//		bMovePiece = new RButton[4];
//		for(int i1=0;i1<4;i1++) {
//			bMovePiece[i1] = new RButton(""+(i1+1)+"");
//			pChosePiece.add(bMovePiece[i1]);
//		}
//		
////		bThrow.addActionListener(l);
////		tbDice1.addActionListener(l);
////		tbDice2.addActionListener(l);
////		tbExtramove.addActionListener(l);
////		for(int i1=0;i1<4;i1++) {
////			bMovePiece[i1].addActionListener(l);
////		}
//		/*result */
//		lResults = new JLabel("resultats");
//
//		pResults.add(lResults);
//	}
}

	