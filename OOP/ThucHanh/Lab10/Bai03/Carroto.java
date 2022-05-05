public class Carroto implements Vegetable{
    private String type;

    public Carroto(String type) {
        this.type = type;
    }

    public Carroto() {
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String getInFo() {
        // TODO Auto-generated method stub
        return this.type;
    }
    
}
