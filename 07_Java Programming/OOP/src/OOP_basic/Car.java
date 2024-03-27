package OOP_basic;

public class Car {
    // 객체(클래스) 정의

    // 속성(변수) 정의 
    public String company; // public 안써도 기본적으로 public
    public String color;
    public int wheels;
    public boolean isConvertible;
    
    // 생성 함수
    public Car() { // 이름이 같음. 여러개 생성 가능하지만..
        System.out.println("생성함수 1");
    }
    public Car(String company) { // 이름만 같으면 생성안됨. 파라미터 값을 변경
        this.company = company;
        System.out.println("생성함수 2");
    }

    
    // 기능(함수) 정의 
    void startEngine() {
        System.out.println("시동을 겁니다.");
    }
    void moveEngine() {
        System.out.println("자동차가 앞으로 전진합니다.");
    }
}