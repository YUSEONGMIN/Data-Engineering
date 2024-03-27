package Abstraction;

public interface Vehicle { //선언만. 기능은 Car 클래스에서 정의
    // 추상화란 객체들의 묶음

    // 상속은 상속받을 대상도 클래스 <-> 추상화는 추상적
    // 상속은 부모도 클래스, 추상화는 아니다.

    public void start();
    public void moveForward();
    public void moveBackward();
}
