
/**
 * Screw.java implements run() that allows creation of a thread that produces
 * screws and updates the inventory or waits for the Consumers if inventory
 * is full.
 * 
 * @author Divesh Soni
 * @author Krishna Ravikumar
 *
 */
public class Screw extends Simulation implements Runnable{
	
	@Override
	public void run() {
		while(true){
			synchronized(inventory){
//				check if at least 4 slots are empty in the Screw inventory
				if(inventory[0] <= array_length - 4){
					inventory[0] += 4;
					System.out.println("Screws added: 4\nScrews available: "+inventory[0]);
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
