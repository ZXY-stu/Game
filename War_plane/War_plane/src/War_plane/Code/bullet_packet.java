package War_plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class bullet_packet{
      Image	packet_img;
      public boolean isfinishy=false,isfinishx=false,islive=true,h_islive;
      public int h_xmin,h_y,h_xmax,h_w;
      public int locate[] ={50,100,300,500};
      int x,y;
      public bullet_packet()
      {
    	  packet_img = Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("packet.png"));
      }
      public void getposition(int x,int y)
      {
    	    this.x=x;
    	    this.y=y;
      }
      public void heroposition(int x,int y,int z,int a,boolean islive)
	    {
	    	h_xmin=x-5;
	    	h_y=y;
	    	h_xmax=x+z+5;
	    	h_w=a;
	    	h_islive=islive;
	    }
      public boolean istouch()
      {
    	   if( h_islive && y>h_y && y<h_y+h_w && x>h_xmin && x<h_xmax && islive)
    	   {
    		    islive=false;
    		  return true;
    	   }
    	     return false;
      }
      public void init()
      {
    	   isfinishx=false;
    	   isfinishy=false;
    	   islive=true;
      }
      public void updateposition()
      {
    		if(!isfinishx)
    		  x+=3;
    		if(x>=450)
    			isfinishx=true;
    		if(isfinishx)
    			x-=3;
    		if(x<=30)
    			isfinishx=false;
      }
      public void draw_packet(Graphics g,JPanel l)
      {
    	  g.drawImage(packet_img, x, y,(ImageObserver)l);
      }
      
}
