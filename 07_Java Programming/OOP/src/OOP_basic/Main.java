package OOP_basic;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world");

        // 생성함수1을 이용해서 만들어짐
        Car car1 = new Car();
        car1.startEngine();
        car1.moveEngine();
        System.out.println(car1.company);
        System.out.println("==========");

        // 생성함수2를 이용
        Car car2 = new Car("Playdata");
        System.out.println(car2.company);
    }
}