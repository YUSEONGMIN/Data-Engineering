package Inheritance;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Vehicle ===");
        Vehicle vehicle = new Vehicle();
        vehicle.moveForword();
        vehicle.moveBackword();
        // vehicle.openWindow(); 에러 발생

        // Car 클래스는 아무것도 작성되지 않음
        System.out.println("=== Car ===");
        Car car = new Car();
        car.moveForword();
        car.moveBackword();
        car.openWindow();

        System.out.println("=== Bike ===");
        MotorBike bike = new MotorBike();
        bike.start();
        bike.moveForword();
    }
}
