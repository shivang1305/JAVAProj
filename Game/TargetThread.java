class TargetThread extends Thread
{
public void run()
{
while(true)
{
int x=Game.target.getX();
if(x>=400)
x=0;
Game.target.setBounds(x+10,30,100,20);
try
{
Thread.sleep(100);
}
catch(Exception e)
{
}
}
}
}