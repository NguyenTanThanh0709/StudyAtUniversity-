public class Test {
    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.insert(33);
        tree.insert(96);
        tree.insert(14);
        tree.insert(29);
        tree.insert(78);
        tree.insert(94);
        tree.insert(34);
        tree.insert(42);
        tree.insert(93);
        tree.insert(99);
        tree.NLR();
        tree.delete_pre(78);
        tree.NLR();
        tree.delete_pre(29);
        tree.NLR();
        tree.delete_pre(42);
        // tree.delete(42);
        tree.NLR();

        tree.delete_pre(94);
        // tree.delete(42);
        tree.NLR();

    }
}
