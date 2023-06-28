package com.example.couplingcohesion.cohesion.low;

public class CohesionExample {
    // method for adding two numbers
    public void addition(int a, int b)
    {
        int sum = a + b;
        System.out.println("Addition of the numbers " + a + " and " + b + " is: " + sum);
    }

    // method for checking the vowels and consonants
    public void findingVowel(char a)
    {
        switch(a)
        {
            case 'a' :
            case 'e' :
            case 'i' :
            case 'o' :
            case 'u' :
                System.out.println(a + " is a vowel.");
                break;
            default:
                System.out.println(a + " is not a vowel.");
        }
    }

}
