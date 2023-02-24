/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import courseEnum.PersonEnum;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Person {

    protected int id;
    protected String firstName;
    protected String lastName;
    protected Date hireDate;
    protected Date enrollmentDate;

    public Person(int id, String firstName, String lastName, Date date, PersonEnum type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        if (type == PersonEnum.INSTRUCTOR) {
            this.hireDate = date;
        }
        if (type == PersonEnum.STUDENT) {
            this.enrollmentDate = date;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHireDate() {
        return hireDate.toString();
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getEnrollmentDate() {
        return enrollmentDate.toString();
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getName(){
        return this.firstName + " " + this.lastName; 
    } 
}
