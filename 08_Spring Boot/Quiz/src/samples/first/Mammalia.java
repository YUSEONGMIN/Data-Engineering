package samples.first;

public class Mammalia implements Biology {
    public String name;

    public Mammalia() {
        this.name = "포유류";
    }

    @Override
    public void breath() {
         System.out.println("폐로 숨을 쉰다.");
    }
}