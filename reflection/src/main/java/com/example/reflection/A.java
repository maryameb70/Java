package com.example.reflection;

import org.springframework.stereotype.Service;

@Service
public class A {
    public int field;
    private void f(){
        System.out.println("A.f() method invoked");
    }

    @Override
    public String toString() {
        return String.valueOf(field);
    }
}
