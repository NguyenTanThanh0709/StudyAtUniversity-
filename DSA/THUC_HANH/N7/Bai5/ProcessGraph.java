import java.util.*;


public class ProcessGraph{

    

    
    public static void DFS(int v, Boolean[] visited, Graph graph){
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> ite = graph.getNode(v).listIterator();
        while (ite.hasNext()) {
        int adj = ite.next();
        if (!visited[adj])
            DFS(adj,visited ,graph);
        }
    }


    public static void DFSWithOutRES(int v, Boolean[] vistited, Graph graph){
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        vistited[v] = true;

        while(!stack.isEmpty()){
            int temp = stack.pop();
            System.out.print(temp + " ");
            Iterator<Integer> ite = graph.getNode(temp).listIterator();
            while(ite.hasNext()){
                int adj = ite.next();
                if(!vistited[adj]){
                    stack.add(adj);
                    vistited[adj] = true;
                }
            }
        }
    }
    
    public static void BFS(int v, Boolean[] vistited, Graph graph){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        vistited[v] = true; 

        while(!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp + " ");
            Iterator<Integer> ite = graph.getNode(temp).listIterator();
            while(ite.hasNext()){
                int adj = ite.next();
                if(!vistited[adj]){
                    queue.add(adj);
                    vistited[adj] = true;
                }
            }


        }
        }
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.loadFile("input.txt");
        graph.print();
        Boolean[] visited = new Boolean[graph.V];
        Arrays.fill(visited, Boolean.FALSE);
        int x = 4;
        DFS(x, visited, graph);
        Arrays.fill(visited, Boolean.FALSE);
        System.out.println();
        BFS(x, visited, graph);
    }
}