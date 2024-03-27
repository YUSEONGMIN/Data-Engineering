package samples.two;

public class KoreaShip extends Ship {
    private String name;

    public KoreaShip() {
        this.name = "한국잠수함";
    }

    public void getName() {
        System.out.println(this.name);
    }

}
