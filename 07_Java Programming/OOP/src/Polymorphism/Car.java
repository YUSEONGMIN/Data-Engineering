package Polymorphism;

public class Car extends Vehicle {

    @Override
    public void moveBackword() {
         System.out.println("후진합니다.");
    }
    public void moveForword(String msg) {
        System.out.println(msg + "전진합니다.");
    }
}
