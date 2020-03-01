package War_plane;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.Vector;

import javax.swing.JPanel;
public class Hero{
	 public  int  hero_position_x,hero_position_y,skill_x,skill_y,j=0,bullet_degree=3,j1=0,j2=0,hero_index;
	 public static int killcount;
	 Image img_hero,img_skill,img_skill2,img_death;
	 boolean  crazy=false,islive=true,e_isdeath=false,isj=false,isk=false,alive=true,i=true,isenough=false,isfinishl=false,isfinishr=false;
	 public  int blood =200,elector=200,k=0;
	   public int x=8,y=10;
	 int width,weight,m_weight;
	 int degree,grade,exp;
	 String str;
	 String bulletname;
	 public int tempnum;
	public  Showblood showblood;
	public int  middle_down=0,middle_up=1,left_up=2,left_down=3,right_up=4,right_down=5,root_size=3;
	Rootnum root[];
	Game_over over;
	  public Vector<Buttel> h_bullet_1 = new Vector();
	   public Vector<Buttel> h_bullet_2 = new Vector();
	   public Vector<Buttel> h_bullet_3 = new Vector();
	   public Vector<Buttel> h_bullet_4 = new Vector();
	   public Vector<Buttel> h_bullet_5 = new Vector();
	   public Vector<Buttel> h_bullet_6 = new Vector();
	   public Vector<Buttel> h_bullet_7 = new Vector();
	   public Vector<Buttel> h_bullet_8 = new Vector();
	   public Vector<Buttel> h_bullet_9 = new Vector();
	   public Vector<Buttel> h_bullet_10 = new Vector();//shoot_l
	   public Vector<Buttel> h_bullet_11 = new Vector();//shoot_r
	   public Vector<Buttel> h_bullet_12 = new Vector();
	   public Vector<Buttel> h_bullet_13 = new Vector();
     public Hero(int x,int y,int width,int weight,int m_weight,String bulletname,int bullet_size,int index)
     {  
    	this.hero_index=index;
    	 over = new  Game_over();
    	 hero_position_x=x;
    	 this.width=width;
    	 this.weight=weight;
    	 this.m_weight=m_weight;
    	 this.bulletname=bulletname;
    	 this.tempnum=bullet_size;
    	 hero_position_y=y;
    	 showblood = new Showblood(20,200,10,blood,elector,m_weight);
    	 showblood.index=0;
    	 root = new Rootnum[2];
    	 for(int i=0;i<2;i++)
    root[i] = new Rootnum();
       root[0].getxy(-50, 20, 0);
        root[1].getxy(50, 50, 1);
        j2= root[1].dirc_bxy.length-1;
    	 img_skill =Toolkit.getDefaultToolkit().getImage(Hero.class.getResource("skill3.png"));
    	 img_skill2 = Toolkit.getDefaultToolkit().getImage(Hero.class.getResource("missile.png"));  	 
    	 img_hero = Toolkit.getDefaultToolkit().getImage(Hero.class.getResource("hero"+ hero_index +"_1.png"));
     }
     public void Draw_hero(Graphics g,JPanel L,boolean showdate){
    	 if(islive)
    	 {
    		 if(i)
    	    	{
    			 i=false;
    	    		 g.drawImage(img_skill2, skill_x,skill_y, width,weight, (ImageObserver)L);
    	    		 g.drawImage(img_skill, hero_position_x-15, hero_position_y, width+30,weight+30, (ImageObserver)L);
    	    	}
    		if(crazy)
    		 img_hero = Toolkit.getDefaultToolkit().getImage(Hero.class.getResource("hero"+ hero_index+"_2.png"));
    		else 
    			 img_hero = Toolkit.getDefaultToolkit().getImage(Hero.class.getResource("hero"+ hero_index+"_1.png"));
    		  g.drawImage(img_hero, hero_position_x-3, hero_position_y+10, (ImageObserver)L);
    	        if(isj)
       	    	 g.drawImage(img_skill, hero_position_x, hero_position_y, width+30,weight+30, (ImageObserver)L);
    	       if(showdate)
    	        showblood.h_drawblood(g,L);
    	 }
    	 else
    	   over.draw_over(g);
     }
    public void draw_skill(Graphics g,JPanel l){
    	if(alive)
    	{
    	if(skill_y>=200)
    	{
    	 g.drawImage(img_skill2, skill_x,skill_y, (ImageObserver)l);
    	 skill_y-=18;
    	}
    	else {
    		img_death = Toolkit.getDefaultToolkit().getImage(Hero.class.getResource("bomb_" + k +".gif"));
        		g.drawImage(img_death,0,0, 500,500, (ImageObserver)l);
        		k++;
        		if(k==3)
        		{ k=0;
        			alive=false;
        		}
    	}
    	}
     }
    public void shoot()
    {   int x,y,size=hero_index-1;
        x=y=0;
        
    	if(islive){
         switch(bullet_degree)
         {
         case 1:
         {
			Buttel bullet = new Buttel(bulletname,40,size);
            bullet.Updateposition(hero_position_x+width/2-10,hero_position_y,x,y);
       
            h_bullet_1.add(bullet); 
            Buttel bullet1 = new Buttel(bulletname,40,size);
            bullet1.Updateposition(hero_position_x+width-5,hero_position_y,x,y);
            
            h_bullet_2.add(bullet1); 
         }
         break;
         case 2:
         {
        	Buttel bullet = new Buttel(bulletname,40,size);
            bullet.Updateposition(hero_position_x+width/2-10,hero_position_y,x,y);
          
            h_bullet_1.add(bullet); 
			Buttel bullet1 = new Buttel(bulletname,40,size);
			bullet1.Updateposition(hero_position_x+width-5,hero_position_y,x,y);
			
			h_bullet_2.add(bullet1); 
         }
         break;
         case 3:
         {
        	 Buttel bullet = new Buttel(bulletname,40,size);
             bullet.Updateposition(hero_position_x+width/2-10,hero_position_y,x,y);
         
             h_bullet_1.add(bullet); 
 			Buttel bullet1 = new Buttel(bulletname,40,size);
 			bullet1.Updateposition(hero_position_x+width/2+10,hero_position_y-20,x,y);
 			h_bullet_2.add(bullet1); 
 			
 			Buttel bullet2 = new Buttel(bulletname,40,size);
 			 
 			bullet2.Updateposition(hero_position_x+width-5,hero_position_y,x,y);
 			h_bullet_3.add(bullet2); 
 			
 			
         }
         break;
         case 4:
         {
        	
             
 			Buttel bullet1 = new Buttel(bulletname,40,size);
 			bullet1.Updateposition(hero_position_x+width/2+5,hero_position_y-20,x,y);
 			h_bullet_2.add(bullet1); 
 			
 			Buttel bullet2 = new Buttel(bulletname,40,size);
 			bullet2.Updateposition(hero_position_x+width/2+15,hero_position_y-20,x,y);
 			h_bullet_3.add(bullet2); 
 			
 		
 			if(hero_index==1 || hero_index==2)
 			{
 				Buttel bullet3 = new Buttel(bulletname,40,size);
 	 			bullet3.Updateposition(hero_position_x+width-5,hero_position_y,x,y);	
 	 			h_bullet_4.add(bullet3); 
 	 			
 	 			 Buttel bullet = new Buttel(bulletname,40,size);
 	             bullet.Updateposition(hero_position_x+width/2-10,hero_position_y,x,y);
 	             h_bullet_1.add(bullet); 
 			}
 			else if(hero_index==3)
 			{
 				Buttel bullet3 = new Buttel(bulletname,40,size);
 	 			bullet3.Updateposition(hero_position_x+width+10,hero_position_y,x,y);	
 	 			h_bullet_4.add(bullet3); 
 	 			
 	 			 Buttel bullet = new Buttel(bulletname,40,size);
 	             bullet.Updateposition(hero_position_x+width/2-30,hero_position_y,x,y);
 	             h_bullet_1.add(bullet); 
 			}
 			
         }
         }
    	}
    }
    
