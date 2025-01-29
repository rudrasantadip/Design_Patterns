package Lazy_Initialization;
/*Singleton class definition
 * only one instance must be crated globally
 */
class DataBase
{
    private final String url="jdbc:mysql:3306/database";
    private final String username="rudrasantadip";
    private final String password="password123";

    // We declare a private instance of the database as null;
    private static DataBase INSTANCE=null;

    /*We create a private constructor to avoid initialization by other classes */
    private DataBase()
    {
       
    }

    // a public method to return the instance

    /*
     * This particular method of creating an instance is called
     * "Lazy Initialization", here the object is created only when requested
     * i.e if it is null it will be created or else the existing object will be return
     */
    public static DataBase getInstance()
    {
        // the instance is created in case it is null;
        if(INSTANCE==null)
        {
            INSTANCE = new DataBase();
        }
        // or else the existing instance is returned
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