package Encapsulation;

public class Main {
    public static void main(String[] args) {
        TestClass test = new TestClass();

        System.out.println("=== public ===");
        System.out.println(test.a);
        test.add1();
        test.add3(); // add2는 보이지 않음

        // test.b; 조회할 수 없음
    }
}
