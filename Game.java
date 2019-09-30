import java.awt.*;
import java.awt.event.*;

class Game
{
static Frame f;
static Button target,tank,bullet;
static Label timer,score;
TargetThread t1;
TimerThread t2;
Game()
{
f=new Frame();
f.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e)
{
t1.stop();
t2.stop();
f.dispose();
}
});
target=new Button();
tank=new Button();
bullet=new Button();
timer=new Label("60");
score=new Label("0");
f.setLayout(null);
target.setBounds(10,30,100,20);
tank.setBounds(180,360,40,40);
bullet.setBounds(195,350,10,10);
timer.setBounds(10,360,40,40);
score.setBounds(360,360,40,40);
f.add(target);
f.add(tank);
f.add(bullet);
f.add(score);
f.add(timer);


f.setVisible(true);
f.setSize(400,400);
t1=new TargetThread();
t1.start();
t2=new TimerThread();
t2.start();
}
public static void main(String ar[])
{
System.out.println("WELCOME TO MY GAME");
Game g=new Game();
}
}
