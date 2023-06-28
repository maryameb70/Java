package com.example.couplingcohesion.coupling.loose;

public class LooseCoupling {
    public static void main(String[] args) {
        Show b=new B();
        Show c = new C();

        A a=new A(b);
        a.display();

        A a1=new A(c);
        a1.display();
    }
}
