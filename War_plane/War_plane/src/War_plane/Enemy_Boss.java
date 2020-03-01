package War_plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Enemy_Boss implements ActionListener{
	Image boss_img,img_a;
	 public int boss_x,boss_y;
	 Vector<Buttel> e1_bullet = new Vector();
	 Vector<Buttel> e2_bullet = new Vector();
	 Vector<Buttel> e3_bullet = new Vector();
	 Vector<Buttel> e4_bullet = new Vector();
	 Vector<Buttel> e5_bullet = new Vector();
	 Vector<Buttel> e6_bullet = new Vector();
	 Vector<Buttel> e7_bullet = new Vector();
	 Vector<Buttel> e8_bullet = new Vector();
	 Vector<Buttel> e9_bullet = new Vector();
	 Vector<Buttel> e10_bullet = new Vector();
	 Vector<Buttel> e11_bullet = new Vector();
	 Vector<Buttel> e12_bullet = new Vector();
	 Rootnum root[]= new Rootnum[4];
	 public int width,weight,h_xmin,h_y,h_xmax,h_w,j1=0,j2=0,j3=0,j4=0,j5=0;
	 public int num=0;
	 public int [] blood ={500,800,1100};
	 public int size [][] ={{150,150},{160,160},{150,150}};
	public int  middle_down=0,middle_up=1,left_up=3,left_down=2,right_up=5,right_down=4;
	 Image boss_death[];
	 Timer sendtime;
	 public int index=0,typenum=4,boss_index;
	 boolean islive=true,isfinishy=false,ismovey=true,ismovex_l=false,ismovex_r=false,live=false,i=true,bulletdeath=false,isshoot=true,h_islive=true,ismovey_u=false,isa=false;
	 String bulletname;
	 Showblood show;
	public Enemy_Boss(String filename,int x,int y,int bossindex)
        {   
		    show = new Showblood(1, blood[bossindex],15,blood[bossindex],0,0);
		    show.boss_index=bossindex;
			sendtime= new Timer(450,this);
			sendtime.start();
			boss_x=x;
			boss_y=y;
			this.boss_index=bossindex;
			this.width=size[bossindex][0];
			this.weight=size[bossindex][1];
			boss_death = new Image[4]; 
	        for(int i=0;i<4;i++)
	        boss_death[i]=Toolkit.getDefaultToolkit().getImage(Enemy_Boss.class.getResource("bomb_"+ i + ".gif"));
			bulletname="boss_bullet" + (bossindex+1) + ".png";	
			boss_img=Toolkit.getDefaultToolkit().getImage(Enemy_Boss.class.getResource(filename));
			img_a = Toolkit.getDefaultToolkit().getImage(Enemy_Boss.class.getResource("eba.png"));
			for(int i=0;i<4;i++)
				root[i] = new Rootnum();
			root[0].getxy(6, 60,left_up);//环绕
			root[1].getxy(10, 10, left_down);
			root[2].getxy(20, 10, right_down);
			root[3].getxy(20, 20, middle_down);
        }
	public void draw_boss(Graphics g,JPanel L)
	{
		if(islive)
    	{
			if(i)
			{ 
				for(int i=0;i<4;i++)
					  g.drawImage(boss_death[i],boss_x,boss_y,width,weight,(ImageObserver)L);
				i=false;
			}
		
          g.drawImage(boss_img,boss_x,boss_y,width,weight,(ImageObserver)L);
      	if(isa)
			  g.drawImage(img_a,boss_x+width/5,boss_y+weight/6,(ImageObserver)L);
          show.drawblood(g,index);
    	}
	}
	public void updateposition(){
		
		if(ismovey)
		 boss_y+=3;
		 if(ismovey_u)
			boss_y-=3;
			  if(ismovex_r)
		         boss_x-=6;
			  if(ismovex_l)
				    boss_x+=6;
			
	}
	public boolean istouch(){
		for(int i=0;i<e1_bullet.size();i++){
    		if(h_islive && h_xmin >= boss_x -50 && h_xmax<=(boss_x+width+50) && h_y-boss_y >=0 && h_y-boss_y<=80 || h_islive && (e1_bullet.get(i).bullet_position_y-h_y >=0 &&
    				e1_bullet.get(i).bullet_position_y-h_y<=h_w+20 )&& e1_bullet.get(i).bullet_position_x>=h_xmin
    					&& e1_bullet.get(i).bullet_position_x<=h_xmax){
    			  e1_bullet.remove(i);	  
    			  return true;
    		}
    		else if(e1_bullet.get(i).bullet_position_x >600 ||e1_bullet.get(i).bullet_position_x<-100 || e1_bullet.get(i).bullet_position_y>750 || e1_bullet.get(i).bullet_position_y<-100 )
    			e1_bullet.remove(i);
		}
            
               for(int i=0;i<e2_bullet.size();i++){
    		if(h_islive && (e2_bullet.get(i).bullet_position_y-h_y >=0 &&
    				e2_bullet.get(i).bullet_position_y-h_y<=h_w )&& e2_bullet.get(i).bullet_position_x>=h_xmin
    					&& e2_bullet.get(i).bullet_position_x<=h_xmax){
    			  e2_bullet.remove(i);	  
    			  return true;
    		}
    		else if(e2_bullet.get(i).bullet_position_x >600 ||e2_bullet.get(i).bullet_position_x<-100 || e2_bullet.get(i).bullet_position_y>750 || e2_bullet.get(i).bullet_position_y<-100 )
    			e2_bullet.remove(i);
         	} 
               for(int i1=0;i1<e3_bullet.size();i1++){
           		if(h_islive && (e3_bullet.get(i1).bullet_position_y-h_y >=0 &&
           				e3_bullet.get(i1).bullet_position_y-h_y<=h_w )&& e3_bullet.get(i1).bullet_position_x>=h_xmin
           					&& e3_bullet.get(i1).bullet_position_x<=h_xmax){
           			  e3_bullet.remove(i1);	  
           			  return true;
           		}else if(e3_bullet.get(i1).bullet_position_x >600 ||e3_bullet.get(i1).bullet_position_x<-100 || e3_bullet.get(i1).bullet_position_y>750 || e3_bullet.get(i1).bullet_position_y<-100 )
        			e3_bullet.remove(i1);
                	}
            for(int i=0;i<e4_bullet.size();i++){
           	 for(int s=0;s<32;s++)
    		if(h_islive && (e4_bullet.get(i).b_p[s][1]-h_y >=0 &&
    				e4_bullet.get(i).b_p[s][1]-h_y<=h_w )&& e4_bullet.get(i).b_p[s][0]>=h_xmin
    					&& e4_bullet.get(i).b_p[s][0]<=h_xmax){
    			  e4_bullet.remove(i);	  
    			  return true;
    		}else if(e4_bullet.get(i).bullet_position_x >600 ||e4_bullet.get(i).bullet_position_x<-100 || e4_bullet.get(i).bullet_position_y>750 || e4_bullet.get(i).bullet_position_y<-100 )
    			e4_bullet.remove(i);
         	}
             for(int i=0;i<e5_bullet.size();i++){
            	 for(int s=0;s<32;s++)
    		if(h_islive && (e5_bullet.get(i).b_p[s][1]-h_y >=0 &&
    				e5_bullet.get(i).b_p[s][1]-h_y<=h_w )&& e5_bullet.get(i).b_p[s][0]>=h_xmin
    					&& e5_bullet.get(i).b_p[s][0]<=h_xmax){
    			  e5_bullet.remove(i);	  
    			  return true;
    		}else if(e5_bullet.get(i).bullet_position_x >600 ||e5_bullet.get(i).bullet_position_x<-100 || e5_bullet.get(i).bullet_position_y>750 || e5_bullet.get(i).bullet_position_y<-100 )
    			e5_bullet.remove(i);
         	}
             
            for(int i=0;i<e6_bullet.size();i++){
    		if(h_islive && (e6_bullet.get(i).bullet_position_y-h_y >=0 &&
    				e6_bullet.get(i).bullet_position_y-h_y<=h_w )&& e6_bullet.get(i).bullet_position_x>=h_xmin
    					&& e6_bullet.get(i).bullet_position_x<=h_xmax){
    			  e6_bullet.remove(i);	  
    			  return true;
    		}
    		else if(e6_bullet.get(i).bullet_position_x >600 ||e6_bullet.get(i).bullet_position_x<-100 || e6_bullet.get(i).bullet_position_y>750 || e6_bullet.get(i).bullet_position_y<-100 )
    			e6_bullet.remove(i);
         	}
            for(int i=0;i<e7_bullet.size();i++){
    		if(h_islive && (e7_bullet.get(i).bullet_position_y-h_y >=0 &&
    				e7_bullet.get(i).bullet_position_y-h_y<=h_w )&& e7_bullet.get(i).bullet_position_x>=h_xmin
    					&& e7_bullet.get(i).bullet_position_x<=h_xmax){
    			  e7_bullet.remove(i);	  
    			  return true;
    		}else if(e7_bullet.get(i).bullet_position_x >600 ||e7_bullet.get(i).bullet_position_x<-100 || e7_bullet.get(i).bullet_position_y>750 || e7_bullet.get(i).bullet_position_y<-100 )
    			e7_bullet.remove(i);
         	}
             for(int i=0;i<e8_bullet.size();i++){
    		if(h_islive && (e8_bullet.get(i).bullet_position_y-h_y >=0 &&
    				e8_bullet.get(i).bullet_position_y-h_y<=h_w )&& e8_bullet.get(i).bullet_position_x>=h_xmin
    					&& e8_bullet.get(i).bullet_position_x<=h_xmax){
    			  e8_bullet.remove(i);	  
    			  return true;
    		}else if(e8_bullet.get(i).bullet_position_x >600 ||e8_bullet.get(i).bullet_position_x<-100 || e8_bullet.get(i).bullet_position_y>750 || e8_bullet.get(i).bullet_position_y<-100 )
    			e8_bullet.remove(i);
         	}
          for(int i=0;i<e9_bullet.size();i++){
    		if(h_islive && (e9_bullet.get(i).bullet_position_y-h_y >=0 &&
    				e9_bullet.get(i).bullet_position_y-h_y<=h_w )&& e9_bullet.get(i).bullet_position_x>=h_xmin
    					&& e9_bullet.get(i).bullet_position_x<=h_xmax){
    			  e9_bullet.remove(i);	  
    			  return true;
    		}else if(e9_bullet.get(i).bullet_position_x >600 ||e9_bullet.get(i).bullet_position_x<-100 || e9_bullet.get(i).bullet_position_y>750 || e9_bullet.get(i).bullet_position_y<-100 )
    			e9_bullet.remove(i);
          }
    		  for(int i1=0;i1<e10_bullet.size();i1++){
             		if(h_islive && (e10_bullet.get(i1).bullet_position_y-h_y >=0 &&
             				e10_bullet.get(i1).bullet_position_y-h_y<=h_w )&& e10_bullet.get(i1).bullet_position_x>=h_xmin
             					&& e10_bullet.get(i1).bullet_position_x<=h_xmax){
             			  e10_bullet.remove(i1);	  
             			  return true;
             		}else if(e10_bullet.get(i1).bullet_position_x >600 ||e10_bullet.get(i1).bullet_position_x<-100 || e10_bullet.get(i1).bullet_position_y>750 || e10_bullet.get(i1).bullet_position_y<-100 )
            			e10_bullet.remove(i1);
                  	}
    		  for(int i1=0;i1<e11_bullet.size();i1++){
             		if(h_islive && (e11_bullet.get(i1).bullet_position_y-h_y >=0 &&
             				e11_bullet.get(i1).bullet_position_y-h_y<=h_w )&& e11_bullet.get(i1).bullet_position_x>=h_xmin
             					&& e11_bullet.get(i1).bullet_position_x<=h_xmax){
             			  e11_bullet.remove(i1);	  
             			  return true;
             		}else if(e11_bullet.get(i1).bullet_position_x >600 ||e11_bullet.get(i1).bullet_position_x<-100 || e11_bullet.get(i1).bullet_position_y>750 || e1_bullet.get(i1).bullet_position_y<-100 )
            			e11_bullet.remove(i1);
    		  }
    		  for(int i1=0;i1<e12_bullet.size();i1++){
    			  for(int s=0;s<32;s++)
           		if(h_islive && (e12_bullet.get(i1).b_p[s][1]-h_y >=0 &&
           				e12_bullet.get(i1).b_p[s][1]-h_y<=h_w )&& e12_bullet.get(i1).b_p[s][0]>=h_xmin
           					&& e12_bullet.get(i1).b_p[s][0]<=h_xmax){
           			  e12_bullet.remove(i1);	  
           			  return true;
           		}
           	//	else if(e12_bullet.get(i1).bullet_position_x >600 ||e12_bullet.get(i1).bullet_position_x<-100 || e12_bullet.get(i1).bullet_position_y>750 || e12_bullet.get(i1).bullet_position_y<-100 )
        			//e12_bullet.remove(i1);
    			  
  		  }
    	    return false;
	}
	 public void shoot(int index){//单发,基本动作
	    	if(islive){	
	             Buttel bullet = new Buttel("zd" +index + ".png",10,0);
	             bullet.Updateposition(boss_x + 40, boss_y + weight-50,0,0);
	             e1_bullet.add(bullet);
	    		}
	    }
	 public void shootl(int index)//左边单发
	 {  
		 if(islive){	
			
             Buttel bullet = new Buttel("zd" +index + ".png",10,0);
             bullet.Updateposition(boss_x + width/3, boss_y + weight-50,0,0);
             e2_bullet.add(bullet);
		}  
	 }
	 public void shootr(int index)//右边单发
	 {  
		 if(islive){	
             Buttel bullet = new Buttel("zd" +index+ ".png",10,0);
             bullet.Updateposition(boss_x + width-10, boss_y + weight-50,0,0);
             e3_bullet.add(bullet);
		}  
	 }
	 public void shootl_spread(int index){//四面八方,左边
	    	if(islive){	
	             Buttel bullet = new Buttel("zd" +index + ".png",10,1);
	             bullet.update_boss(boss_x + width/4, boss_y + weight-50);
	             e4_bullet.add(bullet);
	    		}
	    }
	 public void shootr_spread(int index){//四面八方,右边
	    	if(islive){	
	             Buttel bullet = new Buttel("zd" +index + ".png",10,1);
	             bullet.update_boss(boss_x + width*3/4, boss_y + weight-50);
	             e5_bullet.add(bullet);
	    		}
	    }
	 public void shoot_spread(int index){//四面八方,中间
	    	if(islive){	
	             Buttel bullet = new Buttel("zd" +index + ".png",10,1);
	             bullet.update_boss(boss_x+width/2, boss_y+weight/2);
	             e12_bullet.add(bullet);
	    		}
	    }
	 public void shootl_round(int index)//环绕发射,左边
	 {  
		 int  x,y;
		 if(islive){	
			 if(j1<root[0].dirc_bxy.length-1)
				 j1++;
			 else 
				 j1=0;
			 x=root[0].dirc_bxy[j1][0];
	           y=root[0].dirc_bxy[j1][1];
             Buttel bullet = new Buttel("zd" +index + ".png",10,1);
             bullet.Updateposition(boss_x + width/4, boss_y + weight-50,x,y);
             e6_bullet.add(bullet);
    		}
	 }
	 public void shootr_round(int index)//环绕发射,右边
	 {
		 int  x,y;
		 if(islive){	
			 if(j2<root[0].dirc_bxy.length-1)
				 j2++;
			 else 
				 j2=0;
			 x=root[0].dirc_bxy[j2][0];
	           y=root[0].dirc_bxy[j2][1];
             Buttel bullet = new Buttel("zd" +index + ".png",10,1);
             bullet.Updateposition(boss_x +width*3/4, boss_y + weight-50,x,y);
             e7_bullet.add(bullet);
    		}
	 }
	 public void shoot_sway(int index)//摆动发射
	 {  
		 int x,y,z=3;
		 if(islive){	
			
			 
		    	 if(!isfinishy)
		    	 {
		    		 j5++;
		    		
		    	 }
		    	 if(j5==root[z].dirc_bxy.length-1)
		    		 isfinishy=true;
		    	 if(isfinishy)
		    		 j5--;
		    	 if(j5==0)
		    		 isfinishy=false;
 
			 x=root[z].dirc_bxy[j5][0];
	           y=root[z].dirc_bxy[j5][1];
             Buttel bullet = new Buttel("zd" +index + ".png",10,0);
             bullet.Updateposition(boss_x +width/2, boss_y + weight-50,x,y);
             e7_bullet.add(bullet);
    		}
	 }
	 public void shoot_spread_l(int index)//向左发散
	 {  
		 int x,y;	
			 if(islive){	
				 if(j3<root[2].dirc_bxy.length-1)
					 j3++;
				 else 
					 j3=0;
				   x=root[2].dirc_bxy[j3][0];
		           y=root[2].dirc_bxy[j3][1];
             Buttel bullet = new Buttel("zd" +index + ".png",10,1);
             bullet.Updateposition(boss_x + width/4-50, boss_y + weight/4,x,y);
             e9_bullet.add(bullet);
    		}
	 }
	 public void shoot_spread_r(int index)//向右发散
	 {
		 int x,y;	
		 if(islive){	
			 if(j4<root[1].dirc_bxy.length-1)
				 j4++;
			 else 
				 j4=0;
			   x=root[1].dirc_bxy[j4][0];
	           y=root[1].dirc_bxy[j4][1];
         Buttel bullet = new Buttel("zd" +index + ".png",10,1);
         bullet.Updateposition(boss_x + width*3/4+50, boss_y + weight/4,x,y);
         e10_bullet.add(bullet);
		}
	 }
	 public void shoot_light(int index)//激光发射
	 {
		 if(islive){	
             Buttel bullet = new Buttel("zd" +index + ".png",10,0);
             bullet.Updateposition(boss_x + 40, boss_y - weight/2,0,0);
             e11_bullet.add(bullet);
    		}
	 }
    public void heroposition(int x,int y,int z,int a,boolean islive){
    	h_xmin=x;
    	h_y=y;
    	h_w=a;
    	h_xmax=x+z;
    	h_islive=islive;
    }
    public void death(Graphics g,JPanel L)
    {     
    	if(islive)
    {
    	if(show.blood<=0){    
        islive=false;
        for(int i=0;i<4;i++)
        g.drawImage(boss_death[i],boss_x,boss_y,width,weight,(ImageObserver)L);
        num=0;
        live=true;
    	}
    	if(boss_y>=-10)
    	show.updateblood();
    }
    	
    }
	 @Override
	public void actionPerformed(ActionEvent e){
		 if(boss_y>=0)
		 {
			 switch(boss_index)
			 {			 
			 case 0:
				 { 
					    sendtime.setDelay(100);					    
					    num++;
					    ismovey=false;
					    if(num<=30 )
					    {	
					    	  sendtime.setDelay(5);
					    	  shootr_round(5);
					    	  isa=true;
					    } else if(num>=30 && num<=60)
					    	{ 
					    	 isa=false;;
					    	}
					    else if(num>=60 && num<=90)
					    {
                           sendtime.setDelay(5);
					    	shootl_round(5);
					    	 isa=true;
					    }
					    else if(num>=90 && num<=130)
					    {
					    	 isa=false; ;
					    }
					    else  if(num>=130 && num<150)
					    {  
					       ismovex_l=true;
					       ismovex_r=false;
					       shoot(7);
					       if(num==130)
					    	   shoot_spread(2);
					       if(num==140)
					    	   shoot_spread(2);
					       isa=true;
					    }
					    else  if(num>=150 && num<170)
					    {
					    	  ismovex_r=true;
						       ismovex_l=false;
						       shoot(7);
						       if(num==160)
						    	   shoot_spread(2);
						       isa=true;
					    }
					    else if(num>=170 && num<200)
					    { 	ismovex_r=false;
					       ismovex_l=false;; isa=false;
					    }
					    else if(num>=200&& num<201)
					    {
					    	shoot_spread(5); isa=true;
					    }
					    else 
					    {
					    	  num=0;
					    	  isa=false;
					    }   
					    
			    }
			   break;
			 case 1:
			 {  
				 ismovey=false;
				 num++;
				 sendtime.setDelay(100);
				  if(num<30 )
				    {	
				    	  sendtime.setDelay(20);
				    	  shootr_round(5);
				    	  if(num==20)
				    		  shoot_spread(8);
				    	  isa=true;
				    } else if(num>=30 && num<=60)
				    	{ 
				    	 isa=false;;
				    	}
				    else if(num>=60 && num<=90)
				    {
                     sendtime.setDelay(30);
				    	shootl_round(5);
				    	 isa=true;
				    }
				    else if(num>=90 && num<=130)
				    {
				    	 isa=false;;
				    }
				    else  if(num>=130 && num<150)
				    {  
				       ismovex_l=true;
				       ismovex_r=false;
				       shootl(7);
				       shootr(7);
				       if(num==140)
				    	   shoot_spread(5);
				       if(num==131)
				    	   shoot_spread(2);
				       isa=true;
				    }
				    else  if(num>=150 && num<170)
				    {
				    	  ismovex_r=true;
					       ismovex_l=false;
					       shootl(7);
					       shootr(7);
					       if(num==160)
					       shoot_spread(2);
					       isa=true;
				    }
				    else if(num>=170 && num<200)
				    { 	ismovex_r=false;
				         ismovex_l=false;;
				         isa=false;
				    }
				    else if(num>=200&& num<250)
				    {
				    	shootl_round(2);
				    	if(num==220)
				    		shoot_spread(5);
				    	 isa=true;
				    }
				    else if(num>=250 && num<270)
				    	 isa=false;
				    else if(num>=270 && num<360)
				    {
				    	shoot_sway(7);
				    	
				    	 isa=true;}
				    else 
				    	{
				    	num=0;
				    	 isa=false;
				    	}
			 }
			 break;
			 case 2:
			 {  
				 ismovey=false;
				 sendtime.setDelay(100);
				
				 if(num<30 )
				    {	
				    	  sendtime.setDelay(20);
				    	  shootr_round(8);
				    	  isa=true;
				    } else if(num>=30 && num<=60)
				    	{ 
				    	 isa=false;  ;
				    	}
				    else if(num>=60 && num<=90)
				    {
                       sendtime.setDelay(30);
				    	shootl_round(8);
				    	 isa=true;
				    }
				    else if(num>=90 && num<=130)
				    {
				    	 isa=false;;
				    }
				    else  if(num>=130 && num<150)
				    {  
				       ismovex_l=true;
				       ismovex_r=false;
				       shootl(7);
				       shootr(7);
				       isa=true;
				    }
				    else  if(num>=150 && num<170)
				    {
				    	  ismovex_r=true;
					       ismovex_l=false;
					       shootl(7);
					       shootr(7);
					       isa=true;
				    }
				    else if(num>=170 && num<200)
				    { 	ismovex_r=false;
				         ismovex_l=false;;
				         isa=false;
				    }
				    else if(num>=200&& num<250)
				    {
				    	shootl_round(2);
				    	 isa=true;
				    }
				    else if(num>=250 && num<270)
				    	 isa=false;
				    else if(num>=270 && num<320)
				    {
				    	shoot_sway(7);
				    	 isa=true;
				    }
				    else 
				    	if(num>=320 && num<340)
				    	{
				    		  if(num>=330 && num<331)
				    			  shoot_spread(2);
				    		  if(num>=339 && num<340)
				    		     shoot_spread(2);
				    		  ismovex_l=true;
				    		  ismovex_r=false;
				    		  shoot(7);
				    		  isa=true;
				    		  
				    	}
				    	else if(num>=340 && num<360)
				    	{
				    		 if(num>=330 && num<332)
				    			  shoot_spread(8);
				    		  if(num>=339 && num<340)
				    		     shoot_spread(8);
				    		  ismovex_l=false;
				    		  ismovex_r=true;
				    		  shoot(7);
				    		  isa=true;
				    		  
				    	}
				    	else if(num>=360 && num<361)
				    	{
				    		ismovey_u=true; 
				    		ismovex_r=false;
				    		 isa=false;
				    	}
				    	else if(num>=361 && num<369)
				    		{
				    		ismovey_u=false;
				    		
				    		}
				    	else 
				    		  if(num>=369 && num<370)
				    			  ismovey=true;
				    		  else 
				    		{    	
				    			  
				    		ismovex_r=false;
				    		ismovey=false;
				    		ismovey_u=false;
				    		num=0;
				    		}
				 num++;
			 }
      }
	 }
	 }
}
 
