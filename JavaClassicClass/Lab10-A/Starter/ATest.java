public class ATest {
    public static void main(String[] args) {
        AList list = new AArrayList();
        list.add(1);
        list.add("James");
        list.add("Celine");

        //System.out.println(list.get(0));
        //System.out.println(list.get(1));

        AEnumerator enumerator = list.getEnumerator();
        while(enumerator.hasNext()) {
            System.out.println(enumerator.next());
        }

        // 할 수 았게 하려면 전부 iterator를 상속하면 된다
        for(Object o : list) {
            System.out.println(o);
        }
    }
}
