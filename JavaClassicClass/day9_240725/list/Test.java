package list;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(1);
        list.add("Celine");
        list.add("James");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 다음과 같은 방법이 젤 좋아보이지만 arraylist를 꺼내올 수 없다
        // 끝까지를 어떻게 판단할 것인가? -> hasNext()로 boolean 판단한다
        // for (Object o : list) {
        //     System.out.println(o);
        // }

        // 트리구조같은 경우 위에서 아래로, 왼쪽에서 오른쪽으로 훑어가야하는데 foreach로 돌아가지 않는다
        // 이런 경우 다음 코드와 같이 Enumerator를 만들어 돌릴 수 있다
        // 낼 아침에 할 예정
        // Enumerator enumerator = list.getEnumerator();

        // while(enumerator.hasNext) {
        //     enumerator.next();
        // }
    }
}
