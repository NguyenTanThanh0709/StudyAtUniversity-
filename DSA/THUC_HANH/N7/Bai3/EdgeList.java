import java.util.Vector;
import java.io.*;
import java.util.*;

public class EdgeList {
    Vector<IntegerTriple> edges;
    
    public EdgeList(){
        edges = new Vector <IntegerTriple >();
    }

    public void addEdge(int w, int s, int d){
        edges.add(new IntegerTriple(w,s,d));
    }

    public void printGraph(){
        for(int i = 0; i < edges.size(); i++){
            System.out.println(edges.get(i));
        }
    }

    public void loadFile(String filepath){
        String data = "";
        try {
            FileReader reader = new FileReader(filepath);
            BufferedReader fReader = new BufferedReader(reader);

            while ((data = fReader.readLine()) != null) {
                String[] tempData = data.trim().split(" ");
                edges.add(new IntegerTriple(Integer.parseInt(tempData[0]), Integer.parseInt(tempData[1]), Integer.parseInt(tempData[2])));
            }

            fReader.close();
            reader.close();

        } catch (Exception e) {
            System.out.println("Cannot load file");
        }
    }

    public boolean writeFile(String filepath){

        try {
            FileWriter writer = new FileWriter(filepath);
            for (IntegerTriple tmp : edges) {
                writer.write(tmp.toString());
                writer.write("\r\n");
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error.");
            return false;
        }

        return true;

    }

    public boolean checkExits(int u, int v){
        for (IntegerTriple integerTriple : edges) {
            if(u == integerTriple.source && v == integerTriple.dest){
                return true;
            }
            if(v == integerTriple.source && u == integerTriple.dest){
                return true;
            }

        }
        return false;
    }

    public int countVertices(){
        Set example = new LinkedHashSet();
        for (IntegerTriple object : edges) {
            example.add(object.source);
            example.add(object.dest);
        }
        return example.size();
    }

    public void ListNeighbors(int u){
        // Set example = new LinkedHashSet();
        for (IntegerTriple object : edges) {
            if(object.dest == u){
                System.out.print( " " + object.source + " ");
            }else if(object.source == u){
                System.out.print( " " + object.dest + " ");
            }
        }
        // return example.size();
    }


    public int countEdges(){
        return edges.size();
    }
}
