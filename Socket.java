/**
 * Socket.java implements run() that allows creation of a thread that produces
 * sockets and updates the inventory or waits for the Consumers if inventory
 * is full.
 * 
 * @author Divesh Soni
 * @author Krishna Ravikumar
 *
 */

public class Socket extends Simulation implements Runnable{

	@Override
	public void run() {
		while(true){
			synchronized(inventory){
//				check if at least 7 slots are empty in the Socket inventory
				if(inventory[3] <= array_length - 7){
					inventory[3] += 7;
					System.out.println("Sockets added: 7\nSockets available: "+inventory[3]);
					inventory.notifyAll();
				}
				else {
					try {
						inventory.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}						
		}
	}	
}
