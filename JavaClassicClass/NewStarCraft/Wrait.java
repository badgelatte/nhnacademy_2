public class Wrait extends Unit implements Attackable{

    public Wrait(String name, int hp, int attackPower) {
        super(name, hp, attackPower, 0);
    }
    public void attack(Unit unit) {
        if(unit instanceof Flyable) {
            System.out.println("공격불가");
        }
        else {
            System.out.println(unit.getName() + "을 공중에서 공격합니다");
            unit.reduceHp(this.attackPower);
        }
    }
    
    public void move(int location) {
        System.out.println("날아갑니다");
    }
}
