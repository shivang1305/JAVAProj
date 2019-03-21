import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BallAnimation implements ActionListener 
{
	JFrame f;
	Panel2 p1;
	int x,y;
	public BallAnimation()
	{
		f=new JFrame();
		f.setLayout(new BorderLayout());
		p1=new Panel1();
		p1.setBorder(BorderFactory.createLineBorder(Color.RED));
		x=0;
		y=5;
		f.add(p1,BorderLayout.CENTER);
		f.setSize(600,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Timer t=new Timer(5,this);
		t.start();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(f.getWidth()-60==p1.bX)
			x=-3;
		if(f.getHeight()-60==p1.bY)
			y=-3;
		if(p1.bX==0)
			x=3;
		if(p1.bY==0)
			y=5;
		p1.bX+=x;
		p1.bY+=y;
		p1.repaint();
	}
}

/*how will the path of ball be decided?
   */
