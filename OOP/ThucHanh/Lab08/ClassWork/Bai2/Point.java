package ClassWork.Bai2;

public class Point {
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
}
