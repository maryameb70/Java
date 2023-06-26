package org.mapsa.behavioral.command.order;

public class BuyStock implements Order {  //concrete class
    private Stock abcStock;  //request

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
