package list;

public class LinkedList implements List{
    // 0725 아침에 작성한 LinkedList 참조하기

    Node node  = null;
    int size = 0;

    public LinkedList(){
    }

    public void add(Object o) {
        if(this.node == null) {
            this.node = new Node(o);
            size++;
        }
        else {
            Node currentNode = this.node;
            while(currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = new Node(o);
            size++;
        }
    }

    public Object get(int index) {
        if(index > size) return "Index is over than LinkedList size";
        int count = 0;
        System.out.println("currentNode"+node.toString());
        while (count++ < index) {
            /* 
            * null 참조 변수를 언박싱하면 NPE가 발생합니다
            * ex
            * Integer a = null;
            * int b = a;  // throws NPE.
            * 출처: https://stackoverflow.com/questions/30014811/assign-null-to-null-in-java 
            
            if(node == null) {
                return "there isn't data";
            }
            */
            node = node.nextNode;
        }

        size--;
        return node;
    }

    public int size() {
        return this.size ;
    }
    

}
