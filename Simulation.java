
/**
 * Simulation.java is the main class that creates an array for the spare parts of the
 * lamp to be produced and starts the threads for each producer and 2 consumers.
 * 
 * @author Divesh Soni
 * @author Krishna Ravikumar
 *
 */
public class Simulation extends Thread{
	
	protected static final int array_length = 25;
	protected static Integer[] inventory = new Integer[5];
    
//	inventory[0] : Screw; inventory[1] : Base; inventory[2] : Stand;
//	inventory[3] : Socket; inventory[4] : Lightbulb;
	    
    public static void main(String args[]){
//	Initializing counters for each spare part 
    for(int i = 0; i <= 4; i++)
    	inventory[i] = 0;
    	
//  Starting threads for each producers along with two consumer threads
    new Thread(new Screw()).start();
    new Thread(new Base()).start();
    new Thread(new Stand()).start();
    new Thread(new Socket()).start();
    new Thread(new LightBulb()).start();

    new Thread(new Consumer()).start();
	new Thread(new Consumer()).start();
    }
    
}
