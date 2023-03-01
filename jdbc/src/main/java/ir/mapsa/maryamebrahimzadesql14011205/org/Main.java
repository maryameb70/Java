package ir.mapsa.maryamebrahimzadesql14011205.org;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Query1");
        OrgRepository.questionOne().forEach(System.out::println);

        System.out.println("Query2");
        OrgRepository.questionTwo().forEach(System.out::println);

        System.out.println("Query4");
        OrgRepository.questionFour().forEach(System.out::println);

        System.out.println("Query5");
        OrgRepository.questionFive().forEach(System.out::println);

        System.out.println("Query6");
        OrgRepository.questionSix().forEach(System.out::println);

        System.out.println("Query7");
        OrgRepository.questionSeven().forEach(System.out::println);

        System.out.println("Query8");
        OrgRepository.questionEight().forEach(System.out::println);

        System.out.println("Query9");
        OrgRepository.questionNine().forEach(System.out::println);

        Date date = new java.sql.Date(new java.util.Date().getTime());
        //insert to worker
        Worker worker=new Worker();
        worker.setWORKER_ID(11);
        worker.setFIRST_NAME("Sara");
        worker.setLAST_NAME("Amiri");
        worker.setSALARY(300000);
        worker.setJOINING_DATE(date);
        worker.setDEPARTMENT("Account");
        OrgRepository.addWorker(worker);

        //insert to bonus
        Bonus bonus=new Bonus();
        bonus.setWORKER_REF_ID(11);
        bonus.setBONUS_AMOUNT(3000);
        bonus.setBONUS_DATE(date);
        OrgRepository.addBonus(bonus);

        //insert to title
        Title title=new Title();
        title.setWORKER_REF_ID(11);
        title.setWORKER_TITLE("Executive");
        title.setAFFECTED_FROM(date);
        OrgRepository.addTitle(title);

    }
}
