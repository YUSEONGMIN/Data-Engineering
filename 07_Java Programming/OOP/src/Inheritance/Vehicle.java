package Inheritance;

public class Vehicle {
    public String model;
    public String color;
    public int Wheels;

    public Vehicle() {
    } // 생성함수 선언

    public void moveForword() {
        System.out.println("전진합니다.");
    }

    public void moveBackword() {
        System.out.println("후진합니다.");
    }
}
