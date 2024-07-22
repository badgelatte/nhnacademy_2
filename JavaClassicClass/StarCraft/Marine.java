public class Marine extends Unit{

    public Marine(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    @Override
    public void attack (Unit unit) {
        System.out.println(this.getName() + "이 " + unit.getName() + "을 기관총으로 쏩니다");
        unit.reduceHp(this.attackPower);
    }

}