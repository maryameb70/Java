package ir.mapsa.maryamebrahimzadesql14011205.org;

import java.util.Date;

public class Bonus {
    private int WORKER_REF_ID;
    private int BONUS_AMOUNT;
    private Date BONUS_DATE;

    public int getWORKER_REF_ID() {
        return WORKER_REF_ID;
    }

    public void setWORKER_REF_ID(int WORKER_REF_ID) {
        this.WORKER_REF_ID = WORKER_REF_ID;
    }

    public int getBONUS_AMOUNT() {
        return BONUS_AMOUNT;
    }

    public void setBONUS_AMOUNT(int BONUS_AMOUNT) {
        this.BONUS_AMOUNT = BONUS_AMOUNT;
    }

    public Date getBONUS_DATE() {
        return BONUS_DATE;
    }

    public void setBONUS_DATE(Date BONUS_DATE) {
        this.BONUS_DATE = BONUS_DATE;
    }

    @Override
    public String toString() {
        return "Bonus{" +
                "WORKER_REF_ID=" + WORKER_REF_ID +
                ", BONUS_AMOUNT='" + BONUS_AMOUNT + '\'' +
                ", BONUS_DATE=" + BONUS_DATE +
                '}';
    }
}
