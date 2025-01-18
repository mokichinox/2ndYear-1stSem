public class MyDate {
    
    private int year, month, day;
    
    public MyDate(int year, int month, int day){
        
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public int getYear(){
        return year;
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getDay(){
        return day;
    }
    
    public void setYear(int year) {
        
        this.year = year;
    }

    public void setMonth(int month) {
        if (month > 12 || month <1){
            month = 1;
        }
        this.month = month;
    }

    public void setDay(int day) {
        switch(day){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31){
                   day = 1;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30){
                    day = 1;
                }
                break;
            case 2:
                if (day > 28){
                    day = 1;
                }
                break;
            default:
                day = 1;
                break;
        }
        this.day = day;
    }
    
    public String dateToString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
