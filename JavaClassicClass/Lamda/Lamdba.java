interface DoSomething{
    public int doIt(int i);
}

class realClass implements DoSomething{
    public int doIt(int end) {
        int result = 0;
        for(int i = 0; i <=end; i++) {
            result += i;
        }
        return result;
    }
}

public class Lamdba {
    // realClass 구현한 것과 동일
    // DoSomething d1 = () -> 1;
    // DoSomething d2 = () ->  {int x = 1; return x;};

    // DoSomething d3 = (int i) -> {return i + 1;};

    // 여기에 int와 () 생략 가능
    DoSomething d4 = (int end) -> {
        int result = 0;
        for(int i = 0; i <=end; i++) {
            result += i;
        }
        return result;
    };
}
