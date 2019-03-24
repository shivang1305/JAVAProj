import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PaddleAndBall implements ActionListener
{
	JFrame f;
	Panel1 p1;
	int x,y,a,b;
	public PaddleAndBall()
	{
		x=(int)(Math.random()*10);
		y=(int)(Math.random()*10);
		a=x;
		b=y;
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
		p1.requestFocusInWindow();//to shift focus from frame to panel
		Timer t=new Timer(10,this);
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
			x=-x;
		if(f.getHeight()-60==p1.bY)
			y=-y;
		if(p1.bX==0)
			x=a;                       
		if(p1.bY==0)
			y=b;
		if((p1.bY>=p1.mY && p1.bY<=p1.mY+60) && (p1.bX>=p1.mX && p1.bX<=p1.mX+20)) //(for reflection of ball after hitting paddle)
		{
			x=-x;
			y=-y;
		} 
		p1.bX+=x;
		p1.bY+=y;
		p1.repaint();
	}
	private class Handler2 extends KeyAdapter //focus problem (by default focus is always on frame we have to shift the focus to the panel).
	{
		public void keyPressed(KeyEvent ke)
		{
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
