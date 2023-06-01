package org.mapsa.cretional.builder;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Sample {
    private  static Boolean admin;
    public void print(){
        System.out.println("hello");
    }

    public static class  InnerClass{
        public void print2(){

            System.out.println("by" + this.);
        }
    }
}
