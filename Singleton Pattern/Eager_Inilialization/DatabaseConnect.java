package Eager_Inilialization;
/*Singleton class definition
 * only one instance must be crated globally
 */
class DataBase
{
    private final String url="jdbc:mysql:3306/database";
    private final String username="rudrasantadip";
    private final String password="password123";

    // We declare a private instance of the database ;
    private static DataBase INSTANCE=new DataBase();

    /*We create a private constructor to avoid initialization by other classes */
    private DataBase()
    {
       
    }
    
    /*
     * This particular method of creating an instance is called
     * "Eager Initialization", here the object is created when the class
     * is loaded.
     */
    public static DataBase getInstance()
    {
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