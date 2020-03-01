package War_plane;
import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.Timer;
public class Game_draw extends JPanel implements Runnable,ActionListener{
	public int bullet_num=11,enemysize=0,size;
   Image img_win,img_fire,img_run,img_win1;
    public  BackGround bg; 
    public Enemy []enemy;
    public Buttel [] bullet;
    public String [] name = {"迷失星球","混沌虚空","X-暗星"};
    public Hero hero;
    public int enemy_shoot,j=0,x=30,x1=10,hero_index=1,shoot_num=0,enemy_count=0,typecount=2,isskill=0,whoshow=1,enemy_kill_count=0;
    public int count=0,count1=0,bullet_index=1,boss_index=0,width,weight,enemy_index=0,num,num1=40,num2=20,delay_packet,delay,timecount=5,timek=0,delayj,delayk,timej=0,delaynj,delay_isstart=0,delay_isover=0;
    boolean bossshow=false,i=true,push=true,pushk=true,istouch=false,istouchb=false,isl=true,isr=false,ispass=false,isplay=true,isbplay=true,isbdplay=true,islevelup=false,iswin=true,isstartcount=false,isstartcountj=false,isstartcountk=false;
    boolean islearnj=false,islearnk=false,isgetnews=false,isfinishy=false,iscount=true,isinit_enemy=false,pass=false,isstart=false,isover=false,alldeath=false,isstartcount_packet=false,havepacket=false,isshoot=true;
    Rootnum root;
    Random r;
    Timer t;
    Enemy_Boss boss[];
    Game_control control;
    static  result game;
    Sound sound;
    bksound bsound;
	public Game_draw(int width,int weight,int acount)
    {   
	 bg =   new BackGround(width,weight);
	 bsound = new bksound();
     sound = new Sound();
	 this.weight = weight;
	 game = new result();
     t= new Timer(100, this);
     sound.init("in.wav");
     img_win = Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("win2.png"));
     img_win1 = Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("win1.png"));
     img_fire = Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("update.png"));
     img_run = Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("running.png"));
	 boss = new Enemy_Boss[3];
	 for(int i=1;i<=3;i++)
	  boss[i-1] = new Enemy_Boss("boss" + i+ ".png", 100,-100,i-1);
	 r = new Random(System.currentTimeMillis());
	 root = new Rootnum();
	 enemy = new Enemy[acount];
	 this.enemysize=acount;
	 for(int i=0;i<enemysize;i++)/*初始化所有敌机*/
	 { 
		 if(i<5)
		 {
			 if(i==3)
				 havepacket=true;
			 if(i==2)
				 havepacket=true;
		 enemy[i]= new Enemy(root.getroot(0,0)-i*50,root.getroot(0,1)+i*30,0,0,3,width,havepacket);
		    if(havepacket)
		    	havepacket=false;
		 }
		 else if(i>=5 && i<10)
		 {
			
		 enemy[i]= new Enemy(root.getroot(1,0)+i*50,root.getroot(1,1)+i*30,1,0,3,width,havepacket);
	
		 }
		 else if(i>=10 && i<12)
		 {
			 if(i==10)
				 havepacket=true;
			 enemy[i]= new Enemy(root.getroot(typecount,0),root.getroot(typecount,1),typecount,1,3,width,havepacket);
			 typecount++;
			 if(havepacket)
				 havepacket=false;
			
		 }
		 else if(i>=12 && i<14)
		 {
			 if(i==12)
				 havepacket=true;
			 enemy[i]= new Enemy(root.getroot(typecount,0),root.getroot(typecount,1),typecount,2,3,width,havepacket);
			 typecount++;
			 if(havepacket)
			    	havepacket=false;
		 }
		 else if(i>=14 && i<17)
		 {
			 if(i==15)
				 havepacket=true;
			 enemy[i]= new Enemy(root.getroot(typecount,0),root.getroot(typecount,1),typecount,3,3,width,havepacket);
			 typecount++;
			 if(havepacket)
			 havepacket=false;
		 }
	 }
   	
  	 hero = new Hero(width/2-40,weight+60,70,70,weight-80,"bhero"+hero_index+".png",1,hero_index);
    }
		public void updateenemy()/*达到一定的等级之后，添加新的敌机*/
		{
				for(int i=0;i<enemysize;i++)
				{
					enemy[i].live=true;
					enemy[i].islive=true;
					enemy[i].show.blood=enemy[i].blood[enemy[i].enemytype];
					enemy[i].distance=enemy[i].s_x;
					enemy[i].enemy_position=enemy[i].s_y;
					enemy[i].num=0;
					if(enemy[i].havepacket)
					{
						enemy[i].packet.islive=true;
					}
				}			
		}
     public void paint(Graphics g){
    	 super.paint(g);
    	   
    	if(isbplay){
    		isbplay=false;          
    		bsound.init("bkmc.au");
    		bsound.start();
    		sound.start();
    	}
	    
	     if(Game_Choose_plane.planea)
	  			hero.hero_index=1;
	  		if(Game_Choose_plane.planeb)
	  			hero.hero_index=2;
	  		if(Game_Choose_plane.planec)
	  			hero.hero_index=3;
	  		hero.bulletname="bhero" + hero.hero_index+".png";
	  		if(Game_Point.point1)
	  		{
	  		boss_index=0;
	  		bg.index=1;
	  		}
	  	   if(Game_Point.point2)
	  		{
	  		boss_index=1;
	  		bg.index=2;
	  		}
	  	   if(Game_Point.point3)
	  		{
	  		bg.index=3;
	  		boss_index=2;
	  		}
	  	   
	  	 bg_update(g);/*在屏幕上显示相关图片*/
	  	hero.Draw_hero(g, this,true);
	     if(isstart && !isover)
	     {
	    	
	     for(int i=0;i<enemysize;i++)//这里判断敌机子弹是否与我方战机发生碰撞，敌机是否与我方战机发生碰撞
	     {  
	    	 
	    	  if(enemy[i].islive)
	    		 istouch_enemy(g);/*判断我方子弹是否达到敌机*/
	    	     enemy[i].heroposition(hero.hero_position_x, hero.hero_position_y, hero.width,hero.weight,hero.islive);
	    	 
		    	 if(!enemy[i].live)//敌方死亡之后，我方战机得到相对数量的经验
		    	 {
		    		 enemy[i].live=true;
		    		 if(isskill==0)
		    		 hero.showblood.update(30+ boss_index*10,50+bullet_index*10);
		    		 else 
		    			 isskill--;
		    			 
		    		 sound.init("edeath.au");
		    		 sound.start();
		    		 enemy_count++;
		    		 enemy_kill_count++;
		    	 }
		    		if(enemy[i].isstartmove)
		    		{
		    			enemy[i].packet.heroposition(hero.hero_position_x, hero.hero_position_y, hero.width,hero.weight,hero.islive);
		    			if(enemy[i].packet.islive)
		    			{
		    			  enemy[i].packet.draw_packet(g, this);
		    			  enemy[i].packet.updateposition();
		    			}
		    			if(enemy[i].packet.istouch())
		    			{
		    				enemy[i].packet.init();
		    				enemy[i].packet.islive=false;
		    				enemy[i].isstartmove=false;
		    				 if(hero.bullet_degree<4)
		    				 {
		    				  hero.bullet_degree++;
		    				  sound.init("levelup.wav");
		    				  sound.start();
		    				   isstartcount_packet=true;
		    				   delay_packet=0;
		    				 }
		    				 else 
		    				 {	
					    			 hero.isenough=true;
					    			 shoot_num=0;
					    			 sound.init("waring.au");
					    			 sound.start();
					    			 sound.init("light.wav");
					    			 sound.start();	
					    			 isstartcount_packet=true;
		    				 }	
		    				
		    			}
		    			 
		    		}
		    		 if(delay_packet<40 && isstartcount_packet)
   				  {
	    				  g.setFont(new Font("宋体",Font.ITALIC,30));
	    				  g.setColor(Color.white);
	    				  if(hero.isenough)  
	    				  { 
   				        g.drawString("雷霆之怒！！！！", 170, 250);	
   				  // g.drawImage(img_run, 170, 250, this);
   				        if(hero.hero_index!=3)
   				      hero.crazy=true;
	    				  }
	    				  else 
	    				  {
	    					g.drawImage(img_fire, 170, 250, this);
	    				  }
	    				 // g.drawString("火力提升！！！", 170, 250);	
   				  }
   				  if(delay_packet>40)
   				  {
   					  delay_packet=0;
   					  isstartcount_packet=false;
   				  }
	    	 if(enemy[i].istouch()&& hero.islive)//碰撞之后，我方战机掉血
	    	 {
	    		hero.death(g,this);  
	    		if(!hero.isj ){
	    		 sound.init("hert.au");
				 sound.start();
	    		}		
	    	 }
	    	
	    		if(enemy_count<5)
		 	   		 whoshow=1;
		 	   	else  if(enemy_count>=5 && enemy_count<10)
					 whoshow=2;
				 else if(enemy_count>=10 && enemy_count<12)
					 whoshow=3;
				 else if(enemy_count>=12 && enemy_count<14)
					 whoshow=4;
				 else if(enemy_count>=14 && enemy_count<17)
					 whoshow=5;
				 else 
				 {
					 enemy_count=0;
					 if(enemy_kill_count<=24)
					 updateenemy();
					 else 
						 alldeath=true;
				 }
	    	 
	     if( alldeath)//背景图片移动到最后是，boss出现
	     { bossshow=true;
	     
	     
	     for(int j=0;j<enemysize;j++)
	    	   enemy[j].islive=false;
	     
	    	 if(boss[boss_index].islive)
	    	 { 
				 if(isplay){//boss出现后，播放boss背景音乐
		    	  sound.init("bossshow.au");
		    	  sound.start();
		    	  bsound.stop();
		    	  bsound.init("bossbk.wav");
		    	  bsound.start();
		    	  isplay=false;
		    	 }
				
				 iswin=true;
				 boss[boss_index].heroposition(hero.hero_position_x, hero.hero_position_y, hero.width,hero.weight,hero.islive);
				 istouch_boss(g);//检测我方的子弹与boss是否发生碰撞
				
				 if(boss[boss_index].istouch()&& hero.islive)//检测我方战机与敌方子弹是否发生碰撞，与boss是否发生碰撞
				 {
					 hero.death(g,this);
					 if(!hero.isj){
					 sound.init("hert.au");
					 sound.start();
					 }
				 }
	    	 }
	    	 else{ //如果boss死亡,初始化敌机位置，敌机血量，背景更换，我方血量，蓝量
	    		 if(iswin){
	    		 sound.init("win.au");
	    		 sound.start();
	    		 iswin=false;
	    		 bsound.stop();	 
	    		 } 
	    		 num1=40;
			    if(boss[boss_index].live)
			    {
			    hero.showblood.update(100+boss_index*50, 1000);
			    boss[boss_index].live=false;
			    }
			    if(isbdplay)
			    {
			    sound.init("bomb.au");
			    sound.start();
			    isbdplay=false;
			    }
			    g.setFont(new Font("宋体",Font.ITALIC,25));
			   
			   if(boss_index==2)  //通关了所有关卡
			   {
				   g.drawString("恭喜你！通过了所有关卡！，感谢你的参与！", 10, 300);	
				   game.update(hero.showblood.name,Integer.toString(hero.showblood.grade), Integer.toString(hero.showblood.degree), hero.showblood.position);
					if(!control.isover){
						control.isover=true;
				        game.pocess();
				   	 bsound.stop();
					}
				   game.paint(g, this);
				   g.drawString("按ENter键继续", 110, 550);
				   g.drawString("按k键退出游戏", 260, 550);
				   if(control.isnext)
				   {
					    pass=true;
					    isover=true;
				   }
				  
			   }
			   else //boss死亡后
			   {
				  
				   game.update(hero.showblood.name,Integer.toString(hero.showblood.grade), Integer.toString(hero.showblood.degree), hero.showblood.position);
				if(iscount)
				{
				        game.pocess();
				        iscount=false;
				}
				   bsound.stop();
				   game.paint(g, this);
				   g.drawString("按ENter键继续", 150, 550);
				   bossshow=false;
				   isshoot=false;
				   if(control.isnext)
				   {
					isover=true;					
				    pass=true;
				   }
	    	 } 
	      }
	    	 if(bossshow)
	    	 if(num1<=70)
			 {  
				 g.setFont(new Font("宋体",Font.ITALIC,x));
			     g.setColor(Color.RED);
			     g.drawString("Waring! BOSS show", 100, 300);
			  
			 }
	     }
	    
	     }
	     }
	     }
	@Override
     public void run() {
		 while(true)
		 {  
			 repaint();
		 try {  
				Thread.sleep(60);
			}catch (InterruptedException  e){
				  e.getStackTrace();
			}	 
		}
     }
	public void istouch_enemy(Graphics g)
	{
		istouch(g,hero.h_bullet_1);
		istouch(g,hero.h_bullet_10);
		istouch(g,hero.h_bullet_11);
		istouch(g,hero.h_bullet_2);
		istouch(g,hero.h_bullet_3);
		istouch(g,hero.h_bullet_4);
		istouch(g,hero.h_bullet_5);
		istouch(g,hero.h_bullet_6);
		istouch(g,hero.h_bullet_7);
		istouch(g,hero.h_bullet_8);
		istouch(g,hero.h_bullet_9);
		istouch(g,hero.h_bullet_12);
		istouch(g,hero.h_bullet_13);
	}
	public void istouch_boss(Graphics g)
	{
	  b_istouch(g,hero.h_bullet_1);
	  b_istouch(g,hero.h_bullet_2);
	  b_istouch(g,hero.h_bullet_3);
	  b_istouch(g,hero.h_bullet_4);
	  b_istouch(g,hero.h_bullet_5);
	  b_istouch(g,hero.h_bullet_6);
	  b_istouch(g,hero.h_bullet_7);
	  b_istouch(g,hero.h_bullet_8);
	  b_istouch(g,hero.h_bullet_9);
	  b_istouch(g,hero.h_bullet_10);
	  b_istouch(g,hero.h_bullet_11);
	  istouch(g,hero.h_bullet_12);
	  istouch(g,hero.h_bullet_13);
	}
 	public void istouch(Graphics g,Vector<Buttel> b)
 	{ 
 		for(int j=0;j<enemysize;j++)
			{
				for(int  i=0;i<b.size();i++)
		 		{		
		  if(hero.islive&&enemy[j].enemy_position >b.get(i).bullet_position_y&& enemy[j].enemy_position <b.get(i).bullet_position_y+ enemy[j].enemy_weight && hero.hero_position_y>enemy[j].enemy_position &&enemy[j].distance+enemy[j].enemy_width> b.get(i).bullet_position_x+25
				  &&enemy[j].distance+enemy[j].enemy_width<b.get(i).bullet_position_x+b.get(i).bullet_width+25)
	 		  {   

		           b.remove(i);
		 			enemy[j].death(g,this);
	 		 }else
		  if(b.get(i).bullet_position_x<-30 ||b.get(i).bullet_position_y>750 ||b.get(i).bullet_position_y<-50 ||b.get(i).bullet_position_x>550)
		    {
		    	b.remove(i);
		    	
		    }
		 
			}
			}
 	}
 	
 	public void b_istouch(Graphics g,Vector<Buttel> b)
 	{
		 for(int i=0;i<b.size();i++)
 		  {    
 			    if(hero.islive&&b.get(i).islive &&b.get(i).bullet_position_y- (boss[boss_index].boss_y) >=0 &&
 			    		b.get(i).bullet_position_y- (boss[boss_index].boss_y ) <=boss[boss_index].weight &b.get(i).bullet_position_x
 			    		 >=boss[boss_index].boss_x+10 && b.get(i).bullet_position_x+b.get(i).bullet_width <=( boss[boss_index].boss_x + boss[boss_index].width) && boss[boss_index].islive)
 			    { 	
 			    
 			    	  b.remove(i);
 			    	  boss[boss_index].death(g, this);   
 			    }else
 			    if(b.get(i).bullet_position_x<-30 || b.get(i).bullet_position_y>750 || b.get(i).bullet_position_y<-50 ||b.get(i).bullet_position_x>550)
 			    {
 			    	b.remove(i);
 			    	
 			    }
 		  }
 	}
 	public void bg_update(Graphics g)
 	{  
 		 bg.DrawBg(g, this,boss_index+1);
 		 if(num<=40)
 		 {    g.setFont(new Font("宋体",Font.ITALIC,25));
 		      g.setColor(Color.red);
 			  g.drawString("第" + (boss_index+1) + "关 " + name[boss_index], 150, 300);
 		 }
 		 g.setFont(new Font("宋体",Font.BOLD,12));
 		
 	   	  if(isstart && !isover)
 	   	  {
 		 for(int i=0;i<enemysize;i++) 
 	   	  {  
 			
 				if(enemy[i].islive)
 				{
			 	   	switch(whoshow)
			 	   	{
			 	   	case 1:
			 	   		if(i<5)
			 	   		{
			 	   		 if(enemy[i].enemy_position<-200)
			 	   		 {
			 	   	    	 enemy_count++;
			 	   	    	 enemy[i].islive=false;
			 	   		 }
			 	    	     enemy[i].updateposition_round_l();
			 	   		}
			 	   	     break;
			 	   	case 2: 
			 	   		if(i>=5 && i<10)
			 	   		{
			 	   			if(enemy[i].enemy_position<-200)
			 	   			{	enemy_count++;
			 	   				enemy[i].islive=false;
			 	   			}
			 	   	       enemy[i].updateposition_round_r();
			 	   		}
		 	   	        break;
			 	   	case 3:
			 	   		if(i>=10 && i<12)
			 	   		enemy[i].UpdatePosition();
			 	   		break;
			 	   	case 4:
			 	   		if(i>=12 && i<14)
			 	     	enemy[i].UpdatePosition();
		 	   	        break;
			 	   	case 5:
			 	   		if(i>=14 && i<17)
			 	     	enemy[i].UpdatePosition();
			 	   	}	  
			 	   enemy[i].Drawenemy(g, this);
 				}
 	   	  }
 	   	  for(int i=0;i<enemysize;i++)
 	   	  {
 	   		 
 	   		 for(int j=0;j<enemy[i].e_bullet.size();j++)
 	   		 {
 	   		     if(i<5)
 	   		     {
 	   		    	 enemy[i].e_bullet.get(j).shoot(10);
 	   		         enemy[i].e_bullet.get(j).Draw_bullet(g, this);
 	   		     }
 	   		     else if(i>=5 && i<10)
 	   		     {
	   		    	 enemy[i].e_bullet.get(j).shoot(10);
	   		    	 enemy[i].e_bullet.get(j).Draw_bullet(g, this);
 	   		     }
 	   		     else if(i>=10 && i<12)
 	   		     {
 	   		    	 enemy[i].e_bullet.get(j).shoot_round();
 	   		         enemy[i].e_bullet.get(j).Draw_bullet(g, this);
 	   		     }
 	   		     else if(i>=12 && i<14 )
 	   		     {
 	   		    	 enemy[i].e_bullet.get(j).shoot_round();
 	   		         enemy[i].e_bullet.get(j).Draw_bullet(g, this);
 	   		     }
 	   		  else if(i>=14 && i<17 )
	   		     {
	   		    	 enemy[i].e_bullet.get(j).shoot_round();
	   		         enemy[i].e_bullet.get(j).Draw_bullet(g, this);
	   		     }
 	   			 }
 	   		
 	   		 
 	   	  }
 	     if(hero.islive)
	   	  { 
 	    	 if(isshoot)
 	    	 {
 	    		if(hero.hero_index!=2)
 	    		{
 	    	for(int i=0,j=0;i<hero.h_bullet_7.size();i++)
	 	     {
 	    	    
	 	 	      hero.h_bullet_7.get(i).shoot_light(hero.hero_position_x+hero.width/2+5,30);
	 	 	    if(shoot_num>15 && shoot_num<=75)
	 	 	      hero.h_bullet_7.get(i).Draw_bullet(g, this);
	 	     }
	 	   	  for(int i=0,j=0;i<hero.h_bullet_1.size();i++)
	 	   	  {  	
	 	  	     hero.h_bullet_1.get(i).Draw_bullet(g, this);
	 	         hero.h_bullet_1.get(i).shoot(-30);	
	 	   	  }
	 	     for(int i=0,j=0;i<hero.h_bullet_2.size();i++)
	 	     {
	 	 	  	  hero.h_bullet_2.get(i).Draw_bullet(g, this);
	 	 	      hero.h_bullet_2.get(i).shoot(-30);
	 	     }
 	    	 for(int i=0,j=0;i<hero.h_bullet_3.size();i++)
 	 	 	     {
 	 	 	 	  	  hero.h_bullet_3.get(i).Draw_bullet(g, this);
 	 	 	 	      hero.h_bullet_3.get(i).shoot(-30);
 	 	 	     }
 	    	for(int i=0,j=0;i<hero.h_bullet_4.size();i++)
 	 	     {
 	 	 	  	  hero.h_bullet_4.get(i).Draw_bullet(g, this);
 	 	 	      hero.h_bullet_4.get(i).shoot(-30);
 	 	     }
 	    	for(int i=0,j=0;i<hero.h_bullet_5.size();i++)
 	 	     {
 	 	 	  	  hero.h_bullet_5.get(i).Draw_bullet(g, this);
 	 	 	      hero.h_bullet_5.get(i).shoot_missile_l();
 	 	     }
 	    	for(int i=0,j=0;i<hero.h_bullet_6.size();i++)
	 	     {
	 	 	  	  hero.h_bullet_6.get(i).Draw_bullet(g, this);
	 	 	      hero.h_bullet_6.get(i).shoot_missile_r();
	 	     }
 	   	for(int i=0,j=0;i<hero.h_bullet_8.size();i++)
	     {
	 	  	  hero.h_bullet_8.get(i).Draw_bullet(g, this);
	 	      hero.h_bullet_8.get(i).shoot_round();
	     }
 		for(int i=0,j=0;i<hero.h_bullet_9.size();i++)
	     {
	 	  	  hero.h_bullet_9.get(i).Draw_bullet(g, this);
	 	      hero.h_bullet_9.get(i).shoot_round();
	     }
 		for(int i=0,j=0;i<hero.h_bullet_12.size();i++)
	     {
	 	  	 
	 	      hero.h_bullet_12.get(i).shoot_light(hero.hero_position_x+2, 30);
	 	    if(shoot_num>15 && shoot_num<=75)
 		 	  	  hero.h_bullet_12.get(i).Draw_bullet(g, this);
	     }
		for(int i=0,j=0;i<hero.h_bullet_13.size();i++)
	     {
	 	  	 
	 	      hero.h_bullet_13.get(i).shoot_light(hero.hero_position_x+hero.width+8,30);
	 	    if(shoot_num>15 && shoot_num<=75)
 		 	  	  hero.h_bullet_13.get(i).Draw_bullet(g, this);
	     }
 	    		}
 		if(hero.hero_index==2)
 		{  //if(shoot_num>15 && shoot_num<=75)
 			for(int i=0,j=0;i<hero.h_bullet_7.size();i++)
	 	     {
	    	      
	 	 	      hero.h_bullet_7.get(i).shoot_light(hero.hero_position_x+hero.width/2+5,30);
	 	 	    if(shoot_num>15 && shoot_num<=75)
	 	 	      hero.h_bullet_7.get(i).Draw_bullet(g, this);
	 	     }
 			  for(int i=0,j=0;i<hero.h_bullet_1.size();i++)
	 	   	  {  	
	 	  	     hero.h_bullet_1.get(i).Draw_bullet(g, this);
	 	         hero.h_bullet_1.get(i).shoot_spread_round(-12, 12);
	 	   	  }
	 	     for(int i=0,j=0;i<hero.h_bullet_2.size();i++)
	 	     {
	 	 	  	  hero.h_bullet_2.get(i).Draw_bullet(g, this);
	 	 	      hero.h_bullet_2.get(i).shoot_spread_round(12, 12);
	 	     }
 	    	 for(int i=0,j=0;i<hero.h_bullet_3.size();i++)
 	 	 	     {
 	 	 	 	  	  hero.h_bullet_3.get(i).Draw_bullet(g, this);
 	 	 	 	      hero.h_bullet_3.get(i).shoot_spread_round(0, 12);
 	 	 	     }
 	    	for(int i=0,j=0;i<hero.h_bullet_4.size();i++)
 	 	     {
 	 	 	  	  hero.h_bullet_4.get(i).Draw_bullet(g, this);
 	 	 	      hero.h_bullet_4.get(i).shoot_spread_round(0, -12);
 	 	     }
 	    	for(int i=0,j=0;i<hero.h_bullet_5.size();i++)
 	 	     {
 	 	 	  	  hero.h_bullet_5.get(i).Draw_bullet(g, this);
 	 	 	      hero.h_bullet_5.get(i).shoot_spread_round(-12, -12);
 	 	     }
 	    	for(int i=0,j=0;i<hero.h_bullet_6.size();i++)
	 	     {
	 	 	  	  hero.h_bullet_6.get(i).Draw_bullet(g, this);
	 	 	      hero.h_bullet_6.get(i).shoot_spread_round(12, -12);
	 	     }
 	     	for(int i=0,j=0;i<hero.h_bullet_10.size();i++)
 		     {
 		 	  	  hero.h_bullet_10.get(i).Draw_bullet(g, this);
 		 	      hero.h_bullet_10.get(i).shoot(-30);
 		     }
 	 		for(int i=0,j=0;i<hero.h_bullet_11.size();i++)
 		     {
 		 	  	  hero.h_bullet_11.get(i).Draw_bullet(g, this);
 		 	      hero.h_bullet_11.get(i).shoot(-30);
 		     }
 	 	  	for(int i=0,j=0;i<hero.h_bullet_8.size();i++)
 		     {
 		 	  	  hero.h_bullet_8.get(i).Draw_bullet(g, this);
 		 	      hero.h_bullet_8.get(i).shoot_round();
 		     }
 	 		for(int i=0,j=0;i<hero.h_bullet_9.size();i++)
 		     {
 		 	  	  hero.h_bullet_9.get(i).Draw_bullet(g, this);
 		 	      hero.h_bullet_9.get(i).shoot_round();
 		     }
 	 	
 		}
 	    	 }
	   	  }
 	     else 
 	     { 	
 	     if(!control.isover)
 	     { game.update(hero.showblood.name,Integer.toString(hero.showblood.grade), Integer.toString(hero.showblood.degree), hero.showblood.position);
 	    	 game.pocess();
 	    	sound.init("hdeath.au");
 	    	sound.start();
 	    	bsound.stop();
 	    	control.isover=true;
 	     }
 	    	 game.paint(g, this);  	
 	    	 g.drawString("按ENter键继续", 150, 550);
 	    	 if(control.isnext)
 	    	 {
 	    		 pass=true;
 	    		 System.out.print(alldeath);
 	    		
 	    	 }
 	     }
 	     if(bossshow)//更新boss的实时信息
 	     {
 	    	
 	    	  for(int i=0;i<boss[boss_index].e1_bullet.size();i++)
 	    	  {
 	    		  boss[boss_index].e1_bullet.get(i).Draw_bullet(g, this);
 	    		  boss[boss_index].e1_bullet.get(i).shoot(15);
 	    	
 	    	  }
 	    	 for(int i=0;i<boss[boss_index].e2_bullet.size();i++)
	    	  {
	    		  boss[boss_index].e2_bullet.get(i).Draw_bullet(g, this);
	    		  boss[boss_index].e2_bullet.get(i).shoot(15);
	    	
	    	  }
 	    	 for(int i=0;i<boss[boss_index].e3_bullet.size();i++)
	    	  {
	    		  boss[boss_index].e3_bullet.get(i).Draw_bullet(g, this);
	    		  boss[boss_index].e3_bullet.get(i).shoot(15);
	    	
	    	  }
 	    	for(int i=0;i<boss[boss_index].e4_bullet.size();i++)
	    	  {
	    		  boss[boss_index].e4_bullet.get(i).Draw_bullet_boss(g, this);
	    		  boss[boss_index].e4_bullet.get(i).shoot_spread();
	    	
	    	  }
 	    	  for(int i=0;i<boss[boss_index].e5_bullet.size();i++)
 	    	  {
 	    		  boss[boss_index].e5_bullet.get(i).Draw_bullet_boss(g,this);
 	    		  boss[boss_index].e5_bullet.get(i).shoot_spread();		  
 	    	  }
 	    	  for(int i=0;i<boss[boss_index].e6_bullet.size();i++)
 	    	  {
 	    		  boss[boss_index].e6_bullet.get(i).Draw_bullet(g, this);
 	    		  boss[boss_index].e6_bullet.get(i).shoot_round();		  
 	    	  }
 	    	 for(int i=0;i<boss[boss_index].e7_bullet.size();i++)
	    	  {
	    		  boss[boss_index].e7_bullet.get(i).Draw_bullet(g, this);
	    		  boss[boss_index].e7_bullet.get(i).shoot_round();		  
	    	  }
 	    	for(int i=0;i<boss[boss_index].e8_bullet.size();i++)
	    	  {
	    		  boss[boss_index].e8_bullet.get(i).Draw_bullet(g, this);
	    		  boss[boss_index].e8_bullet.get(i).shoot_round();		  
	    	  }
 	    	for(int i=0;i<boss[boss_index].e9_bullet.size();i++)
	    	  {
	    		  boss[boss_index].e9_bullet.get(i).Draw_bullet(g, this);
	    		  boss[boss_index].e9_bullet.get(i).shoot_round();  
	    	  }
 	    	for(int i=0;i<boss[boss_index].e10_bullet.size();i++)
	    	  {
	    		  boss[boss_index].e10_bullet.get(i).Draw_bullet(g, this);
	    		  boss[boss_index].e10_bullet.get(i).shoot_round();  
	    	  }
 	    	  for(int i=0;i<boss[boss_index].e12_bullet.size();i++)
 	    	  {
 	    		
 	    		  boss[boss_index].e12_bullet.get(i).Draw_bullet_boss(g,this);
 	             boss[boss_index].e12_bullet.get(i).shoot_spread();	  
 	    	  }
 	    	  boss[boss_index].draw_boss(g, this);
 	    	  boss[boss_index].updateposition();	    	  
 	     }
 	     if(i)
 	     {
 	    	i=false;
 	    	 boss[boss_index].draw_boss(g, this);
 	    	
 	     } 
 	   if(isshoot)
 	   {
 	      if(control.a || control.a1)//键盘检测
 	      if(hero.hero_position_x>=0)
 	    	hero.hero_position_x-=20;
 	      if(control.d || control.d1)
 	      if(hero.hero_position_x<=400)
 	    	hero.hero_position_x+=20;
          if(control.s || control.s1)
        	  if(hero.hero_position_y<=560)
        	  hero.hero_position_y+=20;
          if(control.w || control.w1)
        	  if(hero.hero_position_y>=0)
        	  hero.hero_position_y-=20;
          
          if(control.j && hero.showblood.elector>=50)
          {	  
        	    if(push && hero.showblood.degree>=3 && timej==0)
        	    {
        	     hero.isj=true;
        		 hero.showblood.elector-=50;
        		 push=false;
        		 sound.init("protect1.au");
        		 sound.start();
        		 timej=4;
        		 delayj=0;
        		 isstartcountj=true;
        	    } else if(timej>0)
        	    {
        	    	g.setColor(Color.RED);
            		g.drawString("技能冷却中。。", 200, 300);
        	    }
        	   
        	    if(hero.showblood.degree<3)
        	    {
        	    	g.setColor(Color.RED);
        	    	g.setFont(new Font("宋体",Font.BOLD,25));
        	    	g.drawString("未学得此技能",180, 300);
        	    	
        	    }
          }
          if(hero.showblood.degree==3 && delaynj<=30)//
          {
        	  isgetnews=true;
        	  if(delaynj==0)
        	  {
        	   sound.init("levelup.wav");
  	    	   sound.start();
        	  }
        	  g.drawString("获得新技能，无敌光环", 200, 300);
        	  g.drawImage(hero.showblood.img_skill1,205,310, this);
          }
        
        	  if(hero.showblood.degree>3 && hero.showblood.degree<=5)
        	  {
        		  isgetnews=false;
        		  delaynj=0;
        	  }
          if(hero.showblood.degree==6 && delaynj<=30)//
          {
        	  if(delaynj==0)
        	  {
        		 sound.init("levelup.wav");
  	    	      sound.start();
        	  }
        	  isgetnews=true;
        	  g.drawString("获得新技能，毁天灭地", 200, 300);
        	  g.drawImage(hero.showblood.img_skill2,205,310, this);
          }
          g.setColor(Color.GREEN);
          g.setFont(new Font("宋体",Font.BOLD,15));
          g.drawString(timek+"",375,650); 
          g.drawString(timej+"",340,650); 
           if(control. k && hero.showblood.elector>=100)
           {  
        	   if(pushk && timek==0 && hero.showblood.degree>=6)
        	   { sound.init("bomb1.au");
        	     sound.start();
         		 hero.showblood.elector-=100;
         		 hero.isk=true;
         		 pushk=false;
         		 hero.alive=true;
         		 hero.getxy(hero.hero_position_x, hero.hero_position_y);
         		 timek=5;
         		 delayk=0;
         		isstartcountk=true;
         	
        	   }else if(timek>0)
        	   {
        		g.setColor(Color.RED);
        		g.drawString("技能冷却中。。", 200, 300);
        	   }
        	 
        	   if(hero.showblood.degree<6)
       	    {
       	    	g.setColor(Color.RED);
       	    	g.setFont(new Font("宋体",Font.BOLD,25));
       	    	g.drawString("未学得此技能",180, 300);
       	    }
           }
           if(count==25)
           {
        	   count=0;
        	   hero.isj=false;
        	   push=true;
           }
           if(hero.isk && hero.alive)
         	   hero.draw_skill(g, this);
 	   }
           if(istouch)
           { 
           for(int j=0;j<enemysize;j++)
	 		  {
        	   if(enemy[j].enemy_position>=-50 && enemy[j].enemy_position<=750 && enemy[j].distance>-50 && enemy[j].distance<550)
        	   { enemy[j].show.blood=0; isskill++;}
	 		       enemy[j].death(g, this);
	 		       istouch=false;   
	 		  }
           if(bossshow)
		      {
        	     if(boss[boss_index].show.temp>=80)
        	     {
        	    	 boss[boss_index].show.temp-=80;
        	    	 boss[boss_index].show.blood-=80;
        	     }
        	     else 
        	     {
        	    	boss[boss_index].show.blood-=80 - boss[boss_index].show.temp;
        	    	boss[boss_index].show.temp=0;
        	     }
		    	    boss[boss_index].death(g, this);
		      }
           }
          
 	   	  }
 	   	 if(!isstart && !isover)
         {
      	   hero.hero_position_y-=3;   
         }
         if(isover)
         {
        	 g.drawImage(img_win, 130, 270, this);
			   g.drawImage(img_win1, 150, 210, this);       
      	   hero.hero_position_y-=12;
      	    isstart=false;
      	  sound.stop();
      	  bsound.stop();
         }
      

 	}
 	@Override
	public void actionPerformed(ActionEvent e) {
 		
 		if(bossshow)
 	    {
 			t.setDelay(60);
 	    	num1++;
 	    	 if(num1>=40 && num1<=45)
 				 x++;
 		    else if(num1>=45 && num1<=50)
 			 x--;			 
 		    else if(num1>=50 && num1<=55)
 			 x++;
 		    else if(num1>=55 && num1<=60)
 			 x--;
 		    else if(num1>=60  && num1<=65)
 			 x++;
 		    else 
 			 x--;
 	    }
 		if(!isstart && !isover)
 	    {
 	    delay_isstart++;

 	    if(delay_isstart>=30) 
 	    {
 	    	
 	    	   isstart=true;
 	    	   delay_isstart=0; 	   
 	    }
 	    }
 	    else 
 	    {  
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
 	 				t.setDelay(10);
 	 			    hero.shoot_light(hero.hero_index);
 	 			    hero.shoot_sway_l();
 	 			    hero.shoot_sway_r();
 	 			    shoot_num++;
 	 			}
 	 			else 
 	 			{
 	 				hero.isenough=false;
 	 				hero.crazy=false;
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
 	 				
 	 				t.setDelay(10);
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
 	 			}
 	 		}
 	      }
 	    	break;
 	    	
 	    	case 3:
 	    	{
 	    		if(!hero.isenough)
 	 	 		{
 	 	    		t.setDelay(200);
 	 	 			hero.shoot();
 	 	 		}
 	 	 		else 
 	 	 		{   
 	 	 			if(shoot_num<=80)
 	 	 			{
 	 	 				t.setDelay(10);
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
 	 	 			}
 	 	 		}
 	    	}
 	    }
 	    }
 		t.setDelay(100);
 	     if(hero.isj)
 	    	 count++;
 	     if(hero.k>=1)
 	     {
 	    	 pushk=true;
 	    	 istouch=true;	
 	     }
 	    
 	     num++;
 	     if(islevelup)
 	    	 num2--;
 	     if(isstartcount)
 	     {
 	    	 delay++;
 	     if(delay%10==0 && delay!=0)
 	    	 timecount--;
 	     }
 	     if(isstartcountj)
 	     {
 	    	 delayj++;
 	      if(delayj%10==0 && timej>0)
 	    	 timej--;
 	     }
 	     if(isstartcountk)
 	     {
 	   	 delayk++;
	      if(delayk%10==0 && timek>0)
	    	 timek--;
 	     }
 	    if(isgetnews)
 	    	delaynj++;
 	    if(isstartcount_packet)
 	    	delay_packet++;
 	}
 	
}
