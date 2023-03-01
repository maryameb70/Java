package ir.mapsa.maryamebrahimzadesql14011205.org;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrgRepository {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/org", "root", "root");
    }

    public static void addWorker(Worker worker) throws Exception {
        if (worker == null) {
            throw new IllegalArgumentException("worker is null");
        }
        String insertQuery = "INSERT INTO Worker(WORKER_ID,FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES (?,?,?,?,?,?);";
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, worker.getWORKER_ID());
                preparedStatement.setString(2, worker.getFIRST_NAME());
                preparedStatement.setString(3, worker.getLAST_NAME());
                preparedStatement.setInt(4, worker.getSALARY());
                preparedStatement.setDate(5, (Date) worker.getJOINING_DATE());
                preparedStatement.setString(6, worker.getDEPARTMENT());
                preparedStatement.executeUpdate();
            }
        }
    }

    public static void addBonus(Bonus bonus) throws Exception {
        if (bonus == null) {
            throw new IllegalArgumentException("bonus is null");
        }
        String insertQuery = "insert into bonus (WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE)values(?,?,?);";
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, bonus.getWORKER_REF_ID());
                preparedStatement.setInt(2, bonus.getBONUS_AMOUNT());
                preparedStatement.setDate(3, (Date) bonus.getBONUS_DATE());
                preparedStatement.executeUpdate();
            }
        }
    }

    public static void addTitle(Title title) throws Exception {
        if (title == null) {
            throw new IllegalArgumentException("title is null");
        }
        String insertQuery = "insert into title (WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM)values (?,?,?);";
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, title.getWORKER_REF_ID());
                preparedStatement.setString(2, title.getWORKER_TITLE());
                preparedStatement.setDate(3, (Date) title.getAFFECTED_FROM());
                preparedStatement.executeUpdate();
            }
        }
    }

    private static void getWorker(ResultSet resultSet, List<Worker> workerList) throws SQLException {
        Worker worker = new Worker();
        worker.setWORKER_ID(resultSet.getInt("WORKER_ID"));
        worker.setFIRST_NAME(resultSet.getString("FIRST_NAME"));
        worker.setLAST_NAME(resultSet.getString("LAST_NAME"));
        worker.setSALARY(resultSet.getInt("SALARY"));
        worker.setJOINING_DATE(resultSet.getDate("JOINING_DATE"));
        worker.setDEPARTMENT(resultSet.getString("DEPARTMENT"));

        workerList.add(worker);
    }

    public static List<Worker> retrieveAllWorker(String Query) throws Exception {
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(Query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<Worker> workerList = new ArrayList<>();
                    while (resultSet.next()) {
                        getWorker(resultSet, workerList);
                    }
                    return workerList;
                }
            }
        }
    }

    public static List<Worker> questionOne() throws Exception {
        return retrieveAllWorker("select * from worker where JOINING_DATE LIKE '2014-02%';");
    }

    public static List<Title> questionTwo() throws Exception {
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("select t.WORKER_TITLE, t.AFFECTED_FROM, count(t.WORKER_REF_ID) as 'count' from title t\n" +
                    "group by t.WORKER_TITLE, t.AFFECTED_FROM;")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<Title> listResult = new ArrayList<>();
                    while (resultSet.next()) {
                        Title title = new Title();
                        title.setWORKER_TITLE(resultSet.getString("WORKER_TITLE"));
                        title.setAFFECTED_FROM(resultSet.getDate("AFFECTED_FROM"));
                        title.setTOTAL(resultSet.getInt("count"));
                        listResult.add(title);
                    }
                    return listResult;
                }
            }
        }
    }

    public static List<Worker> questionFour() throws Exception {
        return retrieveAllWorker("select * from worker inner join new_worker nw on worker.WORKER_ID = nw.WORKER_ID;");
    }

    public static List<Worker> questionFive() throws Exception {
        return retrieveAllWorker("select * from new_worker nw\n" +
                "where NOT EXISTS(select * from worker w where w.WORKER_ID = nw.WORKER_ID);");
    }

    public static List<Worker> questionSix() throws Exception {
        return retrieveAllWorker("select * from worker w\n" +
                "order by w.SALARY desc\n" +
                "LIMIT 4,1;");
    }

    public static List<Worker> questionSeven() throws Exception {
        return retrieveAllWorker("SELECT * FROM WORKER WHERE WORKER_ID <= (SELECT count(WORKER_ID)/2 from Worker);");
    }

    public static List<Worker> questionEight() throws Exception {
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("select DEPARTMENT from worker\n" +
                    "group by DEPARTMENT\n" +
                    "having count(DEPARTMENT) < 5;")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<Worker> workerList = new ArrayList<>();
                    while (resultSet.next()) {
                        Worker worker = new Worker();
                        worker.setDEPARTMENT(resultSet.getString("DEPARTMENT"));
                        workerList.add(worker);
                    }
                    return workerList;
                }
            }
        }
    }

    public static List<Worker> questionNine() throws Exception {
        return retrieveAllWorker("select * from worker\n" +
                "where SALARY IN (\n" +
                "    SELECT Max(SALARY) from worker group by DEPARTMENT\n" +
                "    )ORDER BY SALARY desc ;");
    }
}
