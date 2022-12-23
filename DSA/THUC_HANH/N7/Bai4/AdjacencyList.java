
import java.util.*;
public class AdjacencyList {
    int V;
    ArrayList<LinkedList<Integer>> list;

    public AdjacencyList(int v){
        V = v;
        list = new ArrayList<LinkedList<Integer>>();
        for(int i = 0; i < v; i++){
            list.add(new LinkedList<Integer>());
        }
    }

    public void addEdege(int u, int v){
        list.get(u).add(v);
    }

    public void printGraph(){
         for(int i = 0; i < V; i++){
         System.out.print("Vertex " + i + ": ");
         System.out.print("head");
         for(Integer v: list.get(i)){
         System.out.print("->" + v);
         }
         System.out.println();
         }
         }
}
