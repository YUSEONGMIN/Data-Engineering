package Abstraction;

public class MotorBike implements Vehicle {

     @Override
     public void moveBackward() {
          System.out.println("자동차가 앞으로 전진합니다.");
     }

     @Override
     public void moveForward() {
          System.out.println("자동차가 위로 후진합니다.");
     }

     @Override
     public void start() {
          System.out.println("시동을 겁니다.");
     }
}
