package samples.first;

public class Dog extends Mammalia {
    private String name;
    // Private 변수는 외부에서 접근할 수 없다.
    // 내부 함수에서만 접근이 가능하다.

    public Dog() {
        this.name = "강아지";
    }

    public Dog(String name) {
        this.name = name;
    }

    public void getName() {
        System.out.println(this.name);
    }
}
