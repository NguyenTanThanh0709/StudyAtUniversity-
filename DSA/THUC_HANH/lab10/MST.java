import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class MST{
    int[] parent;
    int[] size;
    Vector<Edge> MST;
    boolean[] visted;
    int m;
    int n;

    public MST(int m, int n){
        this.m = m;
        this.n = n;
        parent = new int[n];
        size = new int[n];
        MST = new Vector<Edge>(m);
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 0;
            }
    }

    public void make_set(int n){
        make_set(n, this.parent, this.size);
    }



    private  void make_set(int n, int[] parent, int[] size){
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 0;
        }
    }

    public int find(int v){
        return find(v, this.parent);
    }

    private  int find(int v, int[] parent){
        if(v == parent[v]){
            return v; 
        }else{
            return parent[v] = find(parent[v], parent);
        }
    }


    public boolean union(int a, int b){
        return  union(a, b, this.parent, this.size);
    }

    private boolean isSameFind(int a, int b){
        return find(a) == find(b); 
    }



    private  boolean union(int a, int b, int[] parent, int[] size){
        a = find(a, parent);
        b = find(b, parent);
        if(a ==b){
        return false;
        }
        if(size[a] < size[b]){
        int tem =a;
        a= b;
        b = tem;
        }
        parent[b] = a;
        size[a] += size[b];
        return true;
    }

    public  void loadFile(String filepath){
        String data = "";
        try {
            FileReader reader = new FileReader(filepath);
            BufferedReader fReader = new BufferedReader(reader);
            data = fReader.readLine();
            String[] tempData1 = data.trim().split(" ");
            int m = Integer.parseInt(tempData1[0]);
            int n = Integer.parseInt(tempData1[1]);
            
            while ((data = fReader.readLine()) != null) {
                String[] tempData = data.trim().split(" ");
                Edge newEdge = new Edge(Integer.parseInt(tempData[1]),Integer.parseInt(tempData[2]),Integer.parseInt(tempData[0]));
                MST.add(newEdge);
            }

            fReader.close();
            reader.close();
            
        } catch (Exception e) {
            System.out.println("Cannot load file");
            
        }
    }

    public void print(){
        for(int i = 0; i <m; i++){
            System.out.println(MST.get(i).weight + " " + MST.get(i).start + " " + MST.get(i).end);
        }
    }

    public void sort(){
        sort(this.MST);
    }


    private  void sort( Vector<Edge> itemLocationList) {
        Collections.sort(itemLocationList, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight- o2.weight;
            }        
        });
    }



    /**
     * 
     */
    public void kruskal(){
        Vector<Edge> mst = new Vector<Edge>();
        int d = 0;
        this.sort();
        for(int i = 0; i < this.m; i++){
            if(mst.size() == this.n -1 ){
                break;
            }
            Edge e = this.MST.get(i);
            if(union(e.start, e.end)){
                 mst.add(e);
                 d += e.weight;
            }
        }

        if(mst.size() != n-1){
             System.out.println("do thi khong lien thong");
        }else{
            for (Edge edge : mst) {
                System.out.println(edge.weight + " " + edge.start + " " + edge.end);
            }
            System.out.println(d);

        }

    }

    public void Prim(int v){
       
    }

}