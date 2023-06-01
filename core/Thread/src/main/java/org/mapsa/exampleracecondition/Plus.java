package org.mapsa.exampleracecondition;

public class Plus implements Runnable{
    private int value;

    public Plus(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        value++;
        System.out.println(value);
    }
}
