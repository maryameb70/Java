package org.mapsa.structural.flyweight.exampletwo;

import java.awt.Color;
import java.awt.Graphics;

public class Line implements Shape {
    public Line(){
        System.out.println("Creating Line object");
        //adding time delay
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @Override
    public void draw(Graphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        g.drawLine(x, y, width, height);
    }
}
