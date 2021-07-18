import javax.persistence.*;


@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "idStudent")
    private Integer id;
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "id_group")
    private int id_group;
    @Column(name = "yearOfAdmission")
    private int yearOfAdmission;

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId_group() {
        return id_group;
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public void setYearOfAdmission(int yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    @Override
    public String toString() {
        return "Студент: " +
                "ИД - " + id +
                ", Имя - " + fullName +
                ", ИД группы - " + id_group +
                ", год поступления - " + yearOfAdmission
                ;
    }
}
