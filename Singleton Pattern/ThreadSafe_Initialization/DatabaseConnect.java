package ThreadSafe_Initialization;

import javax.xml.crypto.Data;

/*Singleton class definition
 * only one instance must be crated globally
 */
class DataBase
{
    /*
     * One issue with creating singleton objects is that they are not threadsafe,
     * ie, 
     * 1) When multiple threads request for the object they need to wait for the other thread
     * to complete, 
     * 2) If they try to access it concurrently it might lead to unexpected behaviour (fetching an empty object)
     */
    private final String url="jdbc:mysql:3306/database";
    private final String username="rudrasantadip";
    private final String password="password123";

    // We declare a private instance of the database as null;
    private static DataBase INSTANCE;

    /*We create a private constructor to avoid initialization by other classes */
    private DataBase()
    {
       
    }

    // a public method to return the instance

    /*
     * This particular method of creating an instance is called
     * "Thread sage Initialization", here the object is created only when requested
     * i.e if it is null it will be created or else the existing object will be return
     * 
     * The "synchronized" keyword enforces step wise implementation,
     * the entire method is synchronized and once a thread completes using it , the next thread gets it.
     * WE SAY THE METHOD IS LOCKED...
     */
    public static synchronized DataBase getInstance()
    {
        // the instance is created in case it is null;
        if(INSTANCE==null)
        {
            INSTANCE = new DataBase();
        }
        // or else the existing instance is returned
        return INSTANCE;
    }

    /*
     * This is a double checked instance where we 
     * do not lock the entire function but only the object creation 
     * section
     */
    public static DataBase getDoubleCheckedInstance() {
        if (INSTANCE == null) {
            synchronized (DataBase.class) {
                if (INSTANCE== null) {
                    INSTANCE = new DataBase();
                }
            }
        }
        return INSTANCE;
    }

    public void connect()
    {
        System.out.println("Connected to: "+url+" using "+username+" with password "+password);
    }
}

public class DatabaseConnect
{
    public static void main(String[] args) {
        //we fetch the instance of the database
        DataBase db = DataBase.getInstance();
        db.connect();
    }
}