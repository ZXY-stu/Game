package War_plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class jdt extends JPanel implements Runnable{
	public Image b = Toolkit.getDefaultToolkit().getImage(jdt.class.getResource("bbg1.png"));

	public Image b1 = Toolkit.getDefaultToolkit().getImage(jdt.class.getResource("jdtx.png"));

	public Image b2 = Toolkit.getDefaultToolkit().getImage(jdt.class.getResource("jdt.png"));

	public Image b3 = Toolkit.getDefaultToolkit().getImage(jdt.class.getResource("leit.png"));
	public int x=0;
	public static boolean c=false;
	
	
	
	public jdt(){
	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

		g.drawImage(b, 0, 0, 500, 700, this);
		g.drawImage(b3, 75, 50, 380, 220, this);
		g.drawImage(b2, 150, 600, 205,34, this);
		g.drawImage(b1, 150, 602, x, 30, this);

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(x<205)
				x+=3;
			if(x>=205)
				c=true;
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}