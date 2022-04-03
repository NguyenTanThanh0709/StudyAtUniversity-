public class Club {
    
    private String name;
    private int wins;
    private int draws;
    private int losses;

    public Club(String name, int wins, int draws, int losses) {
        this.name = name;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    public Club(){
        this.name = "";
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
    }

    public Club (Club c){
        this.name = c.name;
        this.wins = c.wins;
        this.draws = c.draws;
        this.losses = c.losses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int numMatchesPlayed(){
        return this.wins + this.draws + this.losses;
    }

    public boolean isFinish(){
        if(this.wins + this.draws + this.losses == 10){
            return true;
        }
        return false;
    }

    public int getPoints(){
        return this.wins * 3 + this.draws;
    }

    @Override
    public String toString(){
        return this.name + " " + this.wins + " " + this.draws + " " + this.losses;
    }
}
