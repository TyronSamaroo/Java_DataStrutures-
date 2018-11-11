public class Date {

    public int year,month,day;


    public Date(){
        year = 0;
        month = 0;
        day = 0;
    }
    public Date(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    };

    public Date(String temp){
        String input = temp;
        this.year = Integer.valueOf(input.substring(0,4));
        this.month = Integer.valueOf(input.substring(4,6));
        this.day = Integer.valueOf(input.substring(6,7));
    }

    public void setYear(int year) {
        this.year = year;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    @Override
    public String toString() {
        return "The year is " + year + " " + "Month is " + month + " " + "Day is " + day + "";
    }

    public static void main(String[] args) {
        Date x = new Date();
        Date y = new Date(2001,10,5);
        Date z = new Date("2008105");

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

    }
}

