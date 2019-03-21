import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class Client extends WindowAdapter implements MouseListener
{
	JFrame f;
	JLabel l;
	JTextField t;
	JButton b1,b2;
	BufferedReader br;
	Socket s;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Client()
	{
		try
		{
			f=new JFrame("Clent Side");
			f.setLayout(null);
			
			l=new JLabel();
			
			t=new JTextField();
			
			b1=new JButton("SEND");
			b2=new JButton("CLEAR");
			
			br=new BufferedReader(new InputStreamReader(System.in));
			
			s=new Socket("localhost",2018);
			
			l.setBounds(0,0,500,300);
			t.setBounds(0,350,300,100);
			b1.setBounds(400,400,40,40);
			b2.setBounds(450,400,40,40);
			
			b1.setBackground(Color.cyan);
			b2.setBackground(Color.cyan);
			
			f.add(l);
			f.add(t);
			f.add(b1);
			f.add(b2);
			
			f.setVisible(true);
			f.setSize(500,500);
			
			while(true)
			{
				oos=new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(br.readLine());
				ois=new ObjectInputStream(s.getInputStream());
				System.out.println(ois.readObject());
				t.setText(br.readLine());
				l.setText(t.getText());
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void mousePressed(MouseEvent e)
	{}
    public void mouseReleased(MouseEvent e)
    {}
    public void mouseClicked(MouseEvent e)
    {}
    public void mouseEntered(MouseEvent e)
    {
    	b1.setBackground(Color.white);
    	b2.setBackground(Color.white);
    }
    public void mouseExited(MouseEvent e)
    {
    	b1.setBackground(Color.cyan);
    	b2.setBackground(Color.cyan);
    }
    public void windowClosing(WindowEvent e)
    {
    	int a=JOptionPane.showConfirmDialog(null,"Do you want to Exit?");
    	if(a==0)
    		f.dispose();
    }
    public void windowClosed(WindowEvent e)
   {
    	JOptionPane.showMessageDialog(null,"Your chat is Saved");
   }
}

