package com.Rest_API.Repository;

import com.Rest_API.Model.Employee;
import com.Rest_API.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeRepositoryTest
{

    @MockBean
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;


    @Test
    void findByEmp_dept()
    {

    }

    @Test
    void findByEmp_id()
    {
        when(employeeRepository.findByEmp_id(1)).thenReturn(Stream.
                of(new Employee(1,"Harry",45000,"sales")).collect(Collectors.toList()));
        assertEquals(1,employeeService.getEmployees().size());
    }
}