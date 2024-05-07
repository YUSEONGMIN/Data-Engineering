package Polymorphism;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Vehicle ===");
        Vehicle vehicle = new Vehicle();
        vehicle.moveForword();
        vehicle.moveBackword();

        System.out.println("=== Car ===");
        Car car = new Car();
        car.moveForword();
        car.moveForword("조심하새요. ");
        car.moveBackword();

        System.out.println("=== Bike ===");
        MotorBike bike = new MotorBike();
        bike.moveForword();
    }    
}