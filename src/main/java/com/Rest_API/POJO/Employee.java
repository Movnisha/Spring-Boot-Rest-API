package com.Rest_API.POJO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="EmployeeDetails")
public class Employee
{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private long Emp_id;

    @Column(name = "Emp_name")
    private String Emp_name;

    @Column(name = "Emp_salary")
    private int Emp_salary;

    @Column(name = "Emp_dept")
    private String Emp_dept;

}
