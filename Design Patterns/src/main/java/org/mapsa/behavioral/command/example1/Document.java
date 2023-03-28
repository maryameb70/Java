package org.mapsa.behavioral.command.example1;

public class Document {
    private String value;

    public String getValue() {
        return value;
    }

    public void open() {
        value="open";
        System.out.println("Document"+value);
    }

    public void save() {
        value="save";
        System.out.println("Document"+value);
    }
}
