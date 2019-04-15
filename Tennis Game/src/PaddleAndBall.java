import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PaddleAndBall implements ActionListener
{
	static JFrame f;
	static JLabel scorelabel,timelabel;
	static Panel1 p1;
	Font ft_score,ft_time;
	int x,y,a,b,score=0;
	static int speed=15;
	String time;
	TimerThread timerthread;
	public PaddleAndBall()
	{	
		x=5;
		y=3;
		
		a=x;
		b=y;
		
		f=new JFrame();
		f.setLayout(new BorderLayout());
	
		ft_score=new Font("Algerian",1,18);
		ft_time=new Font("ELEPHANT",0,14);
		
		scorelabel=new JLabel("SCORE: 0");
		scorelabel.setFont(ft_score);
		scorelabel.setForeground(Color.RED);
		scorelabel.setBounds(250,0,100,25);
		
		timelabel=new JLabel("TIME ");
		timelabel.setFont(ft_time);
		timelabel.setForeground(Color.BLUE);
		timelabel.setBounds(250,520,100,50);
		
		p1=new Panel1();
		p1.setLayout(null);
		p1.setBorder(BorderFactory.createLoweredBevelBorder());
		p1.add(scorelabel);
		p1.add(timelabel);
		
		f.add(p1);
		f.setSize(600,600);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MouseHandler mousehandler=new MouseHandler();
		p1.addMouseMotionListener(mousehandler);
		
		KeyHandler keyhandler=new KeyHandler();
		p1.addKeyListener(keyhandler);
		p1.requestFocusInWindow();//to shift focus from frame to panel
		
		timerthread=new TimerThread();
		timerthread.start();
		
		Timer t=new Timer(speed,this);
		t.start();
	}
	public void actionPerformed(ActionEvent ae) //reflection of ball
	{
		
		if(f.getWidth()<p1.ballX || p1.ballX==-20)
		{  
			timerthread.suspend();
			//can change the font of str by using html.
			String str="      GAME OVER \nYOUR SCORE IS: "+score;
			JOptionPane.showMessageDialog(p1, str);
			int input=JOptionPane.showConfirmDialog(p1, "DO YOU WANT TO PLAY AGAIN ?");
			if(input==0)
			{
				timelabel.setText("TIME 0:0");
				timerthread.sec=0;
				timerthread.min=0;
				timerthread.resume();
		        score=0;
				scorelabel.setText("SCORE: "+score);
				x=5;
				y=3;
				p1.barY=300;
				p1.ballX=0;
				p1.ballY=0;
				p1.repaint();
			}
			else
				System.exit(0);
		}
		if(f.getHeight()-60==p1.ballY)
			y=-y;
		if(p1.ballY==0)
			y=b;
		if((p1.ballY>=p1.barY && p1.ballY<=p1.barY+60) && (p1.ballX==30 || p1.ballX==550))//(for reflection of ball after hitting paddle)
		{
			x=-x;
			score++;
			scorelabel.setText("SCORE: "+score);
		}
		p1.ballX+=x;
		p1.ballY+=y;
		p1.repaint();
	}
	
	
}
