import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Anomynous Class 방식
class Func implements Function<Integer, Integer> {
    public Integer apply(Integer i) {
        return i * 2;
    }
}

// 메소드 참조
class Mapper{
    public static Integer times2(Integer i) {
        return i * 2;
    }
}

public class ListSample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i =1; i<= 10; i++) {
            list.add(i);
        }
        // list 하나씩 print하기 -> Lambda로 실행해보기
        list.forEach(i-> System.out.println(i));
        list.forEach(System.out::println);

        // stream() 사용하여 하나씩 출력
        list.stream().collect(Collectors.toList()).forEach(System.out::println);
        list.stream().map(i-> i * 2).collect(Collectors.toList()).forEach(System.out::println);
        
        // map에 i->i*2 라는 람다식 대신 Func클래스 만들어서 집어넣기
        list.stream().map(new Func()).collect(Collectors.toList()).forEach(System.out::println);

        // Anomynous Class 방식
        Function<Integer, Integer> func = new Function<Integer,Integer>() {
            public Integer apply(Integer i) {
                return i * 2;
            }
        };
        list.stream().map(func).collect(Collectors.toList()).forEach(System.out::println);

        // Fuction interface에 람다식으로 구현하기
        Function<Integer, Integer> func2 = i -> i * 2;
        list.stream().map(func2).collect(Collectors.toList()).forEach(System.out::println);

        // 메소드 참조
        list.stream().map(Mapper::times2).collect(Collectors.toList()).forEach(System.out::println);


        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::println);

        // filter: Predicate 인터페이스 boolean Test(T t)
        // Map: function 인터페이스 R apply(T t)
        stream.filter(i -> i % 2 == 0).map(i -> i * 2).collect(Collectors.toList()).forEach(System.out::println);
    }
}
