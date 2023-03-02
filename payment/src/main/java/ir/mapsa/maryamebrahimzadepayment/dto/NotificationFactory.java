package ir.mapsa.maryamebrahimzadepayment.dto;

public class NotificationFactory {
    public static BaseNotification createNotification(Notify notify){
        if(notify==null){
            return null;
        }
        switch (notify) {
            case SMS:
                return new SmsNotification();
            case EMAIL:
                return new EmailNotification();
            default:
                throw new IllegalArgumentException("unknown notify");
        }
    }
}
