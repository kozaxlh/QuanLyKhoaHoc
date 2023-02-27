/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author asus
 */
public class CourseInstructor {
    protected int CourseID;
    protected int PersonID;
    public CourseInstructor(int CourseID, int PersonID){
        this.CourseID = CourseID;
        this.PersonID = PersonID;
    }
    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }
    public int getPersonId() {
        return PersonID;
    }

    public void setPersonId(int PersonID) {
        this.PersonID = PersonID;
    }
}
