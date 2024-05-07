package samples.two;

public class Main {
    public static void main(String[] args) {
        KoreaShip koreaShip = new KoreaShip();
        KoreaAirplane koreaAirplane = new KoreaAirplane();

        koreaAirplane.attack();
        koreaShip.attack();
        koreaAirplane.defender();
        koreaAirplane.fly();
        koreaShip.dive();
        koreaAirplane.getName();
        koreaShip.getName();
    }
}
