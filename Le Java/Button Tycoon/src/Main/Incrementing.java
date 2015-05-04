package Main;

import java.util.concurrent.TimeUnit;

public class Incrementing implements Runnable {

	private int i = 0;
	
	Incrementing(int i){
		this.i = i;
	}
	
	@Override
	public void run() {
		while(true)
		{
			Main.money+=i;
			Main.sum.setText(Integer.toString(Main.money));
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}