package War_plane;
public class Rootnum {
     int root[][]={{-100,500},{600,500},{-100,100},{600,100},{-100,200},{600,200},{20,-300},{200,-250},{380,-300}};
     public int dirc_bxy[][];
     public int getroot(int i,int j){ 
    	 return root[i][j];
     }
     public  void getxy(int x,int value,int shoot_way)
     {  
    	 int x1,y1,X,Y;
    	 dirc_bxy = new int[value][2]; 
         int Matrix_shoot[][]={{-x/2,-x/2},{x/2,x/2},{-x,0},{0,x},{0,-x},{x,0}};
          X=Matrix_shoot[shoot_way][0];
          Y=Matrix_shoot[shoot_way][1];
    	  x1=X;
    	  y1=Y;
    	  for(int i=0;i<value;i++)
    	  {
    		   dirc_bxy[i][0]=x1;
    		   dirc_bxy[i][1]=y1;
    		   if(X>0 &&(Y==0 || Y>0) )
    		   {
    			   x1--;
    			   y1++;
    		   }
    		   else if(X<0 && (Y==0 || Y<0) )
    		   {
    			   x1++;
    			   y1--;
    		   }
    		   else if(Y>0 && X==0 )
    		   {
    			   x1--;
    			   y1--;
    		   }
    		   else if(Y<0 && X==0 )
    		   {
    			   x1++;
    			   y1++;
    		   }
    		   if(x1==0 || y1==0)
    		   {
    			   X=x1;
    			   Y=y1;
    		   }
    	  }
     }
}
