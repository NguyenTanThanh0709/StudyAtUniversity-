import java.util.*;

public class Edge  implements Comparator<Edge>{
    public int start;
    public int end;
    public int weight;

    public Edge(){
        this.weight = -1;
    }

    public Edge(int s, int e, int w){
        start = s;
        end= e;
        weight = w;
    }

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight- o2.weight;
    }
}