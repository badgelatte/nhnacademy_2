public class Test {
    public static void main(String[] args) {
        AList list = new AArrayList();
        list.add(1);
        list.add("James");
        list.add("Celine");

        //System.out.println(list.get(0));
        //System.out.println(list.get(1));

        AEnumerator enumerator = list.getEnumerator();
        while (enumerator.hasNext()) {
            System.out.println(enumerator.next());
        }

        ((AArrayList)list).remove(1);

        AEnumerator enumerator2 = list.getEnumerator();
        while (enumerator2.hasNext()) {
            System.out.println(enumerator2.next());
        }
    }
}
