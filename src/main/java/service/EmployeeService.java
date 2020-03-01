/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.impl.EmployeeRepository;
import java.util.List;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class EmployeeService {
    
    
//    @Autowired
//    EmployeeDaoImpl employeeDaoImpl;
    
    
    
    @Autowired
    private EmployeeRepository repository;
    
    public boolean addEmployee(Employee employee) throws Exception {

        boolean success = false;


        employee = repository.save(employee);

        return employee!=null;
    }

    public boolean editEmployee(Employee employee) throws Exception {
        boolean success = false;
        if (repository.existsById(employee.getId())) {
            throw new Exception("Employee Id : " + employee.getEmpId() + " not found !");
        }
        employee = repository.save(employee);

        return success;
    }

    public boolean deleteEmployee(long employeeID) throws Exception {
        boolean success = false;

        Employee employee_old;

        repository.deleteById(employeeID);

       return true;

    }

    public List<Employee> listEmployees() {
        System.out.println("==== result =====");

        List<Employee> employees = repository.findAll();

        return employees;

//        for (Employee employee : employees) {
//            System.out.println("employee id : " + employee.getEmpId());
//            System.out.println("employee name : " + employee.getName());
//            System.out.println("employee address : " + employee.getAddress());
//            System.out.println("employee salary : " + employee.getSalary());
//            System.out.println("===================================");
//        }
    }

//    public List<Employee> searchEmployees(String searchParameter) {
//
//        List<Employee> employees = employeeDaoImpl.getEmployeesByNameFromDB(searchParameter);
//
////        System.out.println("==== result =====");
////
////        for (Employee employee : employees) {
////
////            System.out.println("employee id : " + employee.getEmpId());
////            System.out.println("employee name : " + employee.getName());
////            System.out.println("employee address : " + employee.getAddress());
////            System.out.println("employee salary : " + employee.getSalary());
////            System.out.println("===================================");
////
////        }
//        return employees;
//    }

//    public double totalSalary() {
//
//        double totalSalary = employeeDaoImpl.countTotalSalaryFromDB();
//
//        return totalSalary;
//
//    }

//    private boolean checkIfEmployeeAlreadyExists(String employeeId) {
//
//        boolean employeeAlreadyExists = false;
//
//        Employee employee = null;
//
//        employee = employeeDaoImpl.getEmployeeByIdFromDB(employeeId);
//
//        if (employee != null) {
//
//            employeeAlreadyExists = true;
//        }
//
//        return employeeAlreadyExists;
//    }

   
}
