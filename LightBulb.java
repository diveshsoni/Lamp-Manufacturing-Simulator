/**
 * LightBulb.java implements run() that allows creation of a thread that produces
 * light bulbs and updates the inventory or waits for the Consumers if inventory
 * is full.
 * 
 * @author Divesh Soni
 * @author Krishna Ravikumar
 *
 */

public class LightBulb extends Simulation implements Runnable{

	@Override
	public void run() {
		while(true){
			synchronized(inventory){
//				check if at least 7 slots are empty in the LightBulb inventory
				if(inventory[4] <= array_length - 4){
					inventory[4] += 4;
					System.out.println("LightBulbs added: 4\nLightBulbs available: "+inventory[4]);
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
