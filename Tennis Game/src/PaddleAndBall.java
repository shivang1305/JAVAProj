import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PaddleAndBall implements ActionListener
{
	JFrame f;
	Panel1 p1;
	int x,y;
	public PaddleAndBall()
	{
		x=3;
		y=5;
		f=new JFrame();
		f.setLayout(new BorderLayout());
		p1=new Panel1();
		p1.setBorder(BorderFactory.createLoweredBevelBorder());
		f.add(p1,BorderLayout.CENTER);
		f.setSize(600,600);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Handler1 h1=new Handler1();
		p1.addMouseMotionListener(h1);
		Handler2 h2=new Handler2();
		p1.addKeyListener(h2);
		Timer t=new Timer(5,this);
		t.start();
	}
	private class Handler1 extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent me)
		{
			if(me.getX()<0)
				p1.mX=0;
			else if(me.getY()<0)
				p1.mY=0;
			else if(me.getX()>f.getWidth()-60)
				p1.mX=f.getWidth()-60;
			else if(me.getY()>f.getHeight()-60)
				p1.mY=f.getHeight()-60;
			else
			{
				p1.mX=me.getX();
				p1.mY=me.getY();
			}
			p1.repaint();
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(f.getWidth()-60==p1.bX)
			x=-3;
		if(f.getHeight()-60==p1.bY)
			y=-5;
		if(p1.bX==0)
			x=3;                       
		if(p1.bY==0)
			y=5;
		if(p1.bY==p1.mY && p1.bX==p1.mX) //not working...(for reflection of ball after hitting paddle)
		{
			System.out.println("ITS WORKING");
			x=-x;
			y=-y;
		} 
		p1.bX+=x;
		p1.bY+=y;
		p1.repaint();
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
