using System;

public class A {

// virtual void라 써야 override가 가능
    public virtual void m(){
        Console.WriteLine("a");
    }
}

// override void라 써야 overrride 기능 가능
public class B : A{
    public override void m(){
        COnsole.WriteLine("b");
    }
}

public class C : B{
    public new virtual void m(){
        Console.WriteLine("c");
    }
}


public class D : C{
    public override void m(){
        Console.WriteLine("d");
    }
}

public class Test{
    public static void Main(string[] args) {
            D d = new D();
            C d = D;

            // B b = new B();
            B b = c;
            A a = b;

            a.m();
            b.m();
            c.m();
            d.m();
            // 결과 = d d d d
    }
}