import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class Server extends WindowAdapter implements MouseListener
{
	    JFrame f;
	    JLabel l;
	    JTextField t1;
	    JButton b1,b2;
		BufferedReader br;
		ServerSocket ss;
		Socket s;
		ObjectInputStream ois;
		ObjectOutputStream oos;
		Server()
		{
			try
			{
				f=new JFrame("Server Side");
				f.setLayout(null);
				
				f.addWindowListener(this);
				f.addMouseListener(this);
				
				l=new JLabel("Messages");
				
				t1=new JTextField();
				
				b1=new JButton("SEND");
				b2=new JButton("CLEAR");
			
				l.setBounds(0,0,600,400);
				t1.setBounds(0,450,400,200);
				b1.setBounds(500,500,40,40);
				b2.setBounds(550,500,40,40);
				
				b1.setBackground(Color.cyan);
				b2.setBackground(Color.cyan);
				
				f.add(l);
				f.add(t1);
				f.add(b1);
				f.add(b2);
				
				f.setVisible(true);
				f.setResizable(false);
				f.setSize(600,600);
				
				br=new BufferedReader(new InputStreamReader(System.in));
				ss=new ServerSocket(2018);
			    s=ss.accept();
				while(true)
				{
					ois=new ObjectInputStream(s.getInputStream());
					System.out.println(ois.readObject());
					oos=new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(br.readLine());
					t1.setText(br.readLine());
					l.setText(t1.getText());
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
			int a=JOptionPane.showConfirmDialog(f, "Do you want to exit");
			if(a==0)
				f.dispose();
		}
		public void windowClosed(WindowEvent e)
		{
			JOptionPane.showMessageDialog(null, "Your chat is saved");
		}
}
