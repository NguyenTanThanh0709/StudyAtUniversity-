package ClassWork.Bai2;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static double distance(List<Point> listPoint){
        int x1 = listPoint.get(0).getX();
        int y1 = listPoint.get(0).getY();

        int x2 = listPoint.get(1).getX();
        int y2 = listPoint.get(1).getY();

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    public static void main(String[] args) {
        List<Point> listPoint = new ArrayList<>();
        listPoint.add(new Point(1,2));
        listPoint.add(new Point(3,4));

        System.out.println(distance(listPoint));

    }
}
