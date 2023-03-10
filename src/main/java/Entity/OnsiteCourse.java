package Entity;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class OnsiteCourse extends Course {

    protected String Location;
    protected String Days;
    protected Date time;

    public OnsiteCourse(int CourseID, String Title, int Credits, int DepartmentId, String Location, String Days, Date time) {
        super(CourseID, Title, Credits, DepartmentId);
        this.Location = Location;
        this.Days = Days;
        this.time = time;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
