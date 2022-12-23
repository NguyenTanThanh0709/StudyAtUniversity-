public class Node{
    Integer data;
    Node left;
    Node right;
    int height;
    public Node(Integer data){
        this.data = data;   
        height = 0;
        left = right = null;
    }
}