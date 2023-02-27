/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author asus
 */
public class Department {
    protected int DepartmentId;
    protected String Name;
    protected int Budget;
    protected Date StartDate;
    protected int Adminisitrator;
    
    public Department(int DepartmentId, String Name, int Budget, Date StartDate, int Adminisitrator){
        this.DepartmentId = DepartmentId;
        this.Name = Name;
        this.Budget = Budget;
        this.StartDate = StartDate;
        this.Adminisitrator = Adminisitrator;
    }
    
    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int DepartmentId) {
        this.DepartmentId = DepartmentId;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public int getBudget() {
        return Budget;
    }

    public void setBudget(int Budget) {
        this.Budget = Budget;
    }
    
    public String getStartDate() {
        return StartDate.toString();
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }
    
    public int getAdminisitrator() {
        return Adminisitrator;
    }

    public void setAdminisitrator(int Adminisitrator) {
        this.Adminisitrator = Adminisitrator;
    }
}
