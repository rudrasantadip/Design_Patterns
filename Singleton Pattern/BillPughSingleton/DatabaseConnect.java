package BillPughSingleton;
/*Singleton class definition
 * only one instance must be crated globally
 */
class DataBase
{
    private final String url="jdbc:mysql:3306/database";
    private final String username="rudrasantadip";
    private final String password="password123";


    /*We create a private constructor to avoid initialization by other classes */
    private DataBase()
    {
       
    }
    /*
     * The BillPugh Method is the best practice, 
     * where we create an helper class and create a static instance of the
     * database.
     */
    private static class DataBaseHelper {
        private static final DataBase INSTANCE = new DataBase();
    }

    public static DataBase getInstance() {
        return DataBaseHelper.INSTANCE;
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