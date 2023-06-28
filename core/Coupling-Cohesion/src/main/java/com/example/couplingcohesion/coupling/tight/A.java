package com.example.couplingcohesion.coupling.tight;

public class A {
    private B b;

    public A() {
        b=new B(); //b is tightly coupled to A
    }
    public void display() {
        System.out.println("A");
        b.display();
    }
}
