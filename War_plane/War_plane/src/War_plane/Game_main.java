package War_plane;
public class Game_main{
	public final int width,weight;
	 Game_menu b;
	 Thread thread1;
	public Game_main(int x,int y)
	{  
		 width=x;
		 weight=y;
		 b = new Game_menu(width,weight); 
	     thread1 = new Thread(b);
	     thread1.start();

	    
	}
    public static void main(String[] args) {
    Game_main a =	new Game_main(500,700);  	
    }
}
