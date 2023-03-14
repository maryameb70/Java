package ir.mapsa.maryamebrahimzadepayment14011205.dto;

import java.util.Date;

public class Transaction {
   private Date date;
   private String senderCardNumber;
    private String recieverCardNumber;
    private Long amount;
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSenderCardNumber() {
        return senderCardNumber;
    }

    public void setSenderCardNumber(String senderCardNumber) {
        this.senderCardNumber = senderCardNumber;
    }

    public String getRecieverCardNumber() {
        return recieverCardNumber;
    }

    public void setRecieverCardNumber(String recieverCardNumber) {
        this.recieverCardNumber = recieverCardNumber;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
