public class TimerThread extends Thread
{
	int sec=0,min=0;
	public void run()
	{
		for(sec=0;sec<=59;sec++)
		{
			if(sec==59)
			{
				min++;
				sec=0;
			}
			PaddleAndBall.timelabel.setText("TIME "+min+":"+sec);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
