public class Sample {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");

        System.out.println(s1 == s2);
        // false가 떨어진다 둘의 내용물이 같아도 새로 생성해서 저장한 곳 위치가 다르다

        System.out.println(s1.equals(s2));
        // 값이 같은지를 확인하지 위치가 같은지까진 확인하지 않기 때문이다
    }
}
