package Entity;

import java.sql.Time;

/**
 *
 * @author ASUS
 */
public class OnsiteCourse extends Course {

    protected String Location;
    protected String Days;
    protected Time time;

    public OnsiteCourse(int CourseID, String Title, int Credits, int DepartmentId, String Location, String Days, Time time) {
        super(CourseID, Title, Credits, DepartmentId);
        this.Location = Location;
        this.Days = Days;
        this.time = time;
    }

    public OnsiteCourse() {
    }


    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String Days) {
        this.Days = Days;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    public void setTime(String time) {
        this.time = Time.valueOf(time);
    }
}
