package org.mapsa.cretional.prototype;

public class Prototype implements Clonable {
    private int someInt;
    private String someString;

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    @Override
    public Prototype clone() {
        Prototype cloned = new Prototype();
        cloned.setSomeInt(this.someInt);
        cloned.setSomeString(this.someString);
        return cloned;
    }

    public Prototype copy() {
        return this;
    }

    public Prototype deepCopy() {
        return this.clone();
    }
}

class Main {
    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        prototype.setSomeInt(2);
        prototype.setSomeString("maryam");
        Prototype copy=prototype.copy();
        copy.setSomeString("copy");

        Prototype clone=prototype.deepCopy();
        clone.setSomeString("clone");

        System.out.println(prototype.getSomeString().equals(copy.getSomeString())); // true
        System.out.println(prototype.getSomeString().equals(clone.getSomeString())); // false
    }
}

