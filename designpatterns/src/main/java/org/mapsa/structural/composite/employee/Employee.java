package org.mapsa.structural.composite.employee;

// this is the Employee interface i.e. Component.
public interface Employee {
     int getId();
    String getName();
    double getSalary();
    void print();
    void add(Employee employee);
    void remove(Employee employee);
    Employee getChild(int i);
}