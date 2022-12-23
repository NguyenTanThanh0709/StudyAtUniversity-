

public class test {
    public static void main(String[] args) {
        EdgeList edges = new EdgeList();
        edges.loadFile("text.txt");
        edges.printGraph();
        edges.writeFile("output.txt");
        System.out.println(edges.countVertices());
        edges.ListNeighbors(2);
    }
}
