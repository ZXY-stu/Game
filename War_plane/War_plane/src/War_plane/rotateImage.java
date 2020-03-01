package War_plane;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class rotateImage {
	public static BufferedImage rotatelmage( final BufferedImage bufferedImage, int degree,int x,int y)
    {
		int w =bufferedImage.getWidth();
		int h =bufferedImage.getHeight();
		int type = bufferedImage.getColorModel().getTransparency();
		BufferedImage img = null;
		Graphics2D g2 = null;
		(g2=(img=new BufferedImage(w, h, type)).createGraphics()).setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.rotate(Math.toRadians(degree), w/2, h/2);
		g2.drawImage(bufferedImage, null, 0,0);
		g2.dispose();
    	return img;
    }
}
