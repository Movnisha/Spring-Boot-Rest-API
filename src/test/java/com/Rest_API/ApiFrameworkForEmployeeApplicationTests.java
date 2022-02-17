package com.Rest_API;

import com.Rest_API.POJO.Employee;
import com.Rest_API.Repository.EmployeeRepository;
import com.Rest_API.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApiFrameworkForEmployeeApplicationTests
{

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void getAllEmployeesTest()
	{
		when(employeeRepository.findAll()).thenReturn(Stream
				.of(new Employee(1,"Ketty",10,"Accounts"),
						new Employee(2,"Perry",20,"Sales")).collect(Collectors.toList()));
		assertEquals(2,employeeService.getUsers().size());
	}

	@Test
	public void createEmployeeTest()
	{
		Employee employee= new Employee(3,"Styles",30,"Developer");
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee,employeeService.addEmployee(employee));
	}


}
