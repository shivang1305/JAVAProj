import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PaddleMovement 
{
	JFrame f;
	Panel1 p1;
	public PaddleMovement()
	{
		f=new JFrame();
		f.setLayout(new BorderLayout());
		p1=new Panel1();
		p1.setBorder(BorderFactory.createLoweredBevelBorder());
		f.add(p1,BorderLayout.CENTER);
		f.setSize(600,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Handler1 h1=new Handler1();
		p1.addMouseMotionListener(h1);
		Handler2 h2=new Handler2();
		p1.addKeyListener(h2);
	}
	private class Handler1 extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent me)
		{
			if(me.getX()<0)
				p1.mX=0;
			else if(me.getY()<0)
				p1.mY=0;
			else if(me.getX()>f.getWidth())
				p1.mX=f.getWidth();
			else if(me.getY()>f.getHeight())
				p1.mY=f.getHeight();
			else
			{
				p1.mX=me.getX();
				p1.mY=me.getY();
			}
			p1.repaint();
		}
	}
	private class Handler2 extends KeyAdapter //not working.
	{
		public void keyPressed(KeyEvent ke)
		{
			System.out.println("ITS WORKING");
			int key=ke.getKeyCode();
			if(key==KeyEvent.VK_UP)
				p1.mY-=20;
			else if(key==KeyEvent.VK_DOWN)
				p1.mY+=20;
			else if(key==KeyEvent.VK_LEFT)
				p1.mX-=10;
			else if(key==KeyEvent.VK_RIGHT)
				p1.mX+=10;
			p1.repaint();
		}
		public void keyReleased(KeyEvent ke)
		{
			System.out.println("ITS WORKING");
			int key=ke.getKeyCode();
			if(key==KeyEvent.VK_UP)
				p1.mY-=20;
			else if(key==KeyEvent.VK_DOWN)
				p1.mY+=20;
			else if(key==KeyEvent.VK_LEFT)
				p1.mX-=10;
			else if(key==KeyEvent.VK_RIGHT)
				p1.mX+=10;
			p1.repaint();
		}
		public void keyTyped(KeyEvent ke)
		{
			System.out.println("ITS WORKING");
			int key=ke.getKeyCode();
			if(key==KeyEvent.VK_UP)
				p1.mY-=20;
			else if(key==KeyEvent.VK_DOWN)
				p1.mY+=20;
			else if(key==KeyEvent.VK_LEFT)
				p1.mX-=10;
			else if(key==KeyEvent.VK_RIGHT)
				p1.mX+=10;
			p1.repaint();
		}
	}
}




/* why not original size of frame comes after we run the application?
   why does it lag as it touches the edges?
   why is key events not running?*/ 
