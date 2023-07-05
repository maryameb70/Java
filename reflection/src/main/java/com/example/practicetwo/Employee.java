package com.example.practicetwo;

import org.springframework.stereotype.Service;

@Service
public class Employee {
    private int eid;
    private double esal;
    private String ename;

    public Employee(int eid, double esal, String ename){
        super();
        this.eid = eid;
        this.esal = esal;
        this.ename = ename;
    }

    public int getEid(){
        return eid;
    }
    public void setEid(int eid,int num, char ch){
        this.eid = eid;
    }

    public double getEsal(){
        return esal;
    }
    public void setEsal(double esal,float data, String name){
        this.esal = esal;
    }

    public String getEname(){
        return ename;
    }
    public void setEname(String ename){
        this.ename = ename;
    }


    class A{
    }
    class B{
    }

    enum Week{
        SUN,TUE,WED;
    }
}
