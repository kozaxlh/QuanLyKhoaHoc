/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author asus
 */
public class Course {
    protected int CourseID;
    protected String Title;
    protected int Credits;
    protected int DepartmentId;
    
    public Course(int CourseID, String Title, int Credits, int DepartmentId){
        this.CourseID = CourseID;
        this.Title = Title;
        this.Credits = Credits;
        this.DepartmentId = DepartmentId;
    }
    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }
    
    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
    
    public int getCredits() {
        return Credits;
    }
    
    public void setCredits(int Credits) {
        this.Credits = Credits;
    }
    
    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int DepartmentId) {
        this.DepartmentId = DepartmentId;
    }
}
