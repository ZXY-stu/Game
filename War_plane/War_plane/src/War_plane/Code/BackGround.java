package War_plane.Code;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;
public class BackGround{
	   public  int  width,weight,x,y=0,index=0,k=0,x1,x2;
	   Image img_bg[];
	public BackGround(int Width,int Weight)
	   {  
		img_bg = new Image[3];
		
		img_bg[0]= Toolkit.getDefaultToolkit().getImage(BackGround.class.getResource("b" + 1+ ".jpg"));
		img_bg[1]= Toolkit.getDefaultToolkit().getImage(BackGround.class.getResource("b" + 2+ ".jpg"));
		img_bg[2]= Toolkit.getDefaultToolkit().getImage(BackGround.class.getResource("b" + 3+ ".jpg"));
		width=Width;
		weight=Weight;
		x=-260;
		x1 = -1200;
		x2 = -2100;
	   }
	   public void DrawBg(Graphics g,JPanel i,int index) {
			
		   
		   switch(index-1)
			   {
				case 0:
				{  
						g.drawImage(img_bg[0],0,x, width,960, (ImageObserver)i);	
						g.drawImage(img_bg[1],0,x1, width,960, (ImageObserver)i);
						g.drawImage(img_bg[2],0,x2, width,960, (ImageObserver)i);						   
				}
				break;
			  case 1:
			     {
			    	   g.drawImage(img_bg[1],0,x, width,960, (ImageObserver)i);	
					   g.drawImage(img_bg[0],0,x1, width,960, (ImageObserver)i);
					   g.drawImage(img_bg[2],0,x2, width,960, (ImageObserver)i);
			     }
			     break;
				case 2:
				{
					   g.drawImage(img_bg[2],0,x, width,960, (ImageObserver)i);	
					   g.drawImage(img_bg[0],0,x1, width,960, (ImageObserver)i);
					   g.drawImage(img_bg[1],0,x2, width,960, (ImageObserver)i);
				}	
		      }	
				x+=1;  
				x1+=1;
				x2+=1;
				if(x2>=-20)
				{
					x=-260;
					x1=-1200;
					x2=-2100;
				}
		}
	   public void updatebg()
	   {
		   index++;
		   x=-260;
		   x1 = -1200;
	       x2 = -2100;
	   }
}
