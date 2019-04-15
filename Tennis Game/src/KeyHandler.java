import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter //(by default focus is always on frame we have to shift the focus to the panel).
	{
		public void keyPressed(KeyEvent ke)
		{
			int key=ke.getKeyCode();
			if(key==KeyEvent.VK_UP)
				PaddleAndBall.p1.barY-=20;
			else if(key==KeyEvent.VK_DOWN)
				PaddleAndBall.p1.barY+=20;
			PaddleAndBall.p1.repaint();
		}
		public void keyReleased(KeyEvent ke)
		{
			int key=ke.getKeyCode();
			if(key==KeyEvent.VK_UP)
				PaddleAndBall.p1.barY-=20;
			else if(key==KeyEvent.VK_DOWN)
				PaddleAndBall.p1.barY+=20;
			PaddleAndBall.p1.repaint();
		}
		public void keyTyped(KeyEvent ke)
		{
			int key=ke.getKeyCode();
			if(key==KeyEvent.VK_UP)
				PaddleAndBall.p1.barY-=20;
			else if(key==KeyEvent.VK_DOWN)
				PaddleAndBall.p1.barY+=20;
			PaddleAndBall.p1.repaint();
		}
	}