package com.pasha.database;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/student?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "ofabid8090";

    public static void main(String[] args) {
        Connection connection;


        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено");
                int count = 2;
                for (int i = 0; i < count; i++) {
                    System.out.println("Выберите номер операции\n"+ "1. Добавить Студента в БД\n" +
                            "2. Удалить студента из БД\n" + "3. Получить всех студентоы из БД\n"+
                            "4. Получить студентов по ИД\n"+ "5. Получить студентов по имени\n" + "6. Завершить рвботу с БД");
                    Scanner scanner = new Scanner(System.in);
                    int res = scanner.nextInt();
                    switch (res) {
                        case 1:
                            addStrudent(connection);
                            count++;
                            break;
                        case 2:
                            deleteStrudent(connection);
                            count++;
                            break;
                        case 3:
                            getAllStudents(connection);
                            count++;
                            break;
                        case 4:
                            getAllStudentsFromId(connection);
                            count++;
                            break;
                        case 5:
                            getAllStudentsFromFullName(connection);
                            count++;
                            break;
                        case 6:
                            count=i;
                            break;
                    }
                }
            }
            connection.close();
            if (connection.isClosed()) {
                System.out.println("Соединение закрыто");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addStrudent(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ИД студента");
        int idStud = scanner.nextInt();
        System.out.println("Введите Имя студента");
        String fullName = scanner.next();
        System.out.println("Введите ИД группы студента");
        int idGp = scanner.nextInt();
        System.out.println("Введите год поступления студента");
        int yAdmin = scanner.nextInt();
        statement.execute("INSERT INTO `Students` (`idStudent`, `FullName`, `id_group`, `yearOfAdmission`)\n" +
                "VALUES ('" + idStud + "', '" + fullName + "', '" + idGp + "', " + yAdmin + ");");
    }

    public static void deleteStrudent(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        System.out.println("По какому из значений удалить данные из БД\n" + "Выберите номер операции\n" + "1. Удалить по ИД студента\n" +
                "2. Удалить по Имени студента\n" + "3. Удалить по ИД группы студента\n" + "4. Удалить по году поступления студента\n");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        statement.executeUpdate("SET foreign_key_checks = 0;");
        switch (count) {
            case 1:
                System.out.println("Введите ИД студента");
                int idStud = scanner.nextInt();
                statement.executeUpdate("delete from students WHERE idStudent = '" + idStud + "';");
                break;
            case 2:
                System.out.println("Введите Имя студента");
                String fullName = scanner.next();
                statement.executeUpdate("delete from students WHERE FullName = '" + fullName + "';");
                break;
            case 3:
                System.out.println("Введите ИД группы студента");
                int idGp = scanner.nextInt();
                statement.executeUpdate("delete from students WHERE id_group = '" + idGp + "';");
                break;
            case 4:
                System.out.println("Введите год поступления студента");
                int yAdmin = scanner.nextInt();
                statement.executeUpdate("delete from students WHERE yearOfAdmission = '" + yAdmin + "';");
                break;
        }
        statement.executeUpdate("SET foreign_key_checks = 1;");

    }

    public static void getAllStudents(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students");
        while (resultSet.next()) {
            System.out.println("id - " + resultSet.getInt(1) + " Name - " + resultSet.getString(2) +
                    " id Group - " + resultSet.getInt(3) + " year of admission - " + resultSet.getInt(4));
            System.out.println("-----------");
        }
        ResultSet resultSet1 = statement.executeQuery("select * from students WHERE idStudent = '5'");
        while (resultSet1.next()) {
            System.out.println("id - " + resultSet1.getInt(1) + " Name - " + resultSet1.getString(2) +
                    " id Group - " + resultSet1.getInt(3) + " year of admission - " + resultSet1.getInt(4));
            System.out.println("-----------");
        }
    }

    public static void getAllStudentsFromId(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ИД студента");
        int idStud = scanner.nextInt();
        ResultSet resultSet = statement.executeQuery("select * from students WHERE idStudent = '" + idStud + "'");
        while (resultSet.next()) {
            System.out.println("id - " + resultSet.getInt(1) + " Name - " + resultSet.getString(2) +
                    " id Group - " + resultSet.getInt(3) + " year of admission - " + resultSet.getInt(4));
            System.out.println("-----------");
        }
    }
    public static void getAllStudentsFromFullName(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Имя студента");
        String studName = scanner.nextLine();
        ResultSet resultSet = statement.executeQuery("select * from students WHERE FullName = '" + studName + "'");
        while (resultSet.next()) {
            System.out.println("id - " + resultSet.getInt(1) + " Name - " + resultSet.getString(2) +
                    " id Group - " + resultSet.getInt(3) + " year of admission - " + resultSet.getInt(4));
            System.out.println("-----------");
        }
    }
}
