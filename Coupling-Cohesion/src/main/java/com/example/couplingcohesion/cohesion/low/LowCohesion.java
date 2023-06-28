package com.example.couplingcohesion.cohesion.low;

public class LowCohesion {
    public static void main(String[] args) {
        int a = 9;
        int b = 46;
        char c = 't';
        char d = 'o';

        CohesionExample obj = new CohesionExample();
        obj.addition(a, b);
        obj.findingVowel(c);
        obj.findingVowel(d);
    }
}
