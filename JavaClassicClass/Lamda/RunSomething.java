@FunctionalInterface
public interface RunSomething {
    void doIt();

    static void printName() {
        System.out.println("catsbi");
    }

    default void printAge() {
        System.out.println("33");
    }
}

class DoRun implements RunSomething {
    public void doIt() {
        System.out.println("Hello");
    }
}

class Test2 {
    public static void main(String[] args) {
        // RunSomething r= () -> System.out.println("Hello");  // 이는 class DoRun과 같다
       
        // 이렇게 2개 실행 가능
        RunSomething r = () -> {
            System.out.println("Hello");
            System.out.println("World!");
        };

        RunSomething r2 = new RunSomething() {
            public void doIt() {
                System.out.println("Hello");
            }
        };
        
        DoRun d = new DoRun();
        d.doIt();
        r2.doIt();
        r.doIt();
    }
}
