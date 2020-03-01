package War_plane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game_menu extends JFrame implements Runnable,KeyListener{
	
	
	
	
	
	
        public static	 Game_Point c;
        public static Game_Choose_plane b;
		public Boolean plane_choose_ok=false,page2= false,page3= false,page2to3_1=true,gq_choose_ok=false,page1=false;
	
		public	Cursor cursor1= Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(Game_menu.class.getResource("m1.png")).getImage(),new Point(10,20), "stick");
		public	Cursor cursor2= Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(Game_menu.class.getResource("m2.png")).getImage(),new Point(10,20), "stick");
		   jdt d;
	
	
	
	
	
	
	
	   public boolean isstart=false,isfinishy=false,running=true,l=true;
       public int width,weight,x=0,y=0,x1=0,count=0;
       JLabel label = new JLabel("按任意键开始游戏");
       JLabel bk  = new JLabel(new ImageIcon(getClass().getResource("start.jpg")));
       JPanel jl = new JPanel();
      
       bksound sound;
       Game_control control;
    public   static Game_draw a;
	   public Game_menu(int width,int weight){    
			 a = new Game_draw(width,weight,17); 
			 b = new Game_Choose_plane();
			 c = new Game_Point();
			 d= new jdt();
		     control = new Game_control();
		    sound = new bksound();
		    sound.init("menu.au");
		    sound.start();
		     jl.setLayout(null);
		     jl.setSize(width, weight);
			 setBounds(200,-20,500, 600);
		     setSize(width,weight);
		     setVisible(true);
		     setResizable(false);
		     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     this.width=width;
		     this.weight=weight;
		     label.setSize(width, 200);
		     bk.setSize(width,weight);
		     label.setFont(new Font("隶书",Font.BOLD,30));
		     label.setForeground(Color.GREEN);
		     jl.add(label);
             jl.add(bk); 
             add(d);
             Thread t = new Thread(d);
             t.start();
		   }
	     public void Draw_menu(){ 	
	    	 label.setLocation(122, 540+x);
	    	if(!isfinishy)
	    	   x--;
	    	 if(x==-10)
	    		 isfinishy=true;
	    	 if(isfinishy)
	    		 x++;
	    	 if(x==0)
	    		 isfinishy=false;	 
	     }
	     public void startpage3(){
	    	 b.setVisible(false);	 
			   getContentPane().add(c);
	    		 c.getFocusListeners();
	    		 c.setCursor(cursor2);
	    	Thread	thread3 = new Thread(c);
		         thread3.start();
	     }
	     public void startpage2(){
	    	 sound.stop();
	    		 jl.setVisible(false);
	    		 getContentPane().add(b);
	    		 b.getFocusListeners();
	    		 b.setCursor(cursor1);
	    	Thread	 thread2 = new Thread(b);
				 thread2.start();
	     }

	     public void startpage4(){
	    	     sound.stop();
	    	     c.setVisible(false); 
			     a.setVisible(true);	    	
	    		 a.setCursor(cursor2);
	    		 getContentPane().add(a);
	    	Thread	 thread4 = new Thread(a);
	    		 thread4.start();
	    		 
	     }
	     public void backpage1(){
	    	 sound.start();
    		 jl.setVisible(true);
    		 b.setVisible(false);
	     }
	     
	     public void startpage1to2(){
	    	 sound.stop();
    		 jl.setVisible(false);
    		 b.setVisible(true);
	     }
	     public void backpage2(){
    		 b.setVisible(true);
    		 c.setVisible(false);
	     }
	     public void startpage2to3(){
    		 b.setVisible(false);
    		 c.setVisible(true);
	     }
	     public void startpage1(){
	    	 d.setVisible(false);
	    	 getContentPane().add(jl);
	     }
		@Override
		public void run(){
			
			while(true)
			{ 
				if(jdt.c)
				{   this.addKeyListener(this);
	                this.addKeyListener(control);
					startpage1();
				}
               
				//1to2
				if(running==false&& !page2 && b.back==false){
					startpage2();
					page2=true;
				}
				//2to3
				if(page2 && b.next &&page2to3_1){
					startpage3();
					page2=false;
					page3=true;
					page2to3_1=false;
					b.next=false;
				}
				//3to4
				if(c.next && page3){
					startpage4();
					c.next=false;
					a.t.start();
					
				}
				
				
				//第2页退回第1页
				if(b.back && page2){
					backpage1();
					running=true;
					page2=false;
					page1=true;
					b.back=false;
				}
				//第1页到第2页
				if(page1 && running==false){
					startpage1to2();
					page1=false;
					page2=true;
				}
				//第3页退回第2页
				if(c.back&& page3){
					backpage2();
					page2=true;
					page3=false;
					c.back=false;
				}
				if(b.next && page2){
					startpage2to3();
					page2=false;
					page3=true;
					b.next=false;
				}
				Draw_menu();
			
				if(a.pass)
				{count++;
				  
				}
				
				if(count==40 || a.control.isover && a.pass)
				{   count=0;
					b.setVisible(true);
					a.setVisible(false);
					a.pass=false;
					a = new Game_draw(width,weight,17); 
				}
			
			try {
				Thread.sleep(100);	
			} catch (InterruptedException e){
				e.getStackTrace();
			}
			}	
			
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			  running = false;
			
		}
		@Override
		public void keyPressed(KeyEvent e) {
			  
		}
		@Override
		public void keyReleased(KeyEvent e) {
		}
}
