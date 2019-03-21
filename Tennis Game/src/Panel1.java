import javax.swing.*;
import java.awt.*;


public class Panel1 extends JPanel
{
	int bX=0;
	int bY=0;
	int mX=300;
	int mY=300;
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g1=(Graphics2D)g;
		g1.fillOval(bX, bY, 20, 20);
		g1.fillRect(mX, mY, 20, 60);
	}
}
