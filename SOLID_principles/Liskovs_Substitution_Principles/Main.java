// Flyable is defined as an interface, such that it can serve as a seperate feature
// it will be inherited by only those birds who can fly
interface Flyable
{
    public void fly();
}

/*
 * The generic bird class
 */
class Bird{
    public void eat(){
        System.out.println("Eating...");
    }
}

/*
 * Sparrow uses both the bird class and the
 * flyable interface, since it can fly 
 */
class Sparrow extends Bird implements Flyable{

    @Override
    public void fly() {
       System.out.println("Sparrow Eats...");
    }
}

/*
 * Since penguin cannot fly
 * we are not implepenting the flyable interface
 */
class Penguin extends Bird{
    
    @Override
    public void eat()
    {
        System.out.println("Penguin Eats...");
    }
}

public class Main {
    public static void main(String[] args) {
        
    }
}
