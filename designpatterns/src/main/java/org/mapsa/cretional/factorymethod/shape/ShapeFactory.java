package org.mapsa.cretional.factorymethod.shape;

import org.mapsa.cretional.factorymethod.notification.EmailNotification;
import org.mapsa.cretional.factorymethod.notification.PushNotification;
import org.mapsa.cretional.factorymethod.notification.SMSNotification;

public class ShapeFactory {
    //use getShape method to get object of type shape
    public static Shape getShape(ShapeType type) {
        if(type==null){
            return null;
        }
        switch (type){
            case CIRCLE:
                return new Circle();
            case RECTANGLE:
                return new Rectangle();
            case SQUARE:
                return new Square();
            default:
                throw new IllegalArgumentException("Unknown type");
        }
    }
}
