package samples.two;

public class KoreaAirplane extends Airplane {
    private String name;

    public KoreaAirplane() {
        this.name = "한국전투기";
    }

    public void getName() {
        System.out.println(this.name);
    }
}
