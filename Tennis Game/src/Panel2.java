import java.awt.*;
import javax.swing.*;


public class Panel2 extends JPanel 
{
	int bX=0;
	int bY=0;
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g1=(Graphics2D)g;
		g.fillOval(bX, bY, 20, 20);
	}
}
