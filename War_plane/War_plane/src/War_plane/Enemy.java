package War_plane;
import java.awt.Graphics;


import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Enemy implements ActionListener{
	public Image  img_enemy,img_enemy_death,img_enemy_packet,img_a;
	  public int  enemy_width,enemy_weight,width;
	   public int enemy_step,enemy_position,distance;
	   public int h_xmin,h_xmax,h_y,h_w;
	   boolean  islive=true;
	   public int num=0,exp=10,step,j3;
	   boolean ismovey=false,ismovex_l=false,ismovex_r=false,h_islive=true,ismovey_up=false,isfinish=true,havepacket=false,isstartmove=false,isa=false;
	   public int  middle_down=0,middle_up=1,left_up=2,left_down=3,right_up=4,right_down=5,s_x,s_y;
	   public Vector<Buttel> e_bullet = new Vector();
	   public int  e_size[][]={{60,60},{60,60},{80,80},{80,80},{80,80},{80,80},{100,100},{100,100},{100,100}};
	   public int blood[] = {10,10,60,60,60,60,60,60,60};
	   boolean live = true,i=true;
	   public int enemytype;
	   Timer time;
	   String bulletname;
	   Rootnum root[];
	   Showblood show;
	   bullet_packet packet;
	public Enemy(int x,int y,int enemytype,int etype,int Step,int pWidth,boolean ishavepacket)
	   {    
		    packet = new bullet_packet();
			img_enemy= Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("e" +  (etype+1) + ".png"));
			img_enemy_packet= Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("ep" +  (etype+1) + ".png"));
			img_enemy_death=Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("bomb_0.gif"));
			img_a=Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("ea.png"));
			show = new Showblood(2,blood[enemytype], 3,blood[enemytype],0,0);
			time = new Timer(400, this);
			enemy_width=e_size[enemytype][0];
			enemy_weight=e_size[enemytype][1];
			bulletname= "zd" + (enemytype+1) + ".png";
			time.start();
			enemy_step=Step;
			this.width=pWidth;
			distance = x;
			enemy_position=y;
			this.enemytype=enemytype;
			this.s_x=distance;
			this.s_y=y;
			this.havepacket=ishavepacket;
			root = new Rootnum[5];
			for(int i=0;i<5;i++)
		    root[i] = new Rootnum();
			root[0].getxy(-8, 10, 3);
			root[1].getxy(-8, 10, 5);
			root[2].getxy(-8, 20, 3);
			root[3].getxy(-8, 10, 5);
			root[4].getxy(-8, 40, 2);
	   }
	    public void Drawenemy(Graphics g,JPanel L) 
	    {
	    	if(islive)
	    	{	       
	        if(havepacket)
	        {
	        	g.drawImage(img_enemy_packet, distance, enemy_position,(ImageObserver)L);
	        }
	        else 
	        	 g.drawImage(img_enemy,distance,enemy_position,(ImageObserver)L);
	        if(isa)
	        	 g.drawImage(img_a,distance+enemy_width/5,enemy_position+enemy_weight/5,(ImageObserver)L);
	    if(enemytype>1)
	    {
	        show.drawblood(g,-1);
	        show.updateposition(distance, enemy_position);
	    }
	    	}
	    }
	    public void UpdatePosition()
	    {
	    	if(ismovey)
	    		enemy_position+=enemy_step;
	    	 if(ismovex_l)
	    		  distance-=enemy_step+3;
	    	 if(ismovex_r)
	    		  distance+=enemy_step+3;
	    	 if(ismovey_up)
	    		 enemy_position-=enemy_step;
	    	show.updateposition(distance+10, enemy_position);
	    }
	    public void updateposition_round_l()
	    {
	    	 if(isfinish)
	    		 distance+=5;
	    	 if(distance>=200)
	    		 isfinish=false;
	    	 if(!isfinish)
	    		 distance-=5;
	    	 enemy_position-=5;
	    }
	    public void updateposition_round_r()
	    {
	    	 if(isfinish)
	    		 distance-=5;
	    	 if(distance<=300)
	    		 isfinish=false;
	    	 if(!isfinish)
	    		 distance+=5;
	    	 enemy_position-=5;
	    }
	    public void shoot()
	    {
	    	if(islive){	
	              Buttel bullet = new Buttel(bulletname,10,1);
	              bullet.Updateposition(distance+enemy_width/2-4,enemy_position+enemy_weight,15,15);
	              e_bullet.add(bullet);
	    	}
	    }
	    public void shoot_spread_l(int index)//向左发散
		 {  
			 int x,y;	
				 if(islive){	
					 if(j3<root[0].dirc_bxy.length-1)
						 j3++;
					 else 
						 j3=2;
					   x=root[0].dirc_bxy[j3][0];
			           y=root[0].dirc_bxy[j3][1];
	             Buttel bullet = new Buttel("zd" +index + ".png",10,1);
	             bullet.Updateposition(distance+enemy_width/2-4,enemy_position+enemy_weight,x,y);
	             e_bullet.add(bullet);
	    		}
		 }
	    public void shoot_spread_r(int index)//向左发散
		 {  
			 int x,y;	
				 if(islive){	
					 if(j3<root[1].dirc_bxy.length-1)
						 j3++;
					 else 
						 j3=2;
					   x=root[1].dirc_bxy[j3][0];
			           y=root[1].dirc_bxy[j3][1];
	             Buttel bullet = new Buttel("zd" +index + ".png",10,1);
	             bullet.Updateposition(distance+enemy_width/2-4,enemy_position+enemy_weight,x,y);
	             e_bullet.add(bullet);
	    		}
		 }
	    public void shoot_round_half_l(int index)
	    { int x,y;	
			 if(islive){	
				 if(j3<root[2].dirc_bxy.length-1)
					 j3++;
				 else 
					 j3=0;
				   x=root[2].dirc_bxy[j3][0];
		           y=root[2].dirc_bxy[j3][1];
	         Buttel bullet = new Buttel("zd" + index + ".png",10,1);
	         bullet.Updateposition(distance+enemy_width/2-4,enemy_position+enemy_weight,x,y);
	         e_bullet.add(bullet);
			}
	    }
	    public void shoot_round_half_r(int index)
	    { int x,y;	
			 if(islive){	
				 if(j3<root[3].dirc_bxy.length-1)
					 j3++;
				 else 
					 j3=0;
				   x=root[3].dirc_bxy[j3][0];
		           y=root[3].dirc_bxy[j3][1];
	         Buttel bullet = new Buttel("zd" + index + ".png",10,1);
	         bullet.Updateposition(distance+enemy_width/2-4,enemy_position+enemy_weight,x,y);
	         e_bullet.add(bullet);
			}
	    }
		 public void shoot_round(int index)
		    { int x,y;	
			 if(islive){	
				 if(j3<root[4].dirc_bxy.length-1)
					 j3++;
				 else 
					 j3=0;
				   x=root[4].dirc_bxy[j3][0];
		           y=root[4].dirc_bxy[j3][1];
	         Buttel bullet = new Buttel("zd" + index + ".png",10,1);
	         bullet.Updateposition(distance+enemy_width/2-4,enemy_position+enemy_weight,x,y);
	         e_bullet.add(bullet);
			}
	    }
	    public void death(Graphics g,JPanel L)
	    {      	
	    	if(show.blood<=0){    
		        g.drawImage(img_enemy_death,distance,enemy_position,enemy_width,enemy_weight,(ImageObserver)L);
		        if(havepacket)
		        {
		        	 packet.getposition(distance,enemy_position);
		        	 isstartmove=true;
		        }
		        live=false;
		        show.blood=blood[enemytype];
		        islive=false;
		        ismovey=false;
		        ismovex_l=false;
		        ismovex_r=false;
		        num=0;
		        distance=s_x;
		        enemy_position=s_y;
		        UpdatePosition();
		        
	    	}
	    	if(enemy_position>=-5)
	    	show.updateblood();
	    }
	    public boolean istouch()
	    {
	    	for(int i=0;i<e_bullet.size();i++){
	    		
	    		if(h_islive && (e_bullet.get(i).bullet_position_y-h_y >=0 && e_bullet.get(i).bullet_position_y-h_y<=h_w )&& e_bullet.get(i).bullet_position_x>=h_xmin+10
	    				&& e_bullet.get(i).bullet_position_x<=h_xmax -20){
	    			e_bullet.remove(i);	
	    			  return true;
	    		}
	    		else if(h_islive && distance>=h_xmin-50 && distance<=h_xmax-50 && enemy_position - h_y >=0 && enemy_position - h_y<=enemy_weight-10)
	    		{
	    			 return true;
	    		}
	    		else if(e_bullet.get(i).bullet_position_y>750 || e_bullet.get(i).bullet_position_y<-100 || e_bullet.get(i).bullet_position_x>600 || e_bullet.get(i).bullet_position_x<-100)
	    			e_bullet.remove(i);
	    	}
	    	return false;
	    }
	    public void heroposition(int x,int y,int z,int a,boolean islive)
	    {
	    	h_xmin=x-5;
	    	h_y=y;
	    	h_xmax=x+z+5;
	    	h_w=a;
	    	h_islive=islive;
	    }
	    @Override
		public void actionPerformed(ActionEvent e){
	   	 time.setDelay(400);
	   	
	    	switch(enemytype+1)
	        	 {
	        
		        	 case 1:
		        	 { 
		        		 if(num<5)
		        			 ;
		        		 else if(num>=5 && num<7)
		        		 { if(distance>=-10 && distance<=500 && enemy_position>0 && enemy_position<700)
		        			 shoot();
		        		 isa=true;
		        		 }
		        		 else {
		        			 num=0;
		        			 isa=false;
		        		 }
		        		 num++;
		        			 
		        	 }
		        	 break;
		        	 case 2:
		        	 { if(num<5)
	        			 ;
	        		 else if(num>=5 && num<7)
	        		 {
	        		  if(distance>=-10 && distance<=500 && enemy_position>0 && enemy_position<700)
	        			 shoot();
	        		  isa=true;}
	        		 else 
	        			 {
	        			 num=0;
	        			 isa=false;
	        			 }
	        		 num++;
		        		 
		        	 }
	        	    case 3:
	        	    {
	        	    if(distance<100)
	        	    	ismovex_r=true;
	        	    else 
	        	    {
	        	    	ismovex_r=false;
	        	    
	        	          if(num<5)
	        	        	  ;
	        	          else if(num>=5 && num<11)
	        	          {
	        	        	  isa=true;
	        	        	  time.setDelay(60);
	        	    	     shoot_spread_l(5); 
	        	          }
	        	          else 
	        	          {
	        	        	  isa=false;
	        	          
	        	        	  num=0;
	        	          }
	        	          num++;
	        	    }
	        	    }
	        	    break;
	        	    case 4:
	        	    { if(distance>350)
	        	    	ismovex_l=true;
	        	    else 
	        	    {
	        	    	ismovex_l=false;
	        	    	 if(num<5)
	        	        	  ;
	        	          else if(num>=5 && num<11)
	        	          {
	        	        	  time.setDelay(60);
	        	        	  shoot_spread_r(5);
	        	        	  isa=true;
	        	          }
	        	          else 
	        	          {
	        	          num=0;
	        	          isa=false;
	        	          }
	        	    	 num++;
	        	     }
	        	    }
	        	    break;
	        	    case 5:
	        	    {
	        	    	 if(distance<38)
	        	    		 ismovex_r=true;
	        	    	 else 
	        	    	 {
	        	    		 ismovex_r=false;
	        	    	 if(num<5)
	        	    		 ;
	        	    	 else if(num>=5 && num<35)
	        	    	 {
	        	    		 isa=true;
	        	    		 time.setDelay(60);
	        	    		 shoot_round_half_l(5);
	        	    	 }
	        	    	 else 
	        	    	 {
	        	    		 num=0;
	        	    		 isa=false;
	        	    	 }
	        	    	 num++;
	        	    	 } 
	        	    }
	        	    break;
	        	    case 6:
	        	    {
	        	    if(distance>390)
	        	    	ismovex_l=true;
	        	    else 
	        	    {
	        	    	ismovex_l=false;
	        	    	 if(num<5)
	        	        	  ;
	        	          else if(num>=5 && num<15)
	        	          {
	        	        	  time.setDelay(60);
	        	    	  shoot_round_half_r(5);
	        	    	  isa=true;
	        	          }
	        	          else 
	        	          {
	        	        	  num=0;
	        	        	  isa=false;
	        	          }
	        	    	 
	        	    	 num++;
	        	    }
	        	    }
	        	    break;
	        	    case 7:
	        	    {
	        	    	if(enemy_position<10)
	        	    		ismovey=true;
	        	    	else 
	        	    	{
	        	    		ismovey=false;
	        	    	 if(num<6)
	        	        	  ;
	        	          else if(num>=6 && num<56)
	        	      	{
		        	        	 time.setDelay(60);
		        	        	  shoot_round(5);
		        	        	  isa=true;
		        	    	}
	        	          else {
	        	        	  isa=false;
	        	        	  num=0;
	        	          }
	        	    	 num++;
	        	    	}
	        	    }
	        	    case 8:
	        	    {
	        	    	if(enemy_position<20)
	        	    		ismovey=true;
	        	    	else 
	        	    	{
	        	    		ismovey=false;
	        	    	 if(num<10)
	        	        	  ;
	        	          else if(num>=10 && num<50)
	        	      	{
		        	        	 time.setDelay(60);
		        	        	  shoot_round(5);
		        	        	  isa=true;
		        	    	}
	        	          else 
	        	          { isa=false;
	        	        	  num=0;
	        	          }
	        	    	 num++;
	        	    	}
	        	    }
	        	    case 9:
	        	    {
	        	    	if(enemy_position<10)
	        	    		ismovey=true;
	        	    	else 
	        	    	{
	        	    		ismovey=false;
		        	    	 if(num<20)
		        	        	  ;
		        	          else if(num>=20 && num<70)
		        	    	{
		        	        	 time.setDelay(60);
		        	        	  shoot_round(5);
		        	        	  isa=true;
		        	    	}
		        	          else 
		        	          {
		        	        	  isa=false;
		        	        	  num=0;
		        	          }
		        	    	 num++;
	        	    	}
	        	    }
	        	 }
	    }
}
