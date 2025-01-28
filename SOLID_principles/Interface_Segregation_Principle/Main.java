// Separate interfaces for specific behaviors
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

// OfficeWorker implements all relevant interfaces
class OfficeWorker implements Workable, Eatable, Sleepable {
    @Override
    public void work() {
        System.out.println("Office worker is working.");
    }

    @Override
    public void eat() {
        System.out.println("Office worker is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Office worker is sleeping.");
    }
}
// Robot need not implement the Eatable and the Sleepable interface
class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working.");
    }
}

public class Main {
    public static void main(String[] args) {
        Workable officeWorker = new OfficeWorker();
        officeWorker.work();

        Eatable eater = new OfficeWorker();
        eater.eat();

        Sleepable sleeper = new OfficeWorker();
        sleeper.sleep();

        Workable robot = new Robot();
        robot.work();
    }
}


