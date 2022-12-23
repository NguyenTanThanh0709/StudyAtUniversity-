import java.util.ArrayList;

public class AVL {
    protected Node root;

    public AVL() {
        root = null;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(Student key) {
        this.root = insert(this.root, key);
    }

    private Node insert(Node node, Student student) {
        // code here
        if(node == null){
            return new Node(student);
        }
        // so sanh 2 hoc sinh
        int compareStudents = student.compareTo(node.getData());

        if(compareStudents > 0){
            node.setRight(insert(node.getRight(), student));
        }else if(compareStudents < 0){
            node.setLeft(insert(node.getLeft(), student));
        }else{
            node.setData(student);
            // return node;
        }
        // set lai chieu cao cua cay
        node.setHeight(Math.max(this.height(node.getLeft()), this.height(node.getRight())) + 1);
        Node Balanced = balance(node);
        return Balanced;
    }

    public Node search(int key) {
        return search(root, key);
    }

    private Node search(Node node, int key) {
        // code here
        if(node == null) return null;
        int ID_Node  =  node.getData().getId();

        if(ID_Node > key){
            return search(node.getLeft(), key);
        }else if(ID_Node < key){
            return search(node.getRight(), key);
        }else if(ID_Node == key){
            return node;
        }
        return null;
    }

    public void delete(Student key) {
        if(this.root != null){
            root = delete(root, key);
        }
    }

    private Node delete(Node node, Student key) {
        // code here
        if(node == null) return node; 
        int compareStudents = key.compareTo(node.getData());

        if(compareStudents > 0){
            node.setRight(delete(node.getRight(), key));
        }else if(compareStudents < 0){
            node.setLeft(delete(node.getLeft(), key));
        }else{
            
            // return node;
            if((node.getLeft() == null) || (node.getRight() == null)){
                Node TempNode = null;
                if(TempNode == node.getLeft()){
                    TempNode = node.getRight();
                }else{
                    TempNode = node.getLeft();
                }

                if(TempNode == null){
                    TempNode = node;
                    node = null;
                }else{
                    node = TempNode;
                }
            }else{
                Node TempNodeMin = findMin(node.getRight());
                node.setData(TempNodeMin.getData());
                node.setRight(deleteMin(node.getRight()));
            }
        }
        if(node == null) return node;

        node.setHeight(Math.max(this.height(node.getLeft()), this.height(node.getRight())) + 1);
        Node Balanced = balance(node);
        return Balanced;
    }

    // ------------------Supported methods------------------

    public int height() {
        return height(root);
    }

    protected int height(Node node) {
        if (node == null)
            return -1;
        return node.getHeight();
    }

    private Node rotateLeft(Node x) {
        Node y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        return y;
    }

    private Node rotateRight(Node x) {
        Node y = x.getLeft();
        x.setLeft(y.getRight());
        y.setRight(x);
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        return y;
    }

    private int checkBalance(Node x) {
        return height(x.getLeft()) - height(x.getRight());
    }

    protected Node balance(Node x) {
        if (checkBalance(x) < -1) {
            if (checkBalance(x.getRight()) > 0) {
                x.setRight(rotateRight(x.getRight()));
            }
            x = rotateLeft(x);
        } else if (checkBalance(x) > 1) {
            if (checkBalance(x.getLeft()) < 0) {
                x.setLeft(rotateLeft(x.getLeft()));
            }
            x = rotateRight(x);
        }
        return x;
    }

    public ArrayList<Node> NLR() {
        ArrayList<Node> result = new ArrayList<Node>();
        NLR(this.root, result);
        return result;
    }

    private void NLR(Node node, ArrayList<Node> result) {
        if (node != null) {
            result.add(node);
            NLR(node.getLeft(), result);
            NLR(node.getRight(), result);
        }
    }

    private Node deleteMin(Node x) {
        if (x.getLeft() == null)
            return x.getRight();
        x.setLeft(deleteMin(x.getLeft()));
        return x;
    }

    private Node findMin(Node x) {
        if (x.getLeft() == null)
            return x;
        else
            return findMin(x.getLeft());
    }

    public boolean contain(int id) {
        return search(root, id) == null ? false : true;
    }

}
