package org.mapsa.structural.proxy.example2;

public class PrintProxy implements Print {
    private final PrintClass printClass;

    public PrintProxy(PrintClass printClass) {
        this.printClass = printClass;
    }

    @Override
    public void print() {
        System.out.println("before call");
        printClass.print();
        System.out.println("After");
    }
}
class Main{
    public static void main(String[] args) {
        Print proxy=new PrintProxy(new PrintClass());
        proxy.print();
    }
}
