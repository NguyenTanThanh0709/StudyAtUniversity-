import java.io.*;
import java.util.*;

public class Graph {
    ArrayList<ArrayList<Integer>> graph;
    int V;

    public Graph(int nodes){
        V =nodes;
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<Integer>());
        }
    }

    public Graph(){
        graph = new ArrayList<ArrayList<Integer>>();
        this.V = 0;
    }

    public void setV(int nodes){
        V =nodes;
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<Integer> getNode(int i){
        return graph.get(i);
    }

    public void addEdege(int V, int U){
        graph.get(V).add(U);
    }

    public  void loadFile(String filepath){
        String data = "";
        try {
            FileReader reader = new FileReader(filepath);
            BufferedReader fReader = new BufferedReader(reader);
            int V = Integer.parseInt(fReader.readLine());
            this.setV(V);
            while ((data = fReader.readLine()) != null) {
                String[] tempData = data.trim().split(" ");
                for(int i = 1; i < tempData.length; i++){
                    this.addEdege(Integer.parseInt(tempData[0]),Integer.parseInt(tempData[i]));
                }
            }

            fReader.close();
            reader.close();
            

        } catch (Exception e) {
            System.out.println("Cannot load file");
            graph = null;
        }
    }

    public void print(){
        for(int i = 0; i < V; i++){
            System.out.print("Node " + i +": ");
            for (Integer arrayList : graph.get(i)) {
                System.out.print(" --> " + arrayList);
            }
            System.out.println();
        }
    }
}
