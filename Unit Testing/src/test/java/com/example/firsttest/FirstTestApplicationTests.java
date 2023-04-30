package com.example.firsttest;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Import(FirstTestApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional(readOnly = false)
@EnableTransactionManagement
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase
@Rollback(false)
@SpringBootTest
class FirstTestApplicationTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }

    private Employee employee;

    @BeforeEach
    public void init() {
        employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail,com")
                .build();
    }

    //Test for save employee operation
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){
        Employee employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Ramesh")
                .email("ramesh@gmail,com")
                .build();
        //Act
        Employee savedEmployee = employeeRepository.save(employee);
        //Assertion
        org.assertj.core.api.Assertions.assertThat(savedEmployee).isNotNull();
        org.assertj.core.api.Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    //Test for deleteAll employee operation
    @Test
    public void givenEmployeeObject_whenDeleteAll_thenRemoveEmployee() {
        employeeRepository.save(employee);
        //Act
        employeeRepository.deleteAll();
        List<Employee> employeeList = employeeRepository.findAll();
        //Assertion
        org.assertj.core.api.Assertions.assertThat(employeeList).isNotNull();
        //org.assertj.core.api.Assertions.assertThat(employeeList.size()).isEqualTo(0);
        Assertions.assertEquals(employeeList.size(),0);
    }

    //Test for get all employees operation
    @Test
    public void givenEmployeesList_whenFindAll_thenEmployeesList() {
        Employee employee1 = Employee.builder()
                .firstName("John")
                .lastName("Cena")
                .email("cena@gmail,com")
                .build();

        employeeRepository.save(employee);
        employeeRepository.save(employee1);

        //Act
        List<Employee> employeeList = employeeRepository.findAll();
        //Assertion
        org.assertj.core.api.Assertions.assertThat(employeeList).isNotNull();
        org.assertj.core.api.Assertions.assertThat(employeeList.size()).isEqualTo(3);

    }

    //Test for get employee by id operation
    @Test
    public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject(){
        employeeRepository.save(employee);
        Optional<Employee> getEmployee = employeeRepository.findById(employee.getId());
        org.assertj.core.api.Assertions.assertThat(getEmployee).isNotNull();
    }

    //Test for deleteById employee operation
    @Test
    public void givenEmployeeObject_whenDeleteById_thenRemoveEmployee() {
        employeeRepository.save(employee);
        //Act
        employeeRepository.deleteById(employee.getId());
        List<Employee> employeeList = employeeRepository.findAll();
        //Assertion
        org.assertj.core.api.Assertions.assertThat(employeeList.size()).isEqualTo(3);
    }

    //Test for deleteById employee operation-IsEmpty
    @Test
    public void givenEmployeeObject_whenDeleteById_thenRemoveEmployeeIsEmpty() {
        employeeRepository.save(employee);
        //Act
        employeeRepository.deleteById(employee.getId());
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());
        //Assertion
        org.assertj.core.api.Assertions.assertThat(employeeOptional).isEmpty();
    }


    //Test for update employee operation
    @Test
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee(){
        employeeRepository.save(employee);
        //Act
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        savedEmployee.setEmail("maryam@gmail.com");
        savedEmployee.setFirstName("maryam");
        Employee updateEmployee=employeeRepository.save(savedEmployee);
        //Assertions
        org.assertj.core.api.Assertions.assertThat(updateEmployee.getEmail()).isEqualTo("maryam@gmail.com");
        org.assertj.core.api.Assertions.assertThat(updateEmployee.getFirstName()).isEqualTo("maryam");
    }

}
