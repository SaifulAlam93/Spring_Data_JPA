/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class EmployeeDaoImpl  {
    


    // =================== DB ===================
    public Employee getEmployeeByIdFromDB(String empId) {
        Employee employee = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            conn = DBConnection.getConnection();

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM employee where empId=" + empId;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {

                employee = new Employee();
                employee.setAddress(rs.getString("address"));
                employee.setEmpId(rs.getString("empId"));
                employee.setName(rs.getString("name"));
                employee.setSalary(rs.getDouble("salary"));

            }
        } catch (SQLException se) {

            se.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return employee;
    }

    public boolean insertEmployeeInToDB(Employee employee) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        boolean successfullyInserted = false;

        try {

            conn = DBConnection.getConnection();

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "insert into employee (empId,name,address,salary) values('" + employee.getEmpId() + "','" + employee.getName() + "','" + employee.getAddress() + "'," + employee.getSalary() + " ) ";
            int count = stmt.executeUpdate(sql);

            if (count > 0) {
                successfullyInserted = true;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return successfullyInserted;
    }

    public boolean updateEmployeeInDB(Employee employee) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        boolean successfullyInserted = false;

        try {

            conn = DBConnection.getConnection();

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "update employee set name='" + employee.getName() + "',address='" + employee.getAddress() + "',salary=" + employee.getSalary() + " where empId= '" + employee.getEmpId() + "'";
            int count = stmt.executeUpdate(sql);

            if (count > 0) {
                successfullyInserted = true;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return successfullyInserted;

    }

    public boolean removeEmployeeFromDB(Employee employee) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        boolean successfullyInserted = false;

        try {

            conn = DBConnection.getConnection();

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "delete from employee  where empId= '" + employee.getEmpId() + "'";
            int count = stmt.executeUpdate(sql);

            if (count > 0) {
                successfullyInserted = true;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return successfullyInserted;

    }

    public List<Employee> getAllEmployeeFromDB() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Employee> employees = new ArrayList<>();

        try {

            conn = DBConnection.getConnection();

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM employee";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Employee employee = new Employee();
                employee.setAddress(rs.getString("address"));
                employee.setEmpId(rs.getString("empId"));
                employee.setName(rs.getString("name"));
                employee.setSalary(rs.getDouble("salary"));
                employees.add(employee);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return employees;
    }

    public List<Employee> getEmployeesByNameFromDB(String name) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Employee> employees = new ArrayList<>();

        try {

            conn = DBConnection.getConnection();

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM employee where name like '%" + name + "%' ";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Employee employee = new Employee();
                employee.setAddress(rs.getString("address"));
                employee.setEmpId(rs.getString("empId"));
                employee.setName(rs.getString("name"));
                employee.setSalary(rs.getDouble("salary"));
                employees.add(employee);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return employees;
    }

    public double countTotalSalaryFromDB() {
        Employee employee = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        double totalSalary = 0.0;

        try {

            conn = DBConnection.getConnection();

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "select sum(salary) from employee ";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String sum = rs.getString(1);
                totalSalary = Double.parseDouble(sum);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return totalSalary;
    }

}
