package org.mapsa.behavioral.command.document;

public class CommandPatternClient {
    public static void main(String[] args) {
        //Creating the receiver object
        Document document = new Document();

        //creating command and associating with receiver
        ActionOpen actionOpen = new ActionOpen(document);
        ActionSave actionSave = new ActionSave(document);

        //Creating invoker and associating with Command
        MenuOptions menuOptions = new MenuOptions();

        menuOptions.takeOrder(actionOpen);
        menuOptions.takeOrder(actionSave);
        //perform action on invoker object
        menuOptions.placeOrders();
    }
}
