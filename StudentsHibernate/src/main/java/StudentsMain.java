import org.hibernate.ScrollableResults;
import org.hibernate.Session;

import java.util.Scanner;

public class StudentsMain {

    public static void main(final String[] args) throws Exception {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            int count = 2;
            for (int i = 0; i < count; i++) {
                System.out.println("Выберите номер операции\n" + "1. Добавить Студента в БД\n" +
                        "2. Получить всех студентоы из БД\n" +
                        "3. Получить студентов по ИД\n" + "4. Получить студентов по имени\n" + "5. Завершить рвботу с БД");
                Scanner scanner = new Scanner(System.in);
                int res = scanner.nextInt();
                switch (res) {
                    case 1:
                        addStudents(session);
                        count++;
                        break;
                    case 2:
                        getAllStudents(session);
                        count++;
                        break;
                    case 3:
                        getStudentsFromId(session);
                        count++;
                        break;
                    case 4:
                        getStudentsFromName(session);
                        count++;
                        break;
                    case 5:
                        count = i;
                        break;
                    default:
                        count = i;
                        break;
                }
            }
         getAllStudents(session);
         getStudentsFromId(session);
         getStudentsFromName(session);
        } catch (Throwable cause) {
            cause.printStackTrace();
        }


    }

    public static void addStudents(Session session) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ИД студента");
        int idStud = scanner.nextInt();
        System.out.println("Введите Имя студента");
        String fullName = scanner.next();
        System.out.println("Введите ИД группы студента");
        int idGp = scanner.nextInt();
        System.out.println("Введите год поступления студента");
        int yAdmin = scanner.nextInt();
        Student students = new Student();
        students.setId(idStud);
        students.setFullName(fullName);
        students.setId_group(idGp);
        students.setYearOfAdmission(yAdmin);
        session.save(students);
        session.getTransaction().commit();
    }

    public static void getAllStudents(Session session) {
        session.createQuery("from Student")
                .list()
                .forEach(System.out::println);
    }

    public static void getStudentsFromId(Session session) {
        System.out.println("Введите ИД студента которого хотите получить из БД");
        Scanner scanner = new Scanner(System.in);
        int idCount = scanner.nextInt();
        ScrollableResults student = session.createQuery("from Student as p where p.id = " + "'" + idCount + "'")
                .scroll();
        while (student.next()) {
            System.out.println(student.get()[0]);
        }
    }

    public static void getStudentsFromName(Session session) {
        System.out.println("Введите Имя студента которого хотите получить из БД");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        ScrollableResults student = session.createQuery("from Student as p where p.fullName = " + "'" + name + "'")
                .scroll();
        while (student.next()) {
            System.out.println(student.get()[0]);
        }
    }

}