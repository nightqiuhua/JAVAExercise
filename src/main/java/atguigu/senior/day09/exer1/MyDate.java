package atguigu.senior.day09.exer1;

public class MyDate implements Comparable{
    private int year;
    private int month;
    private int day;

    public MyDate(){}

    public MyDate(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof  MyDate){
            MyDate m = (MyDate)o;

            //比较年
            int minusYear = this.getYear() - m.getYear();
            if(minusYear != 0){
                return minusYear;
            }

            //比较月
            int minusMonth = this.getMonth() - m.getMonth();
            if(minusMonth != 0){
                return minusMonth;
            }

            //比较日
            return this.getDay() - m.getDay();

        }
        throw new RuntimeException("传入的数据类型不一致！");
    }
}