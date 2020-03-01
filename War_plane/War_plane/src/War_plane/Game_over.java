package War_plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
public class Game_over {
	public boolean isagain=false;
	public void draw_over(Graphics g)
	{
		 g.setFont(new Font("ËÎÌו",Font.ITALIC,50));
		 g.setColor(Color.red);
		   g.drawString("Game Over !",140, 350);
		
	}

}
