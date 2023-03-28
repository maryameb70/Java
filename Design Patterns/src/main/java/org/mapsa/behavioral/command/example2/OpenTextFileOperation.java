package org.mapsa.behavioral.command.example2;

public class OpenTextFileOperation implements TextFileOperation{
    private TextFile textFile;

    public OpenTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.open();
    }
}
