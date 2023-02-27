/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Person;
import courseEnum.PersonEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PersonDAO extends DBConnection {

    public PersonDAO() {
        super();
        this.connectDB();
    }
    
    public ArrayList<Person> getStudents() throws SQLException {
        ArrayList<Person> studentList = new ArrayList<Person>();
        
        String sql = "SELECT * FROM Person WHERE EnrollmentDate > 0";
        ResultSet rs = this.doReadQuery(sql);
        while(rs.next()) {
            Person student = new Person(
                    rs.getInt("PersonId"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getDate("EnrollmentDate"),
                    PersonEnum.STUDENT
                );
            studentList.add(student);
        }
        return studentList;
    }
    
    public ArrayList<Person> getStudentsInCourse(int id) throws SQLException {
        ArrayList<Person> studentList = new ArrayList<Person>();
        
        String sql = "SELECT * FROM Person "
                + "JOIN StudentGrace ON Person.PersonID = StudentGrace.StudentID "
                + "WHERE EnrollmentDate > 0 AND CourseID = ?";
        
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Person student = new Person(
                    rs.getInt("PersonId"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getDate("EnrollmentDate"),
                    PersonEnum.STUDENT
                );
            studentList.add(student);
        }
        return studentList;
    }
    
    public ArrayList<Person> getInstructors() throws SQLException {
        ArrayList<Person> instructorList = new ArrayList<Person>();
        
        String sql = "SELECT * FROM Person WHERE HireDate > 0";
        ResultSet rs = this.doReadQuery(sql);
        while(rs.next()) {
            Person instructor = new Person(
                    rs.getInt("PersonId"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getDate("HireDate"),
                    PersonEnum.INSTRUCTOR
                );
            instructorList.add(instructor);
        }
        return instructorList;
    }
    
    public Person getInstructor(int id) throws SQLException {
        String sql = "SELECT * FROM Person WHERE HireDate > 0 AND id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Person instructor = new Person(
                    rs.getInt("PersonId"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getDate("HireDate"),
                    PersonEnum.INSTRUCTOR
                );
            return instructor;
        }
        return null;
    }
}
