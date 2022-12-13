package practise.clock;

public class Clock {
    private int time;
    private int day;

    /** Creates new clock with time 00:00 and day 1 */
    public Clock(){
        this.time=0;
        this.day=1;
    }

    /** Creates new clock with specified time (time must be within bounds for one day)
     *  and day
     * @param hour Amount of full hours since 00:00
     * @param minute Amount of full minutes since last full hour
     * @param day Number of day since practise opening (first day means value 1)
     */
    public Clock(int hour, int minute,int day){
        if (((hour*60+minute)<1440)&&((hour*60+minute)>=0)){this.time=hour*60+minute;}
        if (day>=1){this.day=day;}
    }

    /** Advances the time, advances the day as well if time would be advanced beyond 23:59
     *
     * @param minutes Amount of minutes to advance the time by
     */
    public void advanceTime(int minutes){
        if (minutes>0){
            time=(time+minutes)%1440;
            day=day+((time+minutes)/1440);
        }
    }

    /** Returns formatted time
     *
     * @return Time in hour:minute format
     */
    public String getTimeFormatted(){
        return time/60+":"+time%60;
    }

    /** Returns unformatted time
     *
     * @return Time as amount of minutes since 00:00
     */
    public int getTime() {
        return time;
    }

    public int getDay() {
        return day;
    }
}