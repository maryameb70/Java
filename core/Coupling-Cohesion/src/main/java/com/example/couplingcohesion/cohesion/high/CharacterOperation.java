package com.example.couplingcohesion.cohesion.high;

public class CharacterOperation {
    public void findingVowel(char a) {
        switch (a) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println(a + " is a vowel.");
                break;
            default:
                System.out.println(a + " is not a vowel.");

        }
    }
}
