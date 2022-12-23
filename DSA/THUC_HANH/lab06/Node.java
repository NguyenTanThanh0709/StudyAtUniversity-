public class Node{
    int data;
    Node left;
    Node right;
    int height;

    public Node(){

    }

    public Node(int data){
        this.data = data;
        right = null;
        left = null;
        height = 1;
    }

}