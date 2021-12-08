public class Date{
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        if(day >= 1 && day <= 31){
            if(month == 2){
                if(year % 400 == 0){
                    this.day = 29;
                }else{
                    this.day = 28;
                }
            }
            this.day = day;
        }

        if(month >= 1 && month <= 12){
            this.month = month;
        }

        if(year >= 1){
            this.year = year;
        }
    }

    public int getDay(){
        return this.day;
    }

    public void setDay(int x){
        if(x >= 1 && x <= 31){
            this.day = x;
        }
    }

    public int getMonth(){
        return this.month;
    }

    public void setMonth(int x){
        if(x >= 1 && x <= 12){
            this.month = x;
        }
    }

    public int getYear(){
        return this.year;
    }

    public void setYear(int x){
        if(x >= 1){
            this.year = x;
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.day + "/" + this.month + "/" + this.year;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
}