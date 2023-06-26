package org.mapsa.behavioral.command.document;

public class Document { //Receiver of a Command
    public void open(){
        System.out.println("Document Opened");
    }
    public void save(){
        System.out.println("Document Saved");
    }
}
