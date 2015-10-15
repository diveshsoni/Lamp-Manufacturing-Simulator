/**
 * Base.java implements run() that allows creation of a thread that produces
 * bases and updates the inventory or waits for the Consumers if inventory
 * is full.
 * 
 * @author Divesh Soni
 * @author Krishna Ravikumar
 *
 */

public class Base extends Simulation implements Runnable{

	@Override
	public void run() {
		while(true){
			synchronized(inventory){
//				check if at least 2 slots are empty in the Base inventory
				if(inventory[1] <= array_length - 2){
					inventory[1] += 2;
					System.out.println("Bases added: 2\nBases available: "+inventory[1]);
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
