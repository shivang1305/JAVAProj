import javax.swing.*;
import java.awt.*;


public class Panel1 extends JPanel
{
	int ballX=0;
	int ballY=0;
	int barY=300;
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g1=(Graphics2D)g;
		g1.fillOval(ballX, ballY, 20, 20);
		g1.fillRect(10, barY, 20, 60);
		g1.fillRect(550, barY, 20, 60);
	}
}
