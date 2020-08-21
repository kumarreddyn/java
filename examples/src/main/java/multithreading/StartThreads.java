package multithreading;

import java.util.Random;

public class StartThreads {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		Runnable runnable = () -> {
			while(true){
				try {
					int randomNumber = random.nextInt(10);
					System.out.println(Thread.currentThread().getName()+" - "+randomNumber);
					if(randomNumber==5){
						break;
					}
					Thread.sleep(3000);					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		for(int i=0; i<5; i++){
			Thread t = new Thread(runnable);
			t.start();
		}
	}
}
