package com.Rest_API.Controller;

import com.Rest_API.Model.Employee;
import com.Rest_API.Repository.EmployeeRepository;
import com.Rest_API.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeControllerTest
{
    @MockBean
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @Test
    void getAllEmployees()
    {
        when(employeeRepository.findAll()).thenReturn(Stream
                .of(new Employee(1, "Danile", 31000, "sales"), new Employee(2, "Huffy", 35000, "IT")).collect(Collectors.toList()));
        assertEquals(2, employeeService.getEmployees().size());
    }

    @Test
    void createEmployee()
    {
        Employee employee = new Employee(9, "Pranya", 33000, "Accounts");
        when(employeeRepository.save(employee)).thenReturn(employee);
        assertEquals(employee, employeeService.addEmployee(employee));

    }

    @Test
    void getEmployeeById()
    {
//        long id = 10;
//        when(employeeRepository.findById(id))
//                .thenReturn(Stream.of(new Employee(10, "Danny", 45000, "Software")).collect(Collectors.toList()));
//        assertEquals(1, employeeService.getUserbyAddress(address).size());
    }


    @Test
    void deleteAllEmployees()
    {
        Employee employee = new Employee(19, "Prethu", 43000, "IT");
        employeeService.deleteEmployee(employee);
        verify(employeeRepository,times(1)).delete(employee);

    }
}