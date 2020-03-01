/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comtroller;

import dao.impl.EmployeeRepository;
import java.util.List;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.EmployeeService;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<model.Employee> getAllEmployees() {
        return employeeService.listEmployees();
    }

    @RequestMapping("/add_employee_form")
    public String showform(Model m) {
        m.addAttribute("command", new Employee());
        return "add_employee_form";
    }

    @RequestMapping(value = "/add_employee", method = RequestMethod.POST)
    public String addEmployee(ModelMap model,
            @ModelAttribute("emp") Employee employee
    ) {
        System.out.println(employee.getName());

        boolean success = false;

        try {
            success = employeeService.addEmployee(employee);
        } catch (Exception e) {
            model.addAttribute("failed_message", "Employee Add failed !");
            return "message";
        }

        model.addAttribute("success_message", "Employee Addedd successfully !");

        return "message";

    }

    @RequestMapping(value = "/list_employees", method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
        List<Employee> employees = employeeService.listEmployees();
        model.addAttribute("list", employees);

        return "list_employee";
    }

}
