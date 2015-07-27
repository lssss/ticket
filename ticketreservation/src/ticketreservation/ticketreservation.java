package ticketreservation;

 class ticketreservation implements Runnable {
int availableticket=1;
int wanted;

	public ticketreservation(int i) {

wanted=i;
}

	public void run() {
		synchronized(this)
		{
			System.out.println("the number of ticketss available="+availableticket);
			if(availableticket>=wanted)
			{
				String name=Thread.currentThread().getName();
				System.out.println("birth reserverd for"+wanted);
			try{
				wait();
				availableticket=availableticket-wanted;
				Thread.sleep(1000);
			}		catch(InterruptedException e){}
			}
			else
		
		System.out.println("display sorry");
			notify();
			}
 }}
			
 
	class demo
	{
		public static void main(String args[])

		{
			ticketreservation obj=new ticketreservation(1);
			Thread t1=new Thread(obj);
			Thread t2=new Thread(obj);
			t1.start();
			t2.start();
		}
		
		
	}


