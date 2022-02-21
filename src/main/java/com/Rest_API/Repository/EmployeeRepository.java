package com.Rest_API.Repository;

import com.Rest_API.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
    //JPQL with named parameters
    @Query("SELECT e from Employee e where e.Emp_dept=:Emp_dept")
    List<Employee> findByEmp_dept(@Param("Emp_dept") String Emp_dept, Sort sort);


    @Query("select e from Employee e  where e.Emp_id = :Emp_id")
    List<Employee> findByEmp_id(@Param("Emp_id") long Emp_id);


}

