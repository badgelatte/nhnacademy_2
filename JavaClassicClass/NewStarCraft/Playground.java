public class Playground {
    public static void main(String[] args) {
        // Zealot z1 = new Zealot("Zealot1", 15, 3, 0);
        // Marine m1 = new Marine("Marine1", 10, 2, 1);
        // Wrait w1 = new Wrait("Wrait1",12,2);
        // Medic me1 = new Medic("Medic1",10,0);
        // Observer o1 = new Observer("Observer1", 0, 0, 0);

        // Unit[] units = {z1, m1, w1, me1};

        // for (Unit u : units) {
        //     u.move(10);
        // }

        // for (Unit u : units) {
        //     if(u instanceof Attackable) {
        //         ((Attackable)u).attack(u);
        //     }
        // }

        // z1.attack(w1);
        // z1.attack(o1);

        // 참조 타입
        Zealot z = new Zealot("z1", 15, 3, 1);
        Marine m = new Marine("m1", 10, 2, 2);

        Attackable a;
        a = z;
        a = m;
        a.attack(m);

        Zealot z2 = new Zealot("z2", 15, 3, 1);

        Zealot[] zs = {z2, new Zealot("z1", 0, 1, 1)};

        zs[0] = null;
        if(zs[0] != null) {
            zs[0].attack(z);
        }

        // 참조타입
        Zealot z4 = new Zealot("z1", 15, 3, 1);
        Zealot z3 = new Zealot("z1", 15, 3, 1);

        System.out.println(z4);
        System.out.println(z3);

        System.out.println(z4 == z3);

        // 내용물을 바꿔도 과연 다른 것인가
        Zealot zz1 = new Zealot("zz1", 10, 1, 2);
        Zealot zz2 = zz1;

        zz2.setName("Zealot Zol");

        System.out.println(zz1.getName());
        System.out.println(zz2.getName());

        
    }
}
