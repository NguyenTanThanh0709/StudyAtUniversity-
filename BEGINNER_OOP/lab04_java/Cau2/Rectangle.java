public class Rectangle {
    private float width;
    private float length;

    public Rectangle(float width, float length){
        this.width = width;
        this.length = length;
    }

    public float getWidth(){
        return this.width;
    }

    public void setWidth(float width){
        this.width = width;
    }

    public float getLength(){
        return this.length;
    }

    public void setLenght(float Length){
        this.length = Length;
    }

    @Override
    public String toString(){
        return "width : " + this.width + "\nlength : " + this.length;
    }

}
