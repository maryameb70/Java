package org.mapsa.structural.adapter.example4;

public class AdapterPatternDemo { //client class
    public static void main(String[] args) {
        CreditCard targetInterface=new BankCustomer();
        targetInterface.giveBankDetails();
        System.out.print(targetInterface.getCreditCard());
    }
}
