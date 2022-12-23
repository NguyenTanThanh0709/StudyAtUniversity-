
public class BST {
    Node root;
    int countElemant;
    public BST(){
        root = null;
        countElemant = 0;
    }

    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public boolean isEmpty(){
        return countElemant == 0;
    }

    public Node getMin(){
        return getMin(root);
    }

    private Node getMin(Node root){
        if(root.left == null){
            return root;
        }else{
            return getMin(root.left);
        }
    }

    public Node getMax(){
        return getMax(root);
    }

    private Node getMax(Node root){
        if(root.right == null){
            return root;
        }else{
            return getMax(root.right);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node root){
        if(root == null){
            return;
        }else{
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node root){
        if(root == null){
            return;
        }else{
            
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void printdesc(){
        printdesc(root);
    }

    private void printdesc(Node root){
        if(root == null){
            return;
        }else{
            
            printdesc(root.right);
            System.out.print(root.data + " ");
            printdesc(root.left);
        }
    }


    public void posOrder(){
        posOrder(root);
    }

    private void posOrder(Node root){
        if(root == null){
            return;
        }else{
            
            posOrder(root.left);
            posOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void insert(int data){
        root = insert(root,data);
    }

    private Node insert(Node root, int data) {
        if(root == null){
            return new Node(data);
        }
        if(data > root.data){
            root.right = insert(root.right, data);
        } else  if(data < root.data){
            root.left = insert(root.left, data);
        }
        return root;
    }

    public boolean contains(int data){
        return contains(root,data);
    }

    private boolean contains(Node root, int data) {
        if(root == null){
            return false;
        }

        if(data == root.data){
            return true;
        } else if( data > root.data){
            return contains(root.right, data);
        }else if( data < root.data){
            return contains(root.left, data);
        }else{
            return false;
        }
    }

    public void deleteNodePredecessor (){
        root = deleteNodePredecessor (root);
    }

    private Node deleteNodePredecessor (Node root) {
        if(root == null){
            return null;
        }
        Node temp = root;
        Node pre = null;
        while(temp.left != null){
            pre = temp;
            temp = temp.left;
        }
        pre.left = temp.right;
        return root;
    }

    public void deleteNodePredecessor (int data){
        root = deleteNodePredecessor (root,data);
    }

    private Node deleteNodePredecessor (Node root, int data) {
        if(root == null){
            return null;
        }

        if(data > root.data){
            root.right = deleteNodePredecessor (root.right, data);
        }else if(data < root.data){
            root.left = deleteNodePredecessor (root.left, data);
        }else{
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            Node maxNode = root.left;
            Node pre = maxNode;

            while(maxNode.right != null){
                pre = maxNode;
                maxNode = maxNode.right;
            }

            maxNode.right = root.right;
            if(pre != maxNode){
                pre.right = maxNode.left;
                maxNode.left = root.left;
            }
            return maxNode;
        }


        return root;
    }

    public void deleteNodeSuccessor (int data){
        root = deleteNodeSuccessor (root,data);
    }

    private Node deleteNodeSuccessor (Node root, int data) {
        if(root == null){
            return null;
        }

        if(data > root.data){
            root.right = deleteNodeSuccessor (root.right, data);
        }else if(data < root.data){
            root.left = deleteNodeSuccessor (root.left, data);
        }else{
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            Node maxNode = root.right;
            Node pre = maxNode;

            while(maxNode.left != null){
                pre = maxNode;
                maxNode = maxNode.left;
            }

            maxNode.left = root.left;
            if(pre != maxNode){
                pre.left = maxNode.right;
                maxNode.right = root.left;
            }
            return maxNode;
        }


        return root;
    }




    public void insertRootFromListString(String string){
        String[] listString = string.split(" ");
        for(int i = 0; i < listString.length; i++){
            insert(Integer.parseInt(listString[i]));
        }
    }

    public void deleteMax(){
        root =deleteMax(root);
    }

    private Node deleteMax(Node root) {
        if(root.right == null){
            return root.left;
        }
        root.right = deleteMax(root.right);
        return root;
    }

    public int sumAll(){
        return sumAll(root);
    }

    private int sumAll(Node root){
        if(root == null){
            return 0;
        }
        return root.data + sumAll(root.left) + sumAll(root.right);
    }

    public int sumSub(){
        return sumSub(root.left) + sumSub(root.right);
    }

    public int sumSub(Node root){
        if(root == null){
            return 0;
        }
        return root.data + sumSub(root.left) + sumSub(root.right);
    }

}
