package practise.calendar1;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class Calendar1 {
    private GregorianCalendar cal;
    public Calendar1(int year, int month, int dayOfMonth)
    {
        Calendar cal = new GregorianCalendar(year, month, dayOfMonth);
    }
    public void setYearAndMonth(int year, int month, int dayOfMonth) {
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
    }

    public Date getTime() {
        return cal.getTime();
    }
    public void nextDay(){
        cal.add(Calendar.DAY_OF_MONTH, +1);
        //System.out.println("Date: " + cal.getTime());
    }
}
