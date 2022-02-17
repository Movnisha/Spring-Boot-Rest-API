# Spring Boot REST API 


A Rest API to perform the basic operations upon the Employee database (Oracle) such as retrieving, inserting, updating and deleting data.Also to handle the exceptions during REST Calls and Junits to test the code.

## Features

- Create employee(Emp ID, Name, Salary, Department) 
- List all employees
- Fetch single employee by id
- Fetch salary of single employee
- Fetch employees with particular Department in Ascending order (EMPLOYEE ID) 
- Update employee by id
- Upate salary of employee
- Delete employee by id
- Delete all the employees

## API Reference

We will create a Employee REST API, following are the rest end points

### Get all employees

```http
  GET http://localhost:8090/employees
```
#### Sample Response

```json
  [
    {
        "emp_id": 1,
        "emp_name": "Bushan",
        "emp_salary": 50000,
        "emp_dept": "IT"
    },
    {
        "emp_id": 2,
        "emp_name": "Bharath",
        "emp_salary": 39000,
        "emp_dept": "Sales"
    },
    {
        "emp_id": 3,
        "emp_name": "Chaitra",
        "emp_salary": 45000,
        "emp_deptt": "IT"
    }
]
```
### Get single employee 

```http
  GET http://localhost:8090/employees/id/1
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of employee to fetch |

#### Sample Response

```json
 {
        "emp_id": 1,
        "emp_name": "Bushan",
        "emp_salary": 50000,
        "emp_dept": "IT"
  }
```

### Save employee

```http
  POST http://localhost:8090/employees
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `employee reference`      | `Employee` | **Required**. Request body of employee |

#### Sample Request

```json
{
        
        "emp_name": "Mark",
        "emp_salary": 63000,
        "emp_dept": "Accounting"
 }
```
 ### Update employee

```http
  PUT http://localhost:8090/employees/3
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of employee to update |
| `employee reference`      | `Employee` | **Required**. Request body of employee |

#### Sample Request

```json
{
    "emp_name": "Chaitra",
    "emp_salary": 45000,
    "emp_deptt": "Banking"
}
``` 

### Fetch employees with particular Department in Ascending order (EMPLOYEE ID) 

```http
  GET http://localhost:8090/employees/dept/IT
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `dept`      | `string` | **Required**. Dept of employee to fetch |

```json
  [
    {
        "emp_id": 1,
        "emp_name": "Bushan",
        "emp_salary": 50000,
        "emp_dept": "IT"
    },
  
    {
        "emp_id": 3,
        "emp_name": "Chaitra",
        "emp_salary": 45000,
        "emp_deptt": "IT"
    }
]
```
### Delete employee by ID

```http
  DELETE http://localhost:8090/employees/id/4
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of employee to delete |

#### Sample Response
Employee was deleted successfully.
  
### Delete all employee 

```http
  DELETE http://localhost:8090/employees/delete/all
```
#### Sample Response
Deleted 3 Employee's Record successfully.
  

