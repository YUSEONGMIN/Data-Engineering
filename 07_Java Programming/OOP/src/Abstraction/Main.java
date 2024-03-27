package Abstraction;

public class Main {
    public static void main(String[] args) {
    System.out.println("==== Car ====");
    Car car1 = new Car();
    car1.start();
    car1.moveForward();
    car1.moveBackward();
    
    System.out.println("==== Motor ====");
    MotorBike motorbike1 = new MotorBike();
    motorbike1.start();
    motorbike1.moveForward();
    motorbike1.moveBackward();
    }
}
