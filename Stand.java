/**
 * Stand.java implements run() that allows creation of a thread that produces
 * stands and updates the inventory or waits for the Consumers if inventory
 * is full.
 * 
 * @author Divesh Soni
 * @author Krishna Ravikumar
 *
 */

public class Stand extends Simulation implements Runnable{

	@Override
	public void run() {
		while(true){
			synchronized(inventory){
//				check if at least 7 slots are empty in the Stand inventory
				if(inventory[2] <= array_length - 4){
					inventory[2] += 4;
					System.out.println("Stands added: 4\nStands available: "+inventory[2]);
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
