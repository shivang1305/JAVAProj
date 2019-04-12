import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PaddleAndBall implements ActionListener
{
	JFrame f;
	JLabel scorelabel,timelabel;
	Panel1 p1;
	Font ft_score,ft_time;
	Color color_score,color_time;
	int x,y,a,b,preY,score=0,speed=20;
	public PaddleAndBall()
	{
		x=5;
		y=3;
		
		a=x;
		b=y;
		
		f=new JFrame();
		f.setLayout(new BorderLayout());
		
		color_score=new Color(244,0,0);
		color_time=new Color(0,0,244);
		
		ft_score=new Font("Algerian",1,18);
		ft_time=new Font("ELEPHANT",2,14);
		
		scorelabel=new JLabel("SCORE: 0");
		scorelabel.setFont(ft_score);
		scorelabel.setForeground(color_score);
		scorelabel.setBounds(250,5,50,50);
		
		timelabel=new JLabel("TIME 00:00");
		timelabel.setFont(ft_time);
		timelabel.setForeground(color_time);
		timelabel.setBounds(250,500,50,50);
		
		p1=new Panel1();
		p1.setBorder(BorderFactory.createLoweredBevelBorder());
		p1.add(scorelabel,BorderLayout.NORTH);
		p1.add(timelabel,BorderLayout.SOUTH);
		
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
		
		Timer t=new Timer(speed,this);
		t.start();
	}
	private class Handler1 extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent me) //movement of paddle
		{
			if(me.getY()<0)
				p1.mY=0;
			else if(me.getY()>f.getHeight()-60)
				p1.mY=f.getHeight()-60;
			else
				p1.mY=me.getY();
			p1.repaint();
		}
	}
	public void actionPerformed(ActionEvent ae) //reflection of ball
	{
		
		if(f.getWidth()<p1.bX || p1.bX==-20)
		{   //can change the font of str by using html.
			String str="GAME OVER \nYOUR SCORE IS: "+score;
			JOptionPane.showMessageDialog(p1, str);
			int input=JOptionPane.showConfirmDialog(p1, "DO YOU WANT TO PLAY AGAIN ?");
			if(input==0)
			{
				score=0;
				scorelabel.setText("SCORE: "+score);
				x=5;
				y=3;
				p1.mY=300;
				p1.bX=0;
				p1.bY=0;
				p1.repaint();
			}
			else
				System.exit(0);
		}
		if(f.getHeight()-60==p1.bY)
			y=-y;
		if(p1.bY==0)
			y=b;
		if((p1.bY>=p1.mY && p1.bY<=p1.mY+60) && (p1.bX==30 || p1.bX==550))//(for reflection of ball after hitting paddle)
		{
			x=-x;
			score++;
			scorelabel.setText("SCORE: "+score);
		}
		p1.bX+=x;
		p1.bY+=y;
		p1.repaint();
	}
	private class Handler2 extends KeyAdapter //(by default focus is always on frame we have to shift the focus to the panel).
	{
		public void keyPressed(KeyEvent ke)
		{
			int key=ke.getKeyCode();
			if(key==KeyEvent.VK_UP)
				p1.mY-=20;
			else if(key==KeyEvent.VK_DOWN)
				p1.mY+=20;
			p1.repaint();
		}
		public void keyReleased(KeyEvent ke)
		{
			int key=ke.getKeyCode();
			if(key==KeyEvent.VK_UP)
				p1.mY-=20;
			else if(key==KeyEvent.VK_DOWN)
				p1.mY+=20;
			p1.repaint();
		}
		public void keyTyped(KeyEvent ke)
		{
			int key=ke.getKeyCode();
			if(key==KeyEvent.VK_UP)
				p1.mY-=20;
			else if(key==KeyEvent.VK_DOWN)
				p1.mY+=20;
			p1.repaint();
		}
	}
}
