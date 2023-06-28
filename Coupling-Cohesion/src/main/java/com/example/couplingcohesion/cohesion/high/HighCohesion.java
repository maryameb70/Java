package com.example.couplingcohesion.cohesion.high;

public class HighCohesion {
    public static void main(String[] args) {
        int a = 9;
        int b = 46;
        char c = 't';
        char d = 'o';
        ArithmeticOperation obj = new ArithmeticOperation();
        CharacterOperation obj1 = new CharacterOperation();
        obj.addition(a, b);
        obj1.findingVowel(c);
        obj1.findingVowel(d);
    }
}
