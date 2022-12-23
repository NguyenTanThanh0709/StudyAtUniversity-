public class ScoreAVL extends AVL {

    public ScoreAVL() {
        super();
    }

    public void insert(Student key) {
        this.root = insert(this.root, key);
    }

    private Node insert(Node node, Student hocsinh) {
        // code here
        if(node == null){
            return new Node(hocsinh);
        }
        // so sanh 2 hoc sinh
        int compareStudents = hocsinh.compareToByScore(node.getData());

        // tien hanh so sanh 2 hocj sinh

        if(compareStudents > 0){
            node.setRight(insert(node.getRight(), hocsinh));
        }else if(compareStudents < 0){
            node.setLeft(insert(node.getLeft(), hocsinh));
        }else{
            node.setData(hocsinh);
            // return node;
        }
        // set lai chieu cao cua cay
        node.setHeight(Math.max(this.height(node.getLeft()), this.height(node.getRight())) + 1);
        Node Balanced = this.balance(node);
        return Balanced;
    }
}
