
/**
 * Consumer.java removes spare parts from the inventory to make lamps 
 * and waits for other producers if the inventory is not sufficiently full.
 * 
 * @author Divesh Soni
 * @author Krishna Ravikumar
 *
 */
public class Consumer extends Simulation implements Runnable{

	public void run(){
		while(true){
			synchronized(inventory){
				
				if(inventory[0] >= 4 && inventory[1] >= 2 && inventory[2] >= 4 && inventory[3] >= 7 && inventory[4] >= 4){
					inventory[0] -= 4;
					inventory[1] -= 2;
					inventory[2] -= 4;
					inventory[3] -= 7;
					inventory[4] -= 4;
					System.out.println("Lamp created!");
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
