package War_plane;

import java.awt.Graphics;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game_Choose_plane extends JPanel implements Runnable,MouseListener,ActionListener{
	
	public Image bg = Toolkit.getDefaultToolkit().getImage(Game_Choose_plane.class.getResource("bgp.png"));
	public Image h1 = Toolkit.getDefaultToolkit().getImage(Game_Choose_plane.class.getResource("hero1_1.png"));
	public Image h2 = Toolkit.getDefaultToolkit().getImage(Game_Choose_plane.class.getResource("hero2_1.png"));
	public Image h3 = Toolkit.getDefaultToolkit().getImage(Game_Choose_plane.class.getResource("hero3_1.png"));
	public Image zd1 = Toolkit.getDefaultToolkit().getImage(Game_Choose_plane.class.getResource("zd2.png"));
	public Image zd2 = Toolkit.getDefaultToolkit().getImage(Game_Choose_plane.class.getResource("zd3.png"));
	public Image zd3 = Toolkit.getDefaultToolkit().getImage(Game_Choose_plane.class.getResource("zd4.png"));
	public Image xzfj =  Toolkit.getDefaultToolkit().getImage(Game_Choose_plane.class.getResource("cp.png"));
	
	public Image bn =  Toolkit.getDefaultToolkit().getImage(Game_Choose_plane.class.getResource("n.png"));
	public Image bb =  Toolkit.getDefaultToolkit().getImage(Game_Choose_plane.class.getResource("b.png"));
	public Image r =  Toolkit.getDefaultToolkit().getImage(Game_Choose_plane.class.getResource("31.png"));
	public Image l =  Toolkit.getDefaultToolkit().getImage(Game_Choose_plane.class.getResource("32.png"));
	
	
	
	
	public static boolean planea=true,planeb=false,planec=false,is1=false;
	public static boolean next=false;
	public static boolean back=false;

	public int contr=0;
	public int xl=0,xr=400,bbig=100;
	public int x=225,y=195;
	public int k=0,bullet_index=1,hero_index=1,shoot_num=0,count=0;
	Hero hero;
	Timer t;
	public Game_Choose_plane(){
		t = new Timer(100,this);
		t.start();
		
		this.addMouseListener(this);
	    hero = new Hero(200,250,70,70,0,"bhero"+bullet_index+".png",50,hero_index);
	   
	}
	
	
	
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
	
		super.paint(g);
		
		
		g.drawImage(bg, 0, 0, 500, 700, this);
		if(planea){
		
			g.drawImage(r, xl, 250, 100, 100, this);
			g.drawImage(l, xr, 250, 100, 100, this);

			g.drawImage(xzfj, 0, 0, 200, 200, this);
			hero.hero_index=1;
		
          
			g.drawImage(bn, 100, 500, 100, 100, this);
			g.drawImage(bb, 300, 500, bbig, bbig, this);
		}
		if(planeb){
		    
			g.drawImage(r, xl, 250, 100, 100, this);
			g.drawImage(l, xr, 250, 100, 100, this);
			g.drawImage(xzfj, 0, 0, 200, 200, this);
			g.drawImage(bn, 100, 500, 100, 100, this);
			g.drawImage(bb, 300, 500, bbig, bbig, this);
			hero.hero_index=2;
	
	       
			}
		
		if(planec){
			g.drawImage(r, xl, 250, 100, 100, this);
			g.drawImage(l, xr, 250, 100, 100, this);
			hero.hero_index=3;
			 
			g.drawImage(xzfj, 0, 0, 200, 200, this);
			g.drawImage(bn, 100, 500, 100, 100, this);
			g.drawImage(bb, 300, 500, bbig, bbig, this);
			
			}
		hero.bulletname="bhero" + hero.hero_index+".png";
		 if(hero.islive)
	   	  { 
	    	
	    		if(hero.hero_index!=2)
	    		{
	    	   if(!is1)
	    	   {
	    		   is1=true;
	    		   removall();
	    	   }
	    	for(int i=0,j=0;i<hero.h_bullet_7.size();i++)
	 	     {
	    	    
	 	 	      hero.h_bullet_7.get(i).shoot_light(hero.hero_position_x+hero.width/2+5,30);
	 	 	  
	 	 	      hero.h_bullet_7.get(i).Draw_bullet(g, this);
	 	 	    remove(hero.h_bullet_7, i);
	 	     }
	 	   	  for(int i=0,j=0;i<hero.h_bullet_1.size();i++)
	 	   	  {  	
	 	  	     hero.h_bullet_1.get(i).Draw_bullet(g, this);
	 	         hero.h_bullet_1.get(i).shoot(-30);	
	 	        remove(hero.h_bullet_1, i);
	 	   	  }
	 	     for(int i=0,j=0;i<hero.h_bullet_2.size();i++)
	 	     {
	 	 	  	  hero.h_bullet_2.get(i).Draw_bullet(g, this);
	 	 	      hero.h_bullet_2.get(i).shoot(-30);
	 	 	    remove(hero.h_bullet_2, i);
	 	     }
	    	 for(int i=0,j=0;i<hero.h_bullet_3.size();i++)
	 	 	     {
	 	 	 	  	  hero.h_bullet_3.get(i).Draw_bullet(g, this);
	 	 	 	      hero.h_bullet_3.get(i).shoot(-30);
	 	 	 	   remove(hero.h_bullet_3, i);
	 	 	     }
	    	for(int i=0,j=0;i<hero.h_bullet_4.size();i++)
	 	     {
	 	 	  	  hero.h_bullet_4.get(i).Draw_bullet(g, this);
	 	 	      hero.h_bullet_4.get(i).shoot(-30);
	 	 	    remove(hero.h_bullet_4, i);
	 	     }
	    	for(int i=0,j=0;i<hero.h_bullet_5.size();i++)
	 	     {
	 	 	  	  hero.h_bullet_5.get(i).Draw_bullet(g, this);
	 	 	      hero.h_bullet_5.get(i).shoot_missile_l();
	 	 	    remove(hero.h_bullet_5, i);
	 	     }
	    	for(int i=0,j=0;i<hero.h_bullet_6.size();i++)
	 	     {
	 	 	  	  hero.h_bullet_6.get(i).Draw_bullet(g, this);
	 	 	      hero.h_bullet_6.get(i).shoot_missile_r();
	 	 	    remove(hero.h_bullet_6, i);
	 	     }
	   	for(int i=0,j=0;i<hero.h_bullet_8.size();i++)
	     {
	 	  	  hero.h_bullet_8.get(i).Draw_bullet(g, this);
	 	      hero.h_bullet_8.get(i).shoot_round();
	 	     remove(hero.h_bullet_8, i);
	     }
		for(int i=0,j=0;i<hero.h_bullet_9.size();i++)
	     {
	 	  	  hero.h_bullet_9.get(i).Draw_bullet(g, this);
	 	      hero.h_bullet_9.get(i).shoot_round();
	 	     remove(hero.h_bullet_9, i);
	     }
		for(int i=0,j=0;i<hero.h_bullet_12.size();i++)
	     {
	 	  	 
	 	      hero.h_bullet_12.get(i).shoot_light(hero.hero_position_x+2, 30);
	 	
		 	  	  hero.h_bullet_12.get(i).Draw_bullet(g, this);
	     }
		for(int i=0,j=0;i<hero.h_bullet_13.size();i++)
	     {
	 	  	 
	 	      hero.h_bullet_13.get(i).shoot_light(hero.hero_position_x+hero.width+8,30);
	 	   
		 	  	  hero.h_bullet_13.get(i).Draw_bullet(g, this);
	     }
	    		}
	    		else 
		if(hero.hero_index==2)
		{  
	        if(is1)
	        {
	        	removall();
	        	is1=false;
	        }
			for(int i=0,j=0;i<hero.h_bullet_7.size();i++)
	 	     {
	    	      
	 	 	      hero.h_bullet_7.get(i).shoot_light(hero.hero_position_x+hero.width/2+5,30);
	 	 	      hero.h_bullet_7.get(i).Draw_bullet(g, this);
	 	 	    remove(hero.h_bullet_7, i);
	 	     }
			  for(int i=0,j=0;i<hero.h_bullet_1.size();i++)
	 	   	  {  	
	 	  	     hero.h_bullet_1.get(i).Draw_bullet(g, this);
	 	         hero.h_bullet_1.get(i).shoot_spread_round(-12, 12);
	 	        remove(hero.h_bullet_1, i);
	 	   	  }
	 	     for(int i=0,j=0;i<hero.h_bullet_2.size();i++)
	 	     {
	 	 	  	  hero.h_bullet_2.get(i).Draw_bullet(g, this);
	 	 	      hero.h_bullet_2.get(i).shoot_spread_round(12, 12);
	 	 	    remove(hero.h_bullet_2, i);
	 	     }
	    	 for(int i=0,j=0;i<hero.h_bullet_3.size();i++)
	 	 	     {
	    	    	
	 	 	 	  	  hero.h_bullet_3.get(i).Draw_bullet(g, this);
	 	 	 	      hero.h_bullet_3.get(i).shoot_spread_round(0, 12);
	 	 	 	   remove(hero.h_bullet_3, i);
	 	 	     }
	    	for(int i=0,j=0;i<hero.h_bullet_4.size();i++)
	 	     {
	 	 	  	  hero.h_bullet_4.get(i).Draw_bullet(g, this);
	 	 	      hero.h_bullet_4.get(i).shoot_spread_round(0, -12);
	 	 	    remove(hero.h_bullet_4, i);
	 	     }
	    	for(int i=0,j=0;i<hero.h_bullet_5.size();i++)
	 	     {
	 	 	  	  hero.h_bullet_5.get(i).Draw_bullet(g, this);
	 	 	      hero.h_bullet_5.get(i).shoot_spread_round(-12, -12);
	 	 	    remove(hero.h_bullet_5, i);
	 	     }
	    	for(int i=0,j=0;i<hero.h_bullet_6.size();i++)
	 	     {
	 	 	  	  hero.h_bullet_6.get(i).Draw_bullet(g, this);
	 	 	      hero.h_bullet_6.get(i).shoot_spread_round(12, -12);
	 	 	    remove(hero.h_bullet_6, i);
	 	     }
	     	for(int i=0,j=0;i<hero.h_bullet_10.size();i++)
		     {
		 	  	  hero.h_bullet_10.get(i).Draw_bullet(g, this);
		 	      hero.h_bullet_10.get(i).shoot(-30);
		 	     remove(hero.h_bullet_10, i);
		     }
	 		for(int i=0,j=0;i<hero.h_bullet_11.size();i++)
		     {
		 	  	  hero.h_bullet_11.get(i).Draw_bullet(g, this);
		 	      hero.h_bullet_11.get(i).shoot(-30);
		 	     remove(hero.h_bullet_11, i);
		 	
		     }
	 	  	for(int i=0,j=0;i<hero.h_bullet_8.size();i++)
		     {
		 	  	  hero.h_bullet_8.get(i).Draw_bullet(g, this);
		 	      hero.h_bullet_8.get(i).shoot_round();
		 	     remove(hero.h_bullet_8, i);
		 	  
		     }
	 		for(int i=0,j=0;i<hero.h_bullet_9.size();i++)
		     {
		 	  	  hero.h_bullet_9.get(i).Draw_bullet(g, this);
		 	      hero.h_bullet_9.get(i).shoot_round();
		 	      remove(hero.h_bullet_9, i);
		 	 
		     }
		
	
		}
		  hero.Draw_hero(g, this, false);
	   	  }
	}
	public void removall()
	{
		 hero.h_bullet_1.removeAllElements();  
		 hero.h_bullet_2.removeAllElements();  
		 hero.h_bullet_3.removeAllElements();  
		 hero.h_bullet_4.removeAllElements();  
		 hero.h_bullet_5.removeAllElements();  
		 hero.h_bullet_6.removeAllElements();  
		 hero.h_bullet_7.removeAllElements();  
		 hero.h_bullet_8.removeAllElements();
		 hero.h_bullet_9.removeAllElements(); 
		 hero.h_bullet_10.removeAllElements();  
		 hero.h_bullet_11.removeAllElements();  
		 hero.h_bullet_12.removeAllElements();
		 hero.h_bullet_13.removeAllElements();
	}
	public void remove(Vector <Buttel> b,int i)
	{
		 if(b.get(i).bullet_position_x<-50|| b.get(i).bullet_position_y>700 || b.get(i).bullet_position_y<-50 || b.get(i).bullet_position_x>550)
		    {
		    	b.remove(i);
		    }
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
     
			if(contr==10){
			if(planeb && xl==0 && xr==370){
				xl=30;
			}
			
			if(!planea)	{
				
			if(xl==0)
				xl=30;
			else
				xl=0;
			}
			if(!planec){
				
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
		if(  e.getX()<400 && e.getX()>300 &&e.getY()>500 &&e.getY()<600)
			next=true;
		if(  e.getX()<200 && e.getX()>100 &&e.getY()>500 &&e.getY()<600)
			back=true;
		if(e.getX()<130 && e.getX()>0 &&e.getY()>250 &&e.getY()<350){//选飞机点左边
			if(planea);
			else 
				if(planeb){
					planea=true;
					planeb=false;
					planec=false;
				}
				else 
					if(planec){
						planea=false;
						planeb=true;
						planec=false;
					}
		}
		if(  e.getX()<500 && e.getX()>370 &&e.getY()>250 &&e.getY()<350){//选飞机点右边
			if(planec);
			else
				if(planeb){
				planec=true;
				planeb=false;
				planea=false;
			}
				else
					if(planea){
						planec=false;
						planeb=true;
						planea=false;
					}
		}
	
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



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(hero.hero_index)
	    	{
	    	case 1:
	    	{
	    	if(!hero.isenough)
	 		{
	 			
	    		t.setDelay(200);
	 			shoot_num++;
	 		if(shoot_num<=10)
	 			{
	 			hero.shoot();
	 			
	 			if(shoot_num>=9 && hero.bullet_degree>1)
	 			{
	 		
	 				hero.shoot_missile_l();
	 	 			hero.shoot_missile_r();
	 			}
	 			}
	 		else if(shoot_num>=10 && shoot_num<11)
	 			;
	 		else {	
	 			shoot_num=0;
	 		}
	 		}
	 		else 
	 		{   
	 			if(shoot_num<=80)
	 			{
	 				t.setDelay(60);
	 			    hero.shoot_light(hero.hero_index);
	 			    hero.shoot_sway_l();
	 			    hero.shoot_sway_r();
	 			    shoot_num++;
	 			}
	 			else 
	 			{
	 				hero.isenough=false;
	 				hero.crazy=false;
	 				count=0;
	 			}
	 		}
	      }
	    	break;
	    	case 2:
	    	{
	    	if(!hero.isenough)
	 		{
	 			
	    		t.setDelay(70);
	 			shoot_num++;
	 		if(shoot_num<=10)
	 			{
	 		
	 		   hero.shoot_hero2();	
	 			if(shoot_num>=5 && shoot_num<8)
	 			{
	 		
	 				 hero.shoot_spread_round();
	 			}
	 			}
	 		else if(shoot_num>=15 && shoot_num<16)
	 			;
	 		else {	
	 			shoot_num=0;
	 			
	 		}
	 		}
	 		else 
	 		{   
	 			if(shoot_num<=80)
	 			{
	 				
	 				t.setDelay(60);
	 			    hero.shoot_light(hero.hero_index);

	 			    hero.shoot_sway_l();
	 			    hero.shoot_sway_r();
	 			    if(shoot_num>=15 && shoot_num<=20)
	 			  hero.shoot_spread_round();
	 			  if(shoot_num>=25  && shoot_num<=30)
	 	 			  hero.shoot_spread_round();
	 			  if(shoot_num>=40  && shoot_num<=50)
	 	 			  hero.shoot_spread_round();
	 			  if(shoot_num>=55  && shoot_num<=70)
	 	 			  hero.shoot_spread_round();
	 			 
	 			    shoot_num++;
	 			}
	 			else 
	 			{
	 				hero.isenough=false;
	 				hero.crazy=false;
	 				count=0;
	 			}
	 		}
	      }
	    	break;
	    	
	    	case 3:
	    	{
	    		if(!hero.isenough)
	 	 		{
	 	    		t.setDelay(150);
	 	 			hero.shoot();
	 	 		}
	 	 		else 
	 	 		{   
	 	 			if(shoot_num<=80)
	 	 			{
	 	 				t.setDelay(60);
	 	 			    hero.shoot_light(hero.hero_index);
	 	 			 hero.shoot_light_l(hero.hero_index);
	 	 			 hero.shoot_light_r(hero.hero_index);
	 	 			    hero.bulletname="bhero4.png";
	 	 			    hero.shoot_sway_l();
	 	 			    hero.shoot_sway_r();
	 	 			    shoot_num++;
	 	 			}
	 	 			else 
	 	 			{
	 	 				hero.isenough=false;
	 	 				hero.crazy=false;
	 	 				count=0;
	 	 			}
	 	 		}
	    	}
	    }
	    
	
		count++;
		if(count%5==0 && hero.bullet_degree<4)
			hero.bullet_degree++;
		if(hero.bullet_degree==5)
			hero.bullet_degree=1;
		if(count==40)
			hero.isenough=true;
		
		
	
		
	}
}