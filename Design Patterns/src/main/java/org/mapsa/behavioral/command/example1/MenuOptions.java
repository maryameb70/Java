package org.mapsa.behavioral.command.example1;

import org.mapsa.behavioral.command.example2.TextFileOperation;

import java.util.ArrayList;
import java.util.List;

public class MenuOptions {
    private final List<ActionListenerCommand> listCommands= new ArrayList<>();
    private ActionListenerCommand clickOpen;
    private ActionListenerCommand clickSave;

    public MenuOptions(ActionListenerCommand clickOpen, ActionListenerCommand clickSave) {
        this.clickOpen = clickOpen;
        this.clickSave = clickSave;
    }

    public void clickOpen(){
        clickOpen.execute();
    }

    public void clickSave(){
        clickSave.execute();
    }
}
