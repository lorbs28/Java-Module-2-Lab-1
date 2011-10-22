
import java.util.logging.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lorbs28
 */
public class LabOneRunnable extends Thread {
    
    private Logger myLogger;  //instance variable for logging    
    private int iCounter, iTerminator;
    private String stringName;  //unique identifier for this thread
    private boolean stopper;
    
    
    public LabOneRunnable() {
        myLogger = Logger.getLogger("labOneLog");  //get a reference to the logger for our application        
    }
    
    public LabOneRunnable(String strIn, int iIn) {
        this();
        
        this.stringName = strIn;
        this.iTerminator = iIn;
        this.iCounter = 0;
    }
    
    public void run() {
        runLabOneThings();
        myLogger.log(Level.INFO, "Killing the thread.");
    }
    
    public void runLabOneThings() {
        try {
            
            while(!this.stopper) {
                this.iCounter++;
                
                System.out.println("Counter is at: " + iCounter);
                
                if (this.iCounter >= this.iTerminator) {
                    myLogger.log(Level.INFO, "Reached the terminator and preparing to stop the thread.");
                    break;
                }
                
                
            
                Thread.sleep(2000);
            }
            
        } catch(Exception e) {
            myLogger.log(Level.SEVERE, "Encountered an exception: " + e.getMessage());
            System.out.println("Encountered an exception at " + new java.util.Date());
            e.printStackTrace();
        }
    }
    
    public String getThreadName()
    {
        return this.stringName;
    }
    
    public int getCount()
    {
        return this.iCounter;
    }
    
    public int getTerminator()
    {
        return this.iTerminator;
    }

    public void allStop()
    {
        myLogger.log(Level.WARNING, "Attempting to stop the thread");
        this.stopper = true;
    }
    
    public String toString()
    {
        StringBuffer strbHold;
        
        strbHold = new StringBuffer();
        strbHold.append("Thread: " + this.stringName);
        strbHold.append(System.getProperty("line.separator"));
        strbHold.append("Counter at: " + this.iCounter);
        return strbHold.toString ();
    }
    
    
}
