package com.example.couplingcohesion.coupling.tight;

public class TightCoupling {
    public static void main(String[] args) {
        A a=new A();
        a.display(); //this implementation can not be changed dynamically,being tight coupling
    }
}
