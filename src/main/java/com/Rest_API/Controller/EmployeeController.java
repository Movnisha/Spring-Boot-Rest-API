package com.Rest_API.Controller;


import com.Rest_API.Exception.ResourceNotFoundException;
import com.Rest_API.POJO.Employee;
import com.Rest_API.Repository.EmployeeRepository;
import com.Rest_API.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("employees")
public class EmployeeController
{
    @Autowired
    private EmployeeRepository employeeRepository;


    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public List<Employee> getAllEmployees()
    {

        return employeeRepository.findAll();
    }



    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  long id)
    {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    //get salary of single employee
    @GetMapping("/salary/{id}")
    public List<Employee> findByEmp_id(@PathVariable("id") long id)
    {
        return employeeRepository.findByEmp_id(id);

    }

   // Display Employees with particular Department in Ascending order (EMPLOYEE ID)
    @GetMapping("/dept/{dept}")
    public List<Employee> findByEmp_dept(@PathVariable("dept") String Emp_dept)
    {
        return employeeRepository.findByEmp_dept(Emp_dept, Sort.by("Emp_id").ascending());

    }

    //Update salary of Employee
    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateEmployeeSalary(@PathVariable("id") long id,@RequestBody Employee employeeDetails)
    {
        List<Employee> employee = employeeRepository.findByEmp_id(id);

        if (employee != null)
        {

            Employee updateEmployeeSalary = employeeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

            updateEmployeeSalary.setEmp_name(employeeDetails.getEmp_name());
            updateEmployeeSalary.setEmp_salary(employeeDetails.getEmp_salary());
            updateEmployeeSalary.setEmp_dept(employeeDetails.getEmp_dept());

            employeeService.update(updateEmployeeSalary);
            return new ResponseEntity<>("Employee salary was updated successfully.", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Cannot find employee with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    //Update Employee Details
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setEmp_name(employeeDetails.getEmp_name());
        updateEmployee.setEmp_salary(employeeDetails.getEmp_salary());
        updateEmployee.setEmp_dept(employeeDetails.getEmp_dept());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }


    //Delete Employee by id
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteTutorial(@PathVariable("id") long id)
    {
        try
        {
            long result = employeeService.deleteByEmp_Id(id);
            if (result == 0)
            {
                return new ResponseEntity<>("Cannot find Employee with id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Employee was deleted successfully.", HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Cannot delete Employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Delete all Employee Records
    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllEmployees()
    {
        try
        {
            int numRows = employeeService.deleteAll();
            return new ResponseEntity<>("Deleted " + numRows + " Employee's Record successfully.", HttpStatus.OK);
        } catch (Exception e)
        {
            return new ResponseEntity<>("Cannot Employee's Record", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