    public void shoot_light(int index)
    {
    	if(islive)
    	{
    		Buttel bullet4 = new Buttel("light"+index+".png",40,3);
    	
            bullet4.Updateposition(hero_position_x+width/2+100,hero_position_y-70,x,y);
            h_bullet_7.add(bullet4); 
    	}
    }
    public void shoot_light_l(int index)
    {
    	if(islive)
    	{
    		Buttel bullet4 = new Buttel("light"+index+".png",40,2);
    	
            bullet4.Updateposition(hero_position_x+width/2+100,hero_position_y+20,x,y);
            h_bullet_12.add(bullet4); 
    	}
    }
    public void shoot_light_r(int index)
    {
    	if(islive)
    	{
    		Buttel bullet4 = new Buttel("light"+index+".png",40,2);
    	    
            bullet4.Updateposition(hero_position_x+width/2+100,hero_position_y+20,x,y);
            h_bullet_13.add(bullet4); 
    	}
    }
    public void shoot_missile_l()
    { 
	    if(islive)
	    {
	    	Buttel bullet4 = new Buttel(bulletname,40,hero_index-1);
	    	
	        bullet4.Updateposition(hero_position_x+width/2-30,hero_position_y,0,0);
	        h_bullet_5.add(bullet4);
	    }
    }
    public void shoot_missile_r()
    { int x,y;
	    if(islive)
	    {
			Buttel bullet5 = new Buttel(bulletname,40,hero_index-1);
		
			bullet5.Updateposition(hero_position_x+width+12,hero_position_y,0,0);
			h_bullet_6.add(bullet5);       
	    }
    }
  public void shoot_sway_l()
  {
	  if(islive){	
			 if(!isfinishl)
	    		 j1++;
	    	 if(j1==root[1].dirc_bxy.length-1)
	    		 isfinishl=true;
	    	 if(isfinishl)
	    		 j1--;
	    	 if(j1==0)
	    		 isfinishl=false;
			   x=root[1].dirc_bxy[j1][0];
	           y=root[1].dirc_bxy[j1][1];
	           Buttel bullet4 = new Buttel(bulletname,40,hero_index-1);
		        bullet4.Updateposition(hero_position_x+width/2-30,hero_position_y,x,y);
		        h_bullet_8.add(bullet4);
	  }
  }
      public  void shoot_spread_round()
      {
    	  switch(bullet_degree)
    	  {
    	  case 1:
    	  {
			Buttel bullet1 = new Buttel("bhero2_2.png",40,hero_index-1);
			bullet1.Updateposition(hero_position_x+width/2+5,hero_position_y,0,0);
			h_bullet_3.add(bullet1);    
    	  }
    	  break;
    	  case 2:
    	  {
    	    Buttel bullet1 = new Buttel("bhero2.png",40,hero_index-1);
			bullet1.Updateposition(hero_position_x+width/2+5,hero_position_y+30,0,0);
			h_bullet_1.add(bullet1);   
    	    Buttel bullet2 = new Buttel("bhero2_2.png",40,hero_index-1);
			bullet2.Updateposition(hero_position_x+width/2+5,hero_position_y+30,0,0);
			h_bullet_2.add(bullet2); 
    	  }
    	  break;
    	  case 3:
    	  {
    	    Buttel bullet1 = new Buttel("bhero2_2.png",40,hero_index-1);
			bullet1.Updateposition(hero_position_x+width/2+5,hero_position_y+weight/2+30,0,0);
			h_bullet_1.add(bullet1);   
  	        Buttel bullet2 = new Buttel("bhero2_3.png",40,hero_index-1);
			bullet2.Updateposition(hero_position_x+width/2+5,hero_position_y+weight/2+30,0,0);
			h_bullet_2.add(bullet2); 
			Buttel bullet3 = new Buttel("bhero2.png",40,hero_index-1);
			bullet3.Updateposition(hero_position_x+width/2+5,hero_position_y+weight/2+30,0,0);
			h_bullet_3.add(bullet3); 
    	  }
    	  break;
    	  case 4:
    	  {
    	    Buttel bullet1 = new Buttel("bhero2_2.png",40,hero_index-1);
			bullet1.Updateposition(hero_position_x+width/2+5,hero_position_y+weight/2+30,0,0);
			h_bullet_1.add(bullet1);   
	        Buttel bullet2 = new Buttel("bhero2.png",40,hero_index-1);
			bullet2.Updateposition(hero_position_x+width/2+5,hero_position_y+weight/2+30,0,0);
			h_bullet_2.add(bullet2); 
			Buttel bullet3 = new Buttel("bhero2_3.png",40,hero_index-1);
			bullet3.Updateposition(hero_position_x+width/2+5,hero_position_y+weight/2+30,0,0);
			h_bullet_3.add(bullet3); 
			Buttel bullet4 = new Buttel("bhero2_4.png",40,hero_index-1);
			bullet4.Updateposition(hero_position_x+width/2+5,hero_position_y+weight/2+30,0,0);
			h_bullet_4.add(bullet4);   
			Buttel bullet5 = new Buttel("bhero2_5.png",40,hero_index-1);
			bullet5.Updateposition(hero_position_x+width/2+5,hero_position_y+weight/2+30,0,0);
			h_bullet_5.add(bullet5);   
			Buttel bullet6 = new Buttel("bhero2_6.png",40,hero_index-1);
			bullet6.Updateposition(hero_position_x+width/2+5,hero_position_y+weight/2+30,0,0);
			h_bullet_6.add(bullet6); 
    	  }
						
    	  }
      }
      public void shoot_hero2()
      {     String bulletname = "missile.png";
    		Buttel bullet = new Buttel(bulletname,40,hero_index-1);
			bullet.Updateposition(hero_position_x+width/2-40,hero_position_y+30,0,0);
			
			h_bullet_10.add(bullet);   
			Buttel bullet1 = new Buttel(bulletname,40,hero_index-1);
			bullet1.Updateposition(hero_position_x+width+22,hero_position_y+30,0,0);
			h_bullet_11.add(bullet1); 
      }
	  public void shoot_sway_r()
	  {
		  if(islive){	
				 if(!isfinishr)
		    		 j2--;
				 if(j2==0)
		    		 isfinishr=true;
		    	 if(j2==root[1].dirc_bxy.length-1)
		    		 isfinishr=false;
		    	 if(isfinishr)
		    		 j2++;
				   x=root[1].dirc_bxy[j2][0];
		           y=root[1].dirc_bxy[j2][1];
		           Buttel bullet5 = new Buttel(bulletname,40,hero_index-1);
					bullet5.Updateposition(hero_position_x+width+12,hero_position_y,x,y);
					h_bullet_9.add(bullet5);       
		  }
	  }
    public void getxy(int x,int y)
    {
    	skill_x=x;
    	skill_y=750;
    }
     public void updateposition(int x,int y)
     {
    	 if(islive)
    	 {
    	 hero_position_x=x;
    	 hero_position_y=y;
    	 }
     }    
     public void death(Graphics g,JPanel L)
     {
    	 if(showblood.blood<=0)
    	 {
    	  islive=false;
    	 }
    	 if(!isj)
    	 {
    	 showblood.updateblood();
    	 
    	 }
     }   
}
