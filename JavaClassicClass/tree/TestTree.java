public class TestTree {
    static class TestBinarySearchTree extends BinarySearchTree<Integer>{
        public TestBinarySearchTree(){
            super();

            // root = new Node<Integer>(50);

            root = new Node<Integer>(50, 
                new Node<Integer>(30, 
                    new Node<Integer>(10, null,  new Node<Integer>(16)),
                    new Node<Integer>(45)),
                new Node<>(60, 
                    null, 
                    new Node<>(100)));

        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst_Test = new TestBinarySearchTree();
        System.out.println(bst_Test.toString());

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(60);
        bst.insert(10);
        bst.insert(45);
        bst.insert(15);
        bst.insert(100);
        bst.insert(35);

        System.out.println(bst.search(30));
        System.out.println("root: " + bst);

        System.out.println(bst.toDFS(false));
        System.out.println(bst.toDFS(true));
        System.out.println(bst.toBFS(false));
        System.out.println(bst.toBFS(true));
    }
}
