package com.Rest_API.Service;

import com.Rest_API.Model.Employee;
import com.Rest_API.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
   private JdbcTemplate jdbcTemplate;

    public List<Employee> getEmployees()
    {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Employee addEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeeById(long id)
    {
        return (List<Employee>) employeeRepository.getById(id);
    }

    public void deleteEmployee(Employee employee)
    {
        employeeRepository.delete(employee);
    }

    public int update(Employee employee)
    {
        return jdbcTemplate.update("UPDATE employee_details SET Emp_name=?, Emp_salary=?, Emp_dept=? WHERE Emp_id=?",

                 new Object[]
                         { employee.getEmp_name(), employee.getEmp_salary(), employee.getEmp_dept() ,employee.getEmp_id()});
    }

    public int getSalary(Employee employee)
    {
        return jdbcTemplate.update("select * from employee_details WHERE Emp_id=?",
                new Object[]
                        { employee.getEmp_id()});

    }
    public long deleteByEmp_Id(long id)
    {
        return jdbcTemplate.update("DELETE FROM employee_details WHERE Emp_id=?", id);
    }

    public int deleteAll()
    {
        return jdbcTemplate.update("DELETE from employee_details");
    }
}
