/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import courseEnum.PersonEnum;
import java.sql.Date;

/**
 *
 * @author asus
 */
public class OnlineCourse extends Course {

    protected String URL;

    public OnlineCourse(int CourseID, String Title, int Credits, int DepartmentId, String URL) {
        super(CourseID, Title, Credits, DepartmentId);
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    
}
