// Abstraction for input devices
interface InputDevice {
    void input();
}

// Abstraction for display devices
interface DisplayDevice {
    void display();
}

// Low-level module
class Keyboard implements InputDevice {
    @Override
    public void input() {
        System.out.println("Typing on a keyboard...");
    }
}

// Low-level module
class Monitor implements DisplayDevice {
    @Override
    public void display() {
        System.out.println("Displaying on the monitor...");
    }
}

// High-level module depends on abstractions
class Computer {
    private InputDevice inputDevice;
    private DisplayDevice displayDevice;

    public Computer(InputDevice inputDevice, DisplayDevice displayDevice) {
        this.inputDevice = inputDevice;
        this.displayDevice = displayDevice;
    }

    public void use() {
        inputDevice.input();
        displayDevice.display();
    }
}

public class Main {
    public static void main(String[] args) {
        /*in case we want to change the input device, for example
         *change a keyboard with a joy stick, we can simple create a new InputDevice Object
         */
        InputDevice keyboard = new Keyboard();

        DisplayDevice monitor = new Monitor();

        Computer computer = new Computer(keyboard, monitor); // Inject dependencies
        computer.use();
    }
}
