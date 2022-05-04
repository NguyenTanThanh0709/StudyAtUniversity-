package HomeWork.bai2;

import java.util.Vector;

public class TestVectorWithPoint {

    public static void getFx(Vector<Integer> v){
        double fx = 0;
        for (int i = 0; i < v.size(); i++) {
            fx +=  2*(v.get(i) * v.get(i)) + 1;
            System.out.println(fx);
        }
        
    }
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();

        v.add(2);
        v.add(3);
        v.add(4);
        v.add(5);

        getFx(v);

    }
}
