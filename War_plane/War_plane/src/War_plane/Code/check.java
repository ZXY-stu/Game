package War_plane;

public class check implements Runnable{
	  public  static  boolean ispass=true;
        public boolean check_date()
        {
        
        	return  ispass;
        }

		@Override
		public void run() {
			  while(true)
			  {  
				  check_date();
				  System.out.print(ispass);
				  try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			  }
		}
}
