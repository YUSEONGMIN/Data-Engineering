package samples.first;

public class Pisces implements Biology {
    private String name;

    public Pisces() {
        this.name = "어류";
    }

    @Override
    public void breath() {
        // TODO Auto-generated method stub
        System.out.println("아가미로 숨을 쉰다.");
    }
}
