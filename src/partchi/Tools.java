package partchi;

import java.awt.Color;

public interface Tools 
{
	
	//color of piece  green/red/yellow/blue
	public  Color[] Colors= {new Color(0, 192, 1),new Color(165, 0, 0),new Color(250, 200, 0),new Color(0, 0, 111)};

	//gray blocks and firstblocks
	public int[] safeBlock ={0,7,12,17,24,29,34,41,46,51,58,63};
	
	
	//start positions
	public static int[] OrigineBlocksX = {
											iorgpos(3),iorgpos(5),iorgpos(3),iorgpos(5),
											iorgpos(16),iorgpos(18),iorgpos(16),iorgpos(18),
											iorgpos(16),iorgpos(18),iorgpos(16),iorgpos(18),
											iorgpos(3),iorgpos(5),iorgpos(3),iorgpos(5),
										 };
	//start position y
	public static int[] OrigineBlocksY = {
											iorgpos(16),iorgpos(16),iorgpos(18),iorgpos(18),
											iorgpos(3),iorgpos(3),iorgpos(5),iorgpos(5),
											iorgpos(16),iorgpos(16),iorgpos(18),iorgpos(18),
											iorgpos(3),iorgpos(3),iorgpos(5),iorgpos(5),
										 };
	
	//easy position double
	static double orgpos(int i)
	{
		return Board.Shift+Board.Box*i;
	}
	//easy postion int
	static int iorgpos(int i)
	{
		return Board.Shift+Board.Box*i;
	}
	
	
	//general path betwwin origine and last safe pathx
	public  double [] pathX= {
								orgpos(10),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(8),orgpos(7),orgpos(6),orgpos(5),orgpos(4),orgpos(3),orgpos(2),orgpos(1),
								orgpos(1),orgpos(1),orgpos(2),orgpos(3),orgpos(4),orgpos(5),orgpos(6),orgpos(7),orgpos(8),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),
								orgpos(11),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(13),orgpos(14),orgpos(15),orgpos(16),orgpos(17),orgpos(18),orgpos(19),orgpos(20),
								orgpos(20),orgpos(20),orgpos(19),orgpos(18),orgpos(17),orgpos(16),orgpos(15),orgpos(14),orgpos(13),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),
								};
	//general path betwwin origine and last safe pathy
	public  double [] pathY= {
								orgpos(1),orgpos(1),orgpos(2),orgpos(3),orgpos(4),orgpos(5),orgpos(6),orgpos(7),orgpos(8),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),
								orgpos(11),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(13),orgpos(14),orgpos(15),orgpos(16),orgpos(17),orgpos(18),orgpos(19),orgpos(20),
								orgpos(20),orgpos(20),orgpos(19),orgpos(18),orgpos(17),orgpos(16),orgpos(15),orgpos(14),orgpos(13),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),orgpos(12),
								orgpos(12),orgpos(12),orgpos(10),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(9),orgpos(8),orgpos(7),orgpos(6),orgpos(5),orgpos(4),orgpos(3),orgpos(2),orgpos(1),
								};
	
	//general path betwwin origine and last safe pathx2
	public  double [] path2X= {
								orgpos(10),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(7),orgpos(6),orgpos(5),orgpos(4),orgpos(3),orgpos(2),orgpos(1),
								orgpos(1),orgpos(1),orgpos(2),orgpos(3),orgpos(4),orgpos(5),orgpos(6),orgpos(7),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),
								orgpos(11),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(14),orgpos(15),orgpos(16),orgpos(17),orgpos(18),orgpos(19),orgpos(20),
								orgpos(20),orgpos(20),orgpos(19),orgpos(18),orgpos(17),orgpos(16),orgpos(15),orgpos(14),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),
								};
	//general path betwwin origine and last safe pathy2
	public  double [] path2Y= {
								orgpos(1),orgpos(1),orgpos(2),orgpos(3),orgpos(4),orgpos(5),orgpos(6),orgpos(7),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),
								orgpos(11),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(14),orgpos(15),orgpos(16),orgpos(17),orgpos(18),orgpos(19),orgpos(20),
								orgpos(20),orgpos(20),orgpos(19),orgpos(18),orgpos(17),orgpos(16),orgpos(15),orgpos(14),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),orgpos(13),
								orgpos(13),orgpos(10),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(8),orgpos(7),orgpos(6),orgpos(5),orgpos(4),orgpos(3),orgpos(2),orgpos(1),
								};
	//last safe path x							
	public double [] safePathX= {	
									orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),
									orgpos(19),orgpos(18),orgpos(17),orgpos(16),orgpos(15),orgpos(14),orgpos(13),orgpos(12),
									orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),
									orgpos(2),orgpos(3),orgpos(4),orgpos(5),orgpos(6),orgpos(7),orgpos(8),orgpos(9),
	};
	//last safe path y
	public double [] safePathY= {
									orgpos(2),orgpos(3),orgpos(4),orgpos(5),orgpos(6),orgpos(7),orgpos(8),orgpos(9),
									orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),
									orgpos(19),orgpos(18),orgpos(17),orgpos(16),orgpos(15),orgpos(14),orgpos(13),orgpos(12),
									orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),
	};
	//last safe path x2
	public double [] safePath2X= {	
									orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),
									orgpos(19),orgpos(18),orgpos(17),orgpos(16),orgpos(15),orgpos(14),orgpos(13),orgpos(12),
									orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),
									orgpos(2),orgpos(3),orgpos(4),orgpos(5),orgpos(6),orgpos(7),orgpos(8),orgpos(9),
	};
	//last safe path y2
	public double [] safePath2Y= {
									orgpos(2),orgpos(3),orgpos(4),orgpos(5),orgpos(6),orgpos(7),orgpos(8),orgpos(9),
									orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),orgpos(11),
									orgpos(19),orgpos(18),orgpos(17),orgpos(16),orgpos(15),orgpos(14),orgpos(13),orgpos(12),
									orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),orgpos(10),
	};
	//fist position a &2
	public double[] firstpos ={pathX[22],pathY[22],pathX[56],pathY[56],pathX[39],pathY[39],pathX[5],pathY[5]};
	public double[] firstpos2 ={pathX[56],pathY[56],path2X[5],path2Y[5],path2X[39],path2Y[39],path2X[22],path2Y[22]};

/*-----------------------------------------------------------------------------------------------*/
	public  static void RandomValuedice1(){
		   double R=Math.random();
		   int b=0;
		   if(R<=0.166){
			   b=1;
			   }
		   if(R>0.166&&R<=0.332){
			   b=2;
			   }
		   if(R>0.332&&R<=0.498){
			   b=3;
			   }
		   if(R>0.498&&R<=0.664){
			   b=4;
			   }
		   if(R>0.664&&R<=0.83){
			   b=5;
			   }
		   if(R>0.83){
			   b=6;
			   }
		   main.dice1= b ;
		}
	public static  void RandomValuedice2(){
		   double R=Math.random();
		   int b=0;
		   if(R<=0.166){
			   b=1;
			   }
		   if(R>0.166&&R<=0.332){
			   b=2;
			   }
		   if(R>0.332&&R<=0.498){
			   b=3;
			   }
		   if(R>0.498&&R<=0.664){
			   b=4;
			   }
		   if(R>0.664&&R<=0.83){
			   b=5;
			   }
		   if(R>0.83){
			   b=6;
			   }
		   main.dice2= b ;
		}


}
