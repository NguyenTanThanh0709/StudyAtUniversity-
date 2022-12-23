
public class AVL {
    Node root;
    public AVL(){
    }

    public int getHeight(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public int checkBalance(Node node){
        return getHeight(node.left) -getHeight(node.right);
    }

    private Node leftRotation(Node root){
        Node y = root.right;
        root.right = y.left;
        y.left = root;
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        return y;
    }

    private Node rightRotation(Node root){
        Node y = root.left;
        root.left = y.right;
        y.right = root;
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        return y;
    }

    public String preOrder(){
        String str = "";
        preOrder(root,str);
        System.out.println(str);
        return str;
    }

    private void preOrder(Node root,String str) {
        if(root != null){
            System.out.print(root.data + " ");
            str = str + root.data.toString() + " ";
            preOrder(root.left,str);
            preOrder(root.right,str);
        }
    }

    public String inorder(){
        String str = "";
        inorder(root,str);
        System.out.println(str);
        return str;
    }

    private void inorder(Node root,String str) {
        if(root != null){
            System.out.print(root.data + " ");
            str = str + root.data.toString() + " ";
            inorder(root.left,str);
            inorder(root.right,str);
        }
    }

    public String posOrder(){
        String str = "";
        posOrder(root,str);
        System.out.println(str);
        return str;
    }

    private void posOrder(Node root,String str) {
        if(root != null){
            System.out.print(root.data + " ");
            str = str + root.data.toString() + " ";
            posOrder(root.left,str);
            posOrder(root.right,str);
        }
    }

    private Node balance(Node x) {
         if (checkBalance(x) < -1) {
            if (checkBalance(x.right) > 0) {
                x.right = rightRotation(x.right);
            }
            x = leftRotation(x);
        }
        else if (checkBalance(x) > 1) {
                if (checkBalance(x.left) < 0) {
                    x.left = leftRotation(x.left);
                }
                x = rightRotation(x);
            }
         return x;
    }

    public void insert(Integer data){
        root = insert(root,data);
    }

    private Node insert(Node root, Integer data) {
        if(root == null){
            return new Node(data);
        }else{
            int cmp = data.compareTo(root.data);
            if(cmp < 0){
                root.left = insert(root.left, data);
            }else if(cmp > 0){
                root.right = insert(root.right, data);
            }else{
                root.data  = data;
            }
            root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
            return balance(root);
        }
    }

    public void deleteNode(Integer data){
        root = deleteNode(root,data);
    }

    private Node getMax(Node root){
        if(root.right == null){
            return root;
        }
        return getMax(root.right);
    }

    private Node deleteNode(Node root, Integer data) {
        if(root == null) return null;
        int cmp = data.compareTo(root.data);
        if(cmp < 0){
            root.left = deleteNode(root.left, data);
        }else if(cmp > 0){
            root.right = deleteNode(root.right, data);
        }else{
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            Node NodeMaxLeft = getMax(root.left);
            root.data = NodeMaxLeft.data;
            Node delete = deleteNode(root,NodeMaxLeft.data);
            root.left = delete;

            
        }
        root.height = 1+ Math.max(getHeight(root.left), getHeight(root.right));

        
            return balance(root);
    }
    
}
