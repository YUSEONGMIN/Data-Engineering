package Encapsulation;

public class TestClass {
    public int a = 1;
    private int b = 2;

    public void add1() {
        System.out.println(this.a + this.b);
    }

    private void add2() {
        System.out.println(this.a + this.b);
    }

    public void add3() {
        this.add2();
    }
}
