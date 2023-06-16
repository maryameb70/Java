package org.mapsa.structural.composite.employee;

public class CompositePatternDemo {
    public static void main(String[] args) {
        Employee emp1=new Cashier(101,"Maryam Ebrahimzade", 20000.0);
        Employee emp2=new Cashier(102,"Arezo Alipanah", 25000.0);
        Employee emp3=new Accountant(103,"Jeiran Akhavan", 30000.0);
        Employee manager1=new BankManager(100,"Asma Amiri",100000.0);

        manager1.add(emp1);
        manager1.add(emp2);
        manager1.add(emp3);
        manager1.print();
    }
}
