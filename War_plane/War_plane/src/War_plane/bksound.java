package War_plane;
import java.applet.Applet;
import java.applet.AudioClip;;

public class bksound extends Applet{  
	AudioClip bgmusic;
	public void init(String name)
	{
		bgmusic = Applet.newAudioClip(Sound.class.getResource(name));
		
	}
	public void start()
	{  
		if(bgmusic!=null)
			bgmusic.loop();
		if(bgmusic!=null)
		{
		bgmusic.play();
		}
	}
	public void stop()
	{
		if(bgmusic!=null)
		bgmusic.stop();
	}

}