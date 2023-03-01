package ir.mapsa.maryamebrahimzadesql14011205.org;

import java.util.Date;

public class Worker {
    private int WORKER_ID;
    private String FIRST_NAME;
    private String LAST_NAME;
    private int SALARY;
    private Date JOINING_DATE;
    private String DEPARTMENT;

    public int getWORKER_ID() {
        return WORKER_ID;
    }

    public void setWORKER_ID(int WORKER_ID) {
        this.WORKER_ID = WORKER_ID;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public int getSALARY() {
        return SALARY;
    }

    public void setSALARY(int SALARY) {
        this.SALARY = SALARY;
    }

    public Date getJOINING_DATE() {
        return JOINING_DATE;
    }

    public void setJOINING_DATE(Date JOINING_DATE) {
        this.JOINING_DATE = JOINING_DATE;
    }

    public String getDEPARTMENT() {
        return DEPARTMENT;
    }

    public void setDEPARTMENT(String DEPARTMENT) {
        this.DEPARTMENT = DEPARTMENT;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "WORKER_ID=" + WORKER_ID +
                ", FIRST_NAME='" + FIRST_NAME + '\'' +
                ", LAST_NAME='" + LAST_NAME + '\'' +
                ", SALARY=" + SALARY +
                ", JOINING_DATE=" + JOINING_DATE +
                ", DEPARTMENT='" + DEPARTMENT + '\'' +
                '}';
    }
}
