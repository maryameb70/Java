package org.mapsa.behavioral.command.example2;

public class TextFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//    public String open() {
//        return "Opening file " + name;
//    }

    public String save() {
        return "Saving file " + name;
    }

    public String edit() {
        return "editing file " + name;
    }

    public String write() {
        return "Writing file " + name;
    }
}
