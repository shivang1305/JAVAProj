import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseHandler extends MouseMotionAdapter 
{
	public void mouseDragged(MouseEvent me) // movement of paddle
	{
		if (me.getY() < 0)
			PaddleAndBall.p1.barY = 0;
		else if (me.getY() > PaddleAndBall.f.getHeight() - 60)
			PaddleAndBall.p1.barY = PaddleAndBall.f.getHeight() - 60;
		else
			PaddleAndBall.p1.barY = me.getY();
		PaddleAndBall.p1.repaint();
	}
}
