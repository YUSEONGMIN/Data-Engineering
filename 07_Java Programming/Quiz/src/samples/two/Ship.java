package samples.two;

public class Ship implements AtkDef {

    @Override
    public void attack() {
        // TODO Auto-generated method stub
        System.out.println("어뢰 공격");
    }
    

    @Override
    public void defender() {
        // TODO Auto-generated method stub
    }


    public void dive() {
        System.out.println("깊은 잠수");
    }
}
