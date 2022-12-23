public class IntegerTriple{
    Integer weight;
    Integer source;
    Integer dest;

    public IntegerTriple(Integer w, Integer s, Integer d){
        weight = w;
        source = s;
        dest = d;
    }

    @Override
    public String toString(){
        return this.weight + ", " + this.source + ", " + this.dest;
    }
}