package Inheritance;

public class Car extends Vehicle { // 부모 클래스 선언
    // 추상화는 기능을 정의하지 않아 오류 발생
    // 상속은 기능이 정의 되어있음
    public void openWindow() {
        System.out.println("창문을 엽니다.");
    }
}
