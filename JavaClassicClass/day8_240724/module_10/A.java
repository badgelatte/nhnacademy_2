package module_10;
public class A {
    public void m() {
        System.out.println("a");
    }
}

class B extends A {
    public void m() {
        System.out.println("b");
    }
}


class C extends B {
    public void m() {
        System.out.println("c");
    }
}


class D extends C {
    public void m() {
        System.out.println("d");
    }
}

class Test2{
    public static void main(String[] args) {
        // D d = new D();
        C c = new C();
        B b = c;
        A a = b;

        a.m();
        b.m();
        c.m();
        // d.m();
    }
}