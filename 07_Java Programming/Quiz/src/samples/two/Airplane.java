package samples.two;

public class Airplane implements AtkDef {

    @Override
    public void attack() {
        // TODO Auto-generated method stub
        System.out.println("미사일 공격");
    }
    public void defender() {
        // TODO Auto-generated method stub
        System.out.println("빠른 이동");
    }

    public void fly() {
        System.out.println("편대 이동");
    }
}
