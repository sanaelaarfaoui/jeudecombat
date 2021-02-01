import java.awt.*;
import javax.swing.*;

public class Photo1 extends Canvas {
	Image kenju;
	public Photo1()
	{
		kenju= Toolkit.getDefaultToolkit().getImage("C:\\images\\kenju.jpg");
		
	}

	public void paint (Graphics g)

	{ 
		Graphics2D g2= (Graphics2D)g;
		g2.drawImage(kenju,0,0,600,600,this);

}


		
}


