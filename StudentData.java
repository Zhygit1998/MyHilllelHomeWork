package lesson5;

public class StudentData {
    private int id;
    private String lastName;
    private String name;
    private String surName;
    private int yearBirthday;
    private String address;
    private int phoneNumber;
    private String faculty;
    private int course;
    private int group;


    public StudentData(int id, String lastName, String name, String surName, int yearBirthday,
                       String address, int phoneNumber, String faculty, int course, int group) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.surName = surName;
        this.yearBirthday = yearBirthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getYearBirthday() {
        return yearBirthday;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getCourse() {
        return course;
    }

    public int getGroup() {
        return group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setYearBirthday(int yearBirthday) {
        this.yearBirthday = yearBirthday;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "StudentData{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", yearBirthday=" + yearBirthday +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", group=" + group +
                '}';
    }


    public void showAllStudentInfo(){
        System.out.println(getId() + " " + getLastName() + " " + getName() + " " + getSurName() + " " + getYearBirthday() + " " + getAddress() + " " + getPhoneNumber() + " " + getFaculty()
                + " " + getCourse() + " " + getGroup());
    }

    public void faculty(String faculty){
        if(this.getFaculty().equals(faculty)){
            System.out.println(getId() + " " + getLastName() + " " + getName() + " " + getSurName() + " " + getYearBirthday() + " " + getAddress() + " " + getPhoneNumber() + " " + getFaculty()
                    + " " + getCourse() + " " + getGroup());
        }
    }
    public void listFaculty(String faculty, int course){

        if(getFaculty().equals(faculty) && getCourse() == course){

            System.out.println(getId() + " " + getLastName() + " " + getName() + " " + getSurName() + " " + getYearBirthday() + " " + getAddress() + " " + getPhoneNumber() + " " + getFaculty()
                    + " " + getCourse() + " " + getGroup());
        }
    }

    public void ageOfStudent(int years){
        if(getYearBirthday()==years+1){
            System.out.println(getId() + " " + getLastName() + " " + getName() + " " + getSurName() + " " + getYearBirthday() + " " + getAddress() + " " + getPhoneNumber() + " " + getFaculty()
                    + " " + getCourse() + " " + getGroup());
        }
    }
}
