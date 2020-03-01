package War_plane;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class Buttel{
	public Image img_bullet;
	public int bullet_step,bullet_position_x=-1000,bullet_position_y=-1000,bullet_x_s,bullet_y_s;
  public int bullet_width=50,bullet_weight=50,stepx,stepy;
  boolean islive=true,isl=true,isr=false,i=true,isshootup=false,ischang=false;
  public int enemy_size,size[]={90,44,70,150};
  public int index,x=0;
  public int b_p[][];
  public int b_num=32;
	public Buttel(String url,int Step,int index)
	    {
		    b_p = new int[b_num][2];
		    bullet_step=Step;
	        img_bullet = Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource(url));
	    	this.index = index;
	    }
	public void Draw_bullet(Graphics g,JPanel l)
	{  
		if(islive)
		{		
			
			g.drawImage(img_bullet, bullet_position_x-size[index]/2+5, bullet_position_y,size[index],size[index],(ImageObserver)l);
		}
	}
	public void rotate(Graphics g,JPanel l)
	{
		  double x3,y3,x4,y4;
		  double k1;
		  Graphics2D g2 =(Graphics2D)g;
		  x3 = bullet_position_x;
		  x4 = bullet_position_x+30;
		  
		  y3 = bullet_position_y;
		  y4 = bullet_position_y + 90;
		
		  
		  k1 = (y4-y3)/(x4-x3);
		
		  g2.rotate(Math.toRadians(k1));
	}
	public void Draw_bullet_boss(Graphics g,JPanel l)
	{
		if(islive)
		{
			for(int i=0;i<b_num;i++)
				g.drawImage(img_bullet, b_p[i][0]-size[index]/2+5, b_p[i][1], size[index],size[index], (ImageObserver)l);
		}
	}
	public void update_boss(int x,int y)
	{
		for(int i=0;i<b_num;i++){
			  b_p[i][0]=x;
			  b_p[i][1]=y;
			 
		}
	}
	public void Updateposition(int x,int y,int stepx,int stepy)
	{
		if(islive){
		bullet_position_y=y;
		bullet_position_x=x;
		this.stepx=stepx;
		this.stepy=stepy;
		bullet_x_s=x;
		bullet_y_s=y;
		}
	}
	public void shoot_spread_round(int stepx,int stepy)
	{
		 bullet_position_x+=stepx;
		 bullet_position_y-=stepy;
	}
	 public void shoot(int stepy)//普通
	 {
		 if(islive)
		 {
			 bullet_position_y+=stepy;
		 }
	 }
	public void shoot_round()//散发
	{
		if(islive){
			bullet_position_y-=stepy;
			bullet_position_x+=stepx;
	   }
	}
	 public void shoot_light(int x,int y)//激光
	 {
		 if(islive)
		 {
			 bullet_position_y-=y;
			 bullet_position_x=x;
		 }
	 }
	 public void shoot_missile_r()
	 {
		  if(islive)
		  {
			  if(bullet_position_x >= bullet_x_s && bullet_position_x<=bullet_x_s+20)
				  bullet_position_x+=5; 
			  else 
				  bullet_position_y-=20;
		  }
	 }
	 public void shoot_missile_l()
	 {
		  if(islive)
		  {
			  if(bullet_position_x >=bullet_x_s-20 && bullet_position_x <=bullet_x_s)
				  bullet_position_x-=5;  
			  else 
				  bullet_position_y-=20;
		  }
	 }
	public void shoot_sway(int stepx,int stepy)//摆动
	{
		 bullet_position_x+=stepx;
		 bullet_position_y-=stepy;
	}
	public  void shoot_spread()//四面八方
	{  
		int x=10,y=10;
	  if(islive)
	  {  
		  b_p[0][0]-=x;
		  b_p[1][0]+=x;
		  b_p[2][1]-=y;
		  b_p[3][1]+=y;
		  
		  
		  b_p[4][0]-=x;
		  b_p[4][1]+=y;
		  b_p[14][0]-=x-8;
		  b_p[14][1]+=y;
		  b_p[15][0]-=x-5;
		  b_p[15][1]+=y;
		  b_p[16][0]-=x-3;
		  b_p[16][1]+=y;
		  b_p[29][0]-=x;
		  b_p[29][1]+=y-3;
		  b_p[30][0]-=x;
		  b_p[30][1]+=y-5;
		  b_p[31][0]-=x;
		  b_p[31][1]+=y-8;
		  
		
		  b_p[5][0]-=x;
		  b_p[5][1]-=y;
		  b_p[11][0]-=x-3;
		  b_p[11][1]-=y;
		  b_p[12][0]-=x-5;
		  b_p[12][1]-=y;
		  b_p[13][0]-=x-8;
		  b_p[13][1]-=y;
		  b_p[26][0]-=x;
		  b_p[26][1]-=y-3;
		  b_p[27][0]-=x;
		  b_p[27][1]-=y-5;
		  b_p[28][0]-=x;
		  b_p[28][1]-=y-8;
		  
		  b_p[6][0]+=x;
		  b_p[6][1]-=y;
		  b_p[17][0]+=x-3;
		  b_p[17][1]-=y;
		  b_p[18][0]+=x-5;
		  b_p[18][1]-=y;
		  b_p[19][0]+=x-8;
		  b_p[19][1]-=y;
		  b_p[20][0]+=x;
		  b_p[20][1]-=y-3;
		  b_p[21][0]+=x;
		  b_p[21][1]-=y-5;
		  b_p[22][0]+=x;
		  b_p[22][1]-=y-8;
		  
		  b_p[7][0]+=x;
		  b_p[7][1]+=y;
		  b_p[8][0]+=x-3;
		  b_p[8][1]+=y;
		  b_p[9][0]+=x-5;
		  b_p[9][1]+=y;
		  b_p[10][0]+=x-8;
		  b_p[10][1]+=y;
		  b_p[23][0]+=x;
		  b_p[23][1]+=y-3;
		  b_p[24][0]+=x;
		  b_p[24][1]+=y-5;
		  b_p[25][0]+=x;
		  b_p[25][1]+=y-8;
	 }  
	}
}
