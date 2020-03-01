
package War_plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Game_Point extends JPanel implements Runnable,MouseListener{
	public static boolean next=false;
	public static boolean back=false;

	public int contr=0;
	public int xl=0,xr=400,bbig=100,z=100,zz=200;
	public static boolean point1=true,point2=false,point3=false;
	
	public Image bg1 =  Toolkit.getDefaultToolkit().getImage(Game_Point.class.getResource("b1.jpg"));
	public Image bn =  Toolkit.getDefaultToolkit().getImage(Game_Point.class.getResource("n.png"));
	public Image bb =  Toolkit.getDefaultToolkit().getImage(Game_Point.class.getResource("b.png"));
	public Image r =  Toolkit.getDefaultToolkit().getImage(Game_Point.class.getResource("31.png"));
	public Image l =  Toolkit.getDefaultToolkit().getImage(Game_Point.class.getResource("32.png"));
	
	public Image bs1 = Toolkit.getDefaultToolkit().getImage(Game_Point.class.getResource("boss1.png"));
	public Image bs2 = Toolkit.getDefaultToolkit().getImage(Game_Point.class.getResource("boss2.png"));
	public Image bs3 = Toolkit.getDefaultToolkit().getImage(Game_Point.class.getResource("boss3.png"));
	
	
	public Image bg2 =  Toolkit.getDefaultToolkit().getImage(Game_Point.class.getResource("b2.jpg"));

	public Image bg3 =  Toolkit.getDefaultToolkit().getImage(Game_Point.class.getResource("b3.jpg"));
	public Image dhk =  Toolkit.getDefaultToolkit().getImage(Game_Point.class.getResource("dhk1.png"));
	public Game_Point (){
		this.addMouseListener(this);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		if(point1){
		g.drawImage(bg1, 0, 0, 500, 500, this);
		g.setColor(Color.white);

		
		g.drawImage(r, xl, 250, 100, 100, this);
		g.drawImage(l, xr, 250, 100, 100, this);
		

		g.drawImage(bs1, z, 0, 200, 200, this);
		g.drawImage(dhk, 0, 400, 500, 400, this);
		
		g.drawImage(bn, 100, 300, 100, 100, this);
		g.drawImage(bb, 300, 300, bbig, bbig, this);
        g.setFont(new Font("ÀŒÃÂ",Font.BOLD, 25));
		g.drawString("√‘ ß–««Ú", 200, 500);
		
		}
		if(point2){
		g.drawImage(bg2, 0, 0, 500, 500, this);
		g.setColor(Color.white);
		
		g.drawImage(r, xl, 250, 100, 100, this);
		g.drawImage(l, xr, 250, 100, 100, this);
		

		g.drawImage(bs2, z, 0, 200, 200, this);
		g.drawImage(dhk, 0, 400, 500, 400, this);
		  g.setFont(new Font("ÀŒÃÂ",Font.BOLD, 25));
		g.drawImage(bn, 100, 300, 100, 100, this);
		g.drawImage(bb, 300, 300, bbig, bbig, this);
		g.drawString("ªÏ„Á–Èø’", 200, 500);
	
		}
		if(point3){

		g.drawImage(bg3, 0, 0, 500, 500, this);
		g.setColor(Color.white);
		
		g.drawImage(r, xl, 250, 100, 100, this);
		g.drawImage(l, xr, 250, 100, 100, this);
		

		g.drawImage(bs3, z, 0, 200, 200, this);
		g.drawImage(dhk, 0, 400, 500, 400, this);
		  g.setFont(new Font("ÀŒÃÂ",Font.BOLD, 25));
		g.drawImage(bn, 100, 300, 100, 100, this);
		g.drawImage(bb, 300, 300, bbig, bbig, this);
		g.drawString("x-∞µ–«", 200, 500);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){

			if(z==95){
				zz=200;
			}
			
			if(z<200 && zz==200){
				z+=5;
			}
			else{
				zz-=5;
				z=zz;
			}
			
		
			
			if(contr==10){
			if(bbig==100){
				bbig=110;
			}
			else
			{
				bbig=100;
			}

				
				
			if(point2 && xl==0 && xr==370){
				xl=30;
			}
			
			if(!point1)	{
				
			if(xl==0)
				xl=30;
			else
				xl=0;
			}
			if(!point3){
				
			if(xr==400 )
				xr=370;
			else
				xr=400;
			}
			contr=0;
			
			}
			contr++;
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getX()<130 && e.getX()>0 &&e.getY()>250 &&e.getY()<350){//—°∑…ª˙µ„◊Û±ﬂ
			if(point1);
			else 
				if(point2){
					point1=true;
					point2=false;
					point3=false;
				}
				else 
					if(point3){
						point1=false;
						point2=true;
						point3=false;
					}
		}
		if(  e.getX()<500 && e.getX()>370 &&e.getY()>250 &&e.getY()<350){//—°∑…ª˙µ„”“±ﬂ
			if(point3);
			else
				if(point2){
					point3=true;
					point2=false;
					point1=false;
			}
				else
					if(point1){
						point3=false;
						point2=true;
						point1=false;
					}
		}
		
		
		if(  e.getX()<400 && e.getX()>300 &&e.getY()>300 &&e.getY()<400)
			next=true;
		if(  e.getX()<200 && e.getX()>100 &&e.getY()>300 &&e.getY()<400)
			back=true;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}