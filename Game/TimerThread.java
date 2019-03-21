class TimerThread extends Thread
{
public void run()
{
for(int i=60;i>=0;i--)
{
Game.timer.setText(""+i);
try
{
Thread.sleep(1000);
}
catch(Exception e)
{
}
}
}
}