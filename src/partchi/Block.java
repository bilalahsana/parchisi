package partchi;

public class Block implements Tools
{
	
	public Piece[] cp= new Piece[2];
	protected int pos;
	protected double posx;
	protected double posy;
	protected double posx2;
	protected double posy2;
	protected  int n=0;
	protected boolean safe;
	protected boolean end;
	

	public Block(int i,double x,double y,double x2,double y2) {
		this.pos=i;
		this.posx=x;
		this.posy=y;
		this.posx2=x2;
		this.posy2=y2;
		this.cp[0]=null;
		this.cp[1]=null;
		for(int a=0;a<100;a++)
		{
//		if(i==0 || i==7 || i==12 || i==17 || i==24 || i==29 || i==34 || i==41 || i==46 || i==51 || i==58 || i==63 )this.safe=true;
//		else if(i<68)this.safe=false;
//		else this.safe=true;
			if(i<68) {
				if(i==0 || i==5 || i==12 || i==17 || i==22 || i==29 || i==34 || i==39 || i==46 || i==51 || i==56 || i==63)this.safe=true;
				else this.safe=false;
			}
			else this.safe=true;
		}
	}
	
	public double getPosX()
	{
		return this.posx;
	}
	
	public double getPosX2()
	{
		return this.posx2;
	}
	
	void addP(Piece a)
	{
//		this.n++;
		if (this.isEmpty()) {this.cp[0]=a;this.n=1;}
		else if(!this.isEmpty() && !this.isBlocked()) {this.cp[1]=a;this.n=2;}
//		else {this.cp[0]=a;this.n=1;})) {
	}
	
	void delP()
	{
//		this.n--;
		if (!this.isEmpty() && !this.isBlocked()) {this.cp[0]=null;this.n=0;}
		else if(this.isBlocked()){this.cp[0]=this.cp[1];this.cp[1]=null;this.n=1;}
	}
	
	
//	public void one() {
//		this.n++;
//	}
//	public void zero() {
//		this.n--;
//	}
//	
//	public void block() {
//		this.n=2;
//	}
	public double getPosY()
	{
		return this.posy;
	}
	
	public double getPosY2()
	{
		return this.posy2;
	}
	
	boolean isEmpty()
	{	
		if(n==0)return true;
		else return false;
	}
	
	boolean isSafe()
	{	
		return safe;
	}
	
	boolean isBlocked()
	{
		if(n==2)return true;
		else return false;
	}
	
//	int getColor() 
//	{
//		return 0;
//	}

}