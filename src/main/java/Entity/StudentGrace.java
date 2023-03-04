/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author asus
 */
public class StudentGrace {
    protected int EnrollmentID;
    protected int CourseID;
    protected int StudentID;
    protected float Grace;
    
    
    public StudentGrace(int EnrollmentID, int CourseID, int StudentID, float Grace){
        this.EnrollmentID = EnrollmentID;
        this.CourseID = CourseID;
        this.StudentID = StudentID;
        this.Grace = Grace;
    }
    public int getEnrollmentID() {
        return EnrollmentID;
    }

    public void setEnrollmentID(int EnrollmentID) {
        this.EnrollmentID = EnrollmentID;
    }
    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }
    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }
    public float getGrace() {
        return Grace;
    }

    public void setGrace(int Grace) {
        this.Grace = Grace;
    }
}
