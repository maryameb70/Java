package org.mapsa.behavioral.command.document;

import java.util.ArrayList;
import java.util.List;

public class MenuOptions { //command invoker class
    private List<ActionListenerCommand> action=new ArrayList<>();
    public void takeOrder(ActionListenerCommand actionListenerCommand){
        action.add(actionListenerCommand);
    }
    public void placeOrders(){
        for(ActionListenerCommand ac:action){
            ac.execute();
        }
        action.clear();
    }
}
