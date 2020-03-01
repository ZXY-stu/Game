package War_plane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game_control  extends KeyAdapter{

	public static boolean w;
	public static boolean a;
	public static boolean s;
	public static boolean d;
	public static boolean j;
	public static boolean k;
	public static boolean w1;
	public static boolean a1;
	public static boolean s1;
	public static boolean d1;
    public static boolean isover = false;
    public static boolean isnext=false;
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
	
		if(e.getKeyChar()== 'w'|| e.getKeyChar()== 'W' ) w =false;
		if(e.getKeyChar()== 'a'|| e.getKeyChar()== 'A' ) a =false;
		if(e.getKeyChar()== 's'|| e.getKeyChar()== 'S') s =false;
		if(e.getKeyChar()== 'd'|| e.getKeyChar()== 'D') d =false;
		if(e.getKeyChar()== 'j') j =false;
		if(e.getKeyChar()== 'k') k =false;
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
			a1=false;
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			d1=false;
		if(e.getKeyCode()==KeyEvent.VK_UP)
			w1=false;
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			s1=false;
		
		}
		if(e.getKeyChar() =='\n')
			isnext=false;
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
		if(e.getKeyChar()== 'w' || e.getKeyChar()== 'W' ){
			w =true;
		}
		if(e.getKeyChar()== 'a' || e.getKeyChar()== 'A' ){
			a =true;
		}
		if(e.getKeyChar()== 's' || e.getKeyChar()== 'S' ) {
			s =true;
		}
		if(e.getKeyChar()== 'd' || e.getKeyChar()== 'D' ){
			d =true;
		}
		if(e.getKeyChar()== 'j') 
			j =true;
		if(e.getKeyChar()== 'k')
			{
			k =true;
			if(isover)
			System.exit(0);
			}
		if(e.getKeyChar() =='\n')
			isnext=true;
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
			a1=true;
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			d1=true;
		if(e.getKeyCode()==KeyEvent.VK_UP)
			w1=true;
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			s1=true;
		
	}
}
