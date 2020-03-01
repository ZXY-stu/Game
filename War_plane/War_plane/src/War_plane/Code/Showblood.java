package War_plane;

import java.awt.Color;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class Showblood{
       public int blood,step,elector,degree=1,grade=0,exp=0,temp,boss_index=0;
       public int width,weight,p_x,p_y,m_weight,index=0;
       boolean bulletchang=false,addenemy=false;
     public static  Image img_skill1,img_skill2,img_skill21,img_skill11,img_pc;
       public String name;
       Font font;
       public String str[]={"列兵","上等兵","下士","中士","上士","四级军士长","三级军士长",
    		   "二级军士长","一级军士长","少尉","中尉","上尉","少校","中校","上校"};
       public String boss[]={"暴走杰克","死亡骑士 -屠城","邪君-影"};
       public String position;
       public Showblood(int step,int width,int weight,int blood,int elector,int m_weight)
       {  
    	   name = "特工001";
    	   font = new Font("隶书",Font.ITALIC,30);
    	   this.step=step;
    	   this.width=width;
    	   this.weight=weight;
    	   this.m_weight=m_weight;
    	   this.blood=blood;
    	   this.elector=elector;
    	   this.position=str[index];
    	   this.temp=blood/2;
    	   img_skill1=Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("skill1.png"));
    	   img_skill2=Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("skill2.png"));
    	   img_skill21=Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("skill21.png"));
    	   img_skill11=Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("skill11.png"));
    	   img_pc=Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("pc2.png"));
       }
       public void drawblood(Graphics g,int index)
       {
    	    Graphics2D g2 = (Graphics2D)g;
           if(index>=0)
           {
        	   g2.setColor(Color.RED);
    	     g2.setFont(new Font("宋体",Font.ITALIC,25));
             g2.drawString("BOSS-"+boss[boss_index], 0, 55);
             g2.drawRect(0, 58, width/2, weight);
             if(temp>=0)
             {
            	  g2.setColor(Color.red);
                  g2.fillRect(0, 58, width/2, weight);
                  g2.setColor(Color.GREEN);
                  g2.fillRect(0, 58,temp, weight);
             }
             else
            	 g2.fillRect(0, 58, blood, weight);
           }
             else{
             g2.setColor(Color.red);
     	     g2.drawRect(p_x,p_y, width,weight);		
     	     g2.setColor(Color.GREEN);
    	     g2.fillRect(p_x,p_y, blood, weight);
             }
       }
       public void h_drawblood(Graphics g,JPanel L)
       {
    	  Graphics2D g2 = (Graphics2D)g;
    	   g2.setFont(new Font("宋体",Font.BOLD,12));
   	      g2.setColor(Color.red);
   	      g2.drawRect(30,m_weight+5, width,weight);		
   	      g2.setColor(Color.GREEN);
   	      g2.fillRect(30,m_weight+5, blood, weight);
   	      g2.setColor(Color.CYAN);
   	      g2.drawString("玩家:"+ name, 0, m_weight);
   	      g2.setColor(Color.red);
   	      g2.drawString("血量：", 0,m_weight+15);
   	      g2.setColor(Color.GREEN);
   	      g2.drawString("蓝量：",0,m_weight+30);
   	      g2.setColor(Color.DARK_GRAY);
   	      g2.drawRect(30, m_weight+21, width, weight);
   	      g2.setColor(Color.BLUE);
   	      g2.fillRect(30,m_weight+21,elector, weight);
   	      g2.setColor(Color.YELLOW);
   	      g2.drawString("等级："+degree,100,m_weight);
   	      g2.setColor(Color.ORANGE);
   	      g2.drawString("军衔:" + position,180,m_weight);
   	      g2.drawRect(30, m_weight+37, width, weight);
   	      g2.setColor(Color.DARK_GRAY);
   	      g2.fillRect(30, m_weight+37, exp, weight);
   	      g2.setColor(Color.WHITE);
   	      g2.drawString("等级：", 0, m_weight+46);
   	      g2.setColor(Color.GREEN);
   	     
g2.drawImage(img_pc, -10, -5, (ImageObserver)L);
g2.drawString("分数："+grade, 50, 27);
   	      g2.setColor(Color.PINK);
   	  
   	      g.setColor(Color.YELLOW);
   	      g.drawString("技能：", 270,m_weight+35);
   	      if(this.degree>=1)
   	   g.drawImage(img_skill2,370,m_weight+15,30,30,(ImageObserver)L);
   	   if(elector<100 || this.degree<6)
   	  g.drawImage(img_skill21,370,m_weight+15,30,30,(ImageObserver)L);
   	      g.drawString("K:", 360, m_weight+35); 
   	 if(this.degree>=1)
   	 g.drawImage(img_skill1,320,m_weight+15,30,30,(ImageObserver)L);
   	 if(elector<50 || this.degree<3)
     g.drawImage(img_skill11,320,m_weight+15,30,30,(ImageObserver)L);
   	  g.drawString("J:", 310, m_weight+35);
    	}
       public void updateblood()
       {   
    	      blood-=step;
    	       temp-=step;
       }
       public void updatebossblood(int blood,int  bossindex)
       {
    	      this.blood=blood;
    	      this.width=blood;
    	      this.temp=blood/2;
    	      this.boss_index=bossindex;
       }
       public void updateposition(int x,int y)
       {
    	     p_x=x;
    	     p_y=y;
       }
       public void update(int exp,int grade)
       {
    	   this.exp+=exp;
   	      if(this.exp>=200)
   	    {
   	    	 this.degree++;
   	         if(this.degree%4==0)
   	         {
   	        	 index++;
   	             bulletchang = true;  
   	           
   	             step+=1;
   	         }
   	       if(this.degree%3==0)
   	    	   addenemy=true;
   	         
   	         this.exp=0;
   	         position = str[index];
   	    	 blood=200; 
   	    	 elector=200;
   	    }
   	      this.grade+=grade;    
       }

}
