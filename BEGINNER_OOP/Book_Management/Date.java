public class Date{
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay(){
        return this.day;
    }

    public void setDay(int day){
        if(day >= 1 && day <= 31){
            this.day = day;
        }
    }

    public int getMonth(){
        return this.month;
    }

    public void setMonth(int moth){
        if(month >= 1 && day <= 12){
            this.month = month;
        }
    }
    
    public int getYear(){
        return this.year;
    }

    public void setYear(int year){
        if(year >= 1000){
            this.year = year;
        }
    }
}