import java.util.*;

public class StudentManagement {
    private AVL tree;

    private Stack<Node> undoState;
    private Stack<Node> redoState;

    public StudentManagement() {
        this.tree = new AVL();
        this.undoState = new Stack<Node>();
        this.redoState = new Stack<Node>();
    }

    public AVL getTree() {
        return this.tree;
    }

    // Requirement 1
    public boolean addStudent(Student st) {
        // code here
        if(tree.contain(st.getId())){
            this.undoState.push(null);
            this.redoState.clear();
            return false;
        }
        tree.insert(st);
        
        Node tempNode = copy(this.tree.getRoot());
        this.undoState.push(tempNode);

        this.redoState.clear();

        // System.out.println(this.undoState);

        return true;
    }

    // private void copyTree(AVL tempTree, Node root){
    //     if(root != null){
    //         copyTree(tempTree,root.getLeft());
    //         tempTree.insert(root.getData());
    //         copyTree(tempTree,root.getRight());
    //     }
    // }

    // private Node copy(Node root){
    //     if(root == null){
    //         return null;
    //     }
    //     return new Node(root.getData(), copy(root.getLeft()), copy(root.getRight()));   
    // }

      private Node copy(Node root){
        if(root == null){
            return null;
        }
        Node temp = new  Node(root.getData());
        temp.setLeft(copy(root.getLeft()));
        temp.setRight(copy(root.getRight()));
        temp.setHeight(1 + Math.max(height(temp.getLeft()), height(temp.getRight())));
        return temp ;   
    }

    
    protected int height(Node node) {
        if (node == null)
            return -1;
        return node.getHeight();
    }


    // Requirement 2
    public Student searchStudentById(int id) {
        // code here
        if(tree == null){
            return null;
        }
        if(tree.contain(id)){
            return tree.search(id).getData();
        }else{
            return null;
        }
    }

    // Requirement 3
    public boolean removeStudent(int id) {
        // code here
        if(tree == null) return false;
        if(tree.contain(id)){
            Student tempStudent = searchStudentById(id);
            tree.delete(tempStudent);   
            // print(tree.getRoot());
            Node tempNode = copy(this.tree.getRoot());
            Node temp1 = copy(tempNode);
            this.undoState.push(temp1);

            this.redoState.clear();

        // System.out.println(this.undoState.size() + " delete");

            return true;
        }else{
            this.undoState.push(null);
            this.redoState.clear();
            return false;
        }
    }

    // Requirement 4
    public void undo() {
        // code here
        // print1();
        // System.println("================");

        if(this.undoState.isEmpty()){
            this.tree.setRoot(null);
        }else{
            // System.out.println(this.undoState);
            Node temp = this.undoState.pop();
            
            Node tempCopy = copy(temp);
            Node tempCopy1 = copy(tempCopy);
            this.redoState.push(tempCopy1);
            if(temp != null){
            if(this.undoState.isEmpty()){
                this.tree.setRoot(null);
            }else{
                Node temp1 = this.undoState.peek();
                // System.out.println();

                // print(temp1);
                // System.out.println();
                Node temp2 = copy(temp1);

                this.tree.setRoot(temp2);
            }
            }
            
        }

       
    }

    // Requirement 5
    public void redo() {
        // code here
        if(!this.redoState.isEmpty()){
            Node temp = this.redoState.pop();
            this.undoState.push(temp);
            if(temp != null){
                Node temp1 = copy(temp);
                Node temp12 = copy(temp1);
            this.tree.setRoot(temp12);
            }
        }
    }

    private int calculateHeight(Node root){
        if(root == null){
            return 0;
        } else{
            int left = 1 + calculateHeight(root.getLeft());
            int right = 1 + calculateHeight(root.getRight());
            return Math.max(left, right);
        }
    }

    // Requirement 6
    public ScoreAVL scoreTree(AVL treee) {
        // code here
        if(treee == null) return null;
        ScoreAVL scoreTree = new ScoreAVL();
        int height = calculateHeight(treee.getRoot());
        // System.out.println(height);
        chenTheoCapSearch(scoreTree,treee.getRoot(), height);
        return scoreTree;
    }

    private void chenTheoCapSearch(ScoreAVL treeGPA, Node temp, int chieucao){
        Node temp21 = copy(temp);
        // print(temp21);
        for(int i = 0; i <= chieucao; i++){
            chenTheoCap(treeGPA, temp21, i);
        }
    }

    // public void print(Node data){
    //     if(data !=  null){
    //         System.out.println(data.getData().toString());
    //         print(data.getLeft());
    //         print(data.getRight());
    //     }
    // }

    private void chenTheoCap(ScoreAVL treeGPA, Node root, int level){
        if(root == null){
            return;
        }
        if(level == 0){
            int id = root.getData().getId();
            String name = root.getData().getName();
            int gpa = root.getData().getGpa();
            Student newS = new  Student(id, name, gpa);
            // Node newNode = new Node(newS);
            treeGPA.insert(newS);
        }else if(level > 0){
            chenTheoCap(treeGPA, root.getLeft(),level-1);
            chenTheoCap(treeGPA, root.getRight(),level-1);
        }

    }

    
}
