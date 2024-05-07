package samples.first;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.breath(); // 추상화 & 상속
        dog1.getName(); // 캡슐화
        
        Dog dog2 = new Dog("멍멍");
        dog2.breath();
        dog2.getName(); // 캡슐화
    }
}
