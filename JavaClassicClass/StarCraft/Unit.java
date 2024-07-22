public abstract class Unit{
    public int hp;
    public int attackPower;
    public int movingSpeed;
    public String name;

    public Unit(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public int getAttackPower(){
        return this.attackPower;
    }

    public String getName() {
        return this.name;
    }

    public void reduceHp(int attackPower) {
        this.hp -= attackPower;
    }

    public abstract void attack(Unit unit);

    // public void attack(Unit unit) {
    //     System.out.println(this.name + "이 " + unit.getName() + "을 공격합니다.");
    // }

    public String toString() {
        return this.name + ", " + this.hp;
    }

}