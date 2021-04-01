package lesson5;

public class StudentMainList {


    public static void main(String[] args) {
        StudentData[] studArray = new StudentData[7];
        StudentData student_0 = new StudentData(25, "Жигит", "Павел", "Алексеевич",
                1998, "Терешковой 22", 1234567, "FOI", 3, 21);
        StudentData student_1 = new StudentData(14, "Костев", "Виктор", "Олегович",
                1999, "Невского 9", 1258457, "FOI", 2, 212);
        StudentData student_2 = new StudentData(14, "Викторов", "Виктор", "Валерьевич",
                1997, "Братиславская 23", 121477, "KSF", 1, 42);
        StudentData student_3 = new StudentData(14, "Кравец", "Михаил", "Григорьевич",
                2001, "Невского 15", 126987, "UIS", 4, 213);
        StudentData student_4 = new StudentData(14, "Ткаченко", "Ксения", "Олегович",
                1998, "Суворова 121", 122132, "FOI", 3, 21);
        StudentData student_5 = new StudentData(14, "Ивлеева", "Анастасия", "Сергеевна",
                2002, "Михайловская 256", 128757, "EFF", 2, 213);
        StudentData student_6 = new StudentData(14, "Куртев", "Константин", "Михайлович",
                2000, "Маяковского 73", 1252427, "KSF", 1, 42);

        studArray[0] = student_0;
        studArray[1] = student_1;
        studArray[2] = student_2;
        studArray[3] = student_3;
        studArray[4] = student_4;
        studArray[5] = student_5;
        studArray[6] = student_6;
        System.out.println("Вывод списка студентов по заданному факульту");
        for (StudentData faculty : studArray) {
            faculty.faculty("FOI");


        }
        System.out.println("Вывод списка студентов по заданному факульту и курсу");
        for (StudentData facultyListGroup : studArray) {
            facultyListGroup.listFaculty("FOI", 3);
        }
        System.out.println("Cписок студентов, родившихся после заданного года");
        for (StudentData ageOfStudent : studArray) {
            ageOfStudent.ageOfStudent(2000);
        }
        System.out.println("Общий список студентов");
        for (StudentData allInfoOfGroups : studArray) {
            allInfoOfGroups.showAllStudentInfo();
        }
    }
}
