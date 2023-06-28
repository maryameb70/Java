package com.example.couplingcohesion.coupling.loose;

public class A {
    Show s;

    public A(Show s) {
        this.s = s;  //s is loosely coupled to A
    }
    public void display() {
        System.out.println("A");
        s.display();
    }
}
