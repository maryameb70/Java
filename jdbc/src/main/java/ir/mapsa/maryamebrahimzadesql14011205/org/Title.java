package ir.mapsa.maryamebrahimzadesql14011205.org;

import java.util.Date;

public class Title {
    private int WORKER_REF_ID;
    private String WORKER_TITLE;
    private Date AFFECTED_FROM;
    private int TOTAL;

    public int getWORKER_REF_ID() {
        return WORKER_REF_ID;
    }

    public void setWORKER_REF_ID(int WORKER_REF_ID) {
        this.WORKER_REF_ID = WORKER_REF_ID;
    }

    public String getWORKER_TITLE() {
        return WORKER_TITLE;
    }

    public void setWORKER_TITLE(String WORKER_TITLE) {
        this.WORKER_TITLE = WORKER_TITLE;
    }

    public Date getAFFECTED_FROM() {
        return AFFECTED_FROM;
    }

    public void setAFFECTED_FROM(Date AFFECTED_FROM) {
        this.AFFECTED_FROM = AFFECTED_FROM;
    }

    public int getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(int TOTAL) {
        this.TOTAL = TOTAL;
    }

    @Override
    public String toString() {
        return "Title{" +
                "WORKER_REF_ID=" + WORKER_REF_ID +
                ", WORKER_TITLE='" + WORKER_TITLE + '\'' +
                ", AFFECTED_FROM=" + AFFECTED_FROM +
                ", TOTAL=" + TOTAL +
                '}';
    }
}
