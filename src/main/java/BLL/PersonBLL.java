/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.PersonDAO;
import Entity.Person;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PersonBLL {
    private PersonDAO personDAO = new PersonDAO();

    
    public ArrayList<Person> getStudents() throws SQLException {
        return personDAO.getStudents();
    }
    
    public ArrayList<Person> getStudentsInCourse(int id) throws SQLException {
        return personDAO.getStudentsInCourse(id);
    }
    
    public ArrayList<Person> getInstructors() throws SQLException {
        return personDAO.getInstructors();
    }
    
    public Person getInstructor(int id) throws SQLException {
        return personDAO.getInstructor(id);
    }
}
