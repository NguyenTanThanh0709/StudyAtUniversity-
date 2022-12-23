public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        // bst.insert(7);
        // bst.insert(5);
        // bst.insert(9);
        // bst.insert(8);
        // bst.insert(15);
        // bst.insert(4);
        // bst.insert(3);
        // bst.insert(1);
        // bst.insert(0);
        // bst.insert(2);

        String listNumber = "5 2 9 4 1 3 12 43 12 42";
        bst.insertRootFromListString(listNumber);

        // bst.deleteNodeMinkey();
        // bst.deleteNode(7);

        bst.deleteMax();
        bst.inOrder();
    }
    
}
